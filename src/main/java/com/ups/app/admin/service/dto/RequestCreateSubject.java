package com.ups.app.admin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class RequestCreateSubject {

    String idTeacher;
    String idStudent;
    String date;
    String initTime;
    String endTime;
    String idClass;

}
