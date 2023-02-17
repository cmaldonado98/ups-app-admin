package com.ups.app.admin.repository.impl;

import com.google.gson.JsonObject;
import com.ups.app.admin.repository.SubjectRepository;
import com.ups.app.admin.service.dto.RequestCreateSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
@RequiredArgsConstructor
public class SubjectRepositoryImpl implements SubjectRepository {

    @Value("${app.apikey}")
    String apiKey;

    @Value("${app.token}")
    String token;

    @Value("${app.url}")
    String url;

    private final RestTemplate restTemplate;

    public Object createSubject(RequestCreateSubject requestCreateSubject) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apikey", apiKey);
        headers.set("Authorization", "Bearer " + token);

        JsonObject json = new JsonObject();
        json.addProperty("id_teacher", requestCreateSubject.getIdTeacher());
        json.addProperty("id_student", requestCreateSubject.getIdStudent());
        json.addProperty("initTime", requestCreateSubject.getInitTime());
        json.addProperty("endTime", requestCreateSubject.getEndTime());
        json.addProperty("id_class", requestCreateSubject.getIdClass());
        json.addProperty("date", requestCreateSubject.getDate());

        String body = json.toString();
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url,
                HttpMethod.POST, request, JsonObject.class);
    }

}
