package com.backfcdev.schoolservice.service;


import com.backfcdev.schoolservice.dto.FullSchoolResponse;
import com.backfcdev.schoolservice.model.School;

import java.util.List;

public interface ISchoolService {
    List<School> findAll();
    School save(School school);
    School findById(Integer id);
    School update(Integer id, School school);
    void delete(Integer id);
    FullSchoolResponse findSchoolWithStudents(Integer schoolId);
}
