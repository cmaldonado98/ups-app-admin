package com.ups.app.admin.repository;

import com.ups.app.admin.service.dto.RequestCreateSubject;

public interface SubjectRepository {

    Object createSubject(RequestCreateSubject requestCreateSubject);
}
