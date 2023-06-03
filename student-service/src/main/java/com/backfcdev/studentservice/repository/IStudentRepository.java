package com.backfcdev.studentservice.repository;

import com.backfcdev.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllBySchoolId(Integer schoolId);
}
