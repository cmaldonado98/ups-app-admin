package com.ups.app.admin.service.impl;

import com.ups.app.admin.repository.StudentRepository;
import com.ups.app.admin.service.CreateStudentService;
import com.ups.app.admin.service.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class CreateStudentServiceImpl implements CreateStudentService {

    private final StudentRepository studentRepository;

    public ResponseEntity<String> readFileCreateStudent(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    // saltar la primera fila (encabezados)
                    continue;
                }

                studentRepository.createStudent(StudentDto.builder()
                        .email(row.getCell(0).getStringCellValue())
                        .password(String.valueOf(row.getCell(1).getNumericCellValue()))
                        .alias(row.getCell(2).getStringCellValue())
                        .build());
            }

            return ResponseEntity.ok("Archivo subido exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo: " + e.getMessage());
        }
    }
}
