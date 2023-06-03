package com.backfcdev.schoolservice.service;


import com.backfcdev.schoolservice.dto.FullSchoolResponse;
import com.backfcdev.schoolservice.model.School;

import java.util.List;

public interface ISchoolService {
    List<School> findAll();
    School save(School school);
    School findById(Long id);
    School update(Long id, School school);
    void delete(Long id);
    FullSchoolResponse findSchoolWithStudents(Integer schoolId);
}
