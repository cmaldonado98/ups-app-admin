package com.ups.app.admin.controller;

import com.ups.app.admin.service.CreateStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final CreateStudentService createStudentService;

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestParam MultipartFile file) {

        return new ResponseEntity<>(createStudentService.readFileCreateStudent(file), HttpStatus.OK);
    }
}
