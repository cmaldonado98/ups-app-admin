package com.ups.app.admin.repository;

import com.google.gson.JsonObject;
import com.ups.app.admin.service.dto.StudentDto;
import org.springframework.http.ResponseEntity;

public interface StudentRepository {

    ResponseEntity<JsonObject> createStudent(StudentDto studentDto);
}
