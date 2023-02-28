package com.ups.app.admin.repository.impl;

import com.google.gson.JsonObject;
import com.ups.app.admin.repository.StudentRepository;
import com.ups.app.admin.service.dto.Auth.ResponseAuthDto;
import com.ups.app.admin.service.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    @Value("${app.apikey}")
    String apiKey;

    @Value("${app.token}")
    String token;


    String urlAuth = "https://ryywbodcbzdifqoaarye.supabase.co/auth/v1/signup";

    String urlStudent = "https://ryywbodcbzdifqoaarye.supabase.co/rest/v1/Student";

    private final RestTemplate restTemplate;

    public ResponseEntity<JsonObject> createStudent(StudentDto studentDto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apikey", apiKey);
        headers.set("token", token);
        headers.set("Content-Type", "application/json");
        headers.set("Prefer", "return=minimal");

        ResponseEntity<ResponseAuthDto> responseAuthDto = createStudentAuth(studentDto);


        JsonObject jsonStudent = new JsonObject();
        jsonStudent.addProperty("pseudonim", studentDto.getAlias());
        jsonStudent.addProperty("id_user", Objects.requireNonNull(responseAuthDto.getBody()).getId());
        jsonStudent.addProperty("email", studentDto.getEmail());

        String body = jsonStudent.toString();
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        return restTemplate.exchange(urlStudent,
                HttpMethod.POST, request, JsonObject.class);


    }

    private ResponseEntity<ResponseAuthDto> createStudentAuth(StudentDto studentDto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apikey", apiKey);

        JsonObject jsonStudent = new JsonObject();
        jsonStudent.addProperty("email", studentDto.getEmail());
        jsonStudent.addProperty("password", studentDto.getPassword());

        String body = jsonStudent.toString();
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        return restTemplate.exchange(urlAuth,
                HttpMethod.POST, request, ResponseAuthDto.class);


    }

}
