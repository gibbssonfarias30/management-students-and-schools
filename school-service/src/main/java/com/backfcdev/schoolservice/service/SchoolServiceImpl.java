package com.backfcdev.schoolservice.service;

import com.backfcdev.schoolservice.client.IStudentClient;
import com.backfcdev.schoolservice.dto.FullSchoolResponse;
import com.backfcdev.schoolservice.model.School;
import com.backfcdev.schoolservice.repository.ISchoolRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements ISchoolService{

    private final ISchoolRepository schoolRepository;
    private final IStudentClient studentClient;


    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public School update(Long id, School school) {
        schoolRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return schoolRepository.save(school);
    }

    @Override
    public void delete(Long id) {
        schoolRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        schoolRepository.deleteById(id);
    }

    @Override
    public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(Long.valueOf(schoolId))
                .orElseThrow(EntityNotFoundException::new);

        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }


}
