package com.ups.app.admin.controller;

import com.ups.app.admin.repository.SubjectRepository;
import com.ups.app.admin.service.dto.RequestCreateSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final SubjectRepository subjectRepository;


    @GetMapping
    public ResponseEntity<Object> subjectEntityResponseEntity(@RequestBody RequestCreateSubject requestCreateSubject) {

        return new ResponseEntity<>(subjectRepository.createSubject(requestCreateSubject), HttpStatus.OK);
    }
}
