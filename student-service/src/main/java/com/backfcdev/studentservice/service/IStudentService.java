package com.backfcdev.studentservice.service;

import com.backfcdev.studentservice.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student save(Student student);
    Student findById(Long id);
    Student update(Long id, Student student);
    void delete(Long id);
    List<Student> findAllStudentsBySchool(Integer schoolId);
}
