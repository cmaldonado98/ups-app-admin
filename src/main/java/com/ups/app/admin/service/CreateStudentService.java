package com.ups.app.admin.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface CreateStudentService {

    ResponseEntity<String> readFileCreateStudent(MultipartFile file);
}
