package com.backfcdev.studentservice.service;

import com.backfcdev.studentservice.model.Student;
import com.backfcdev.studentservice.repository.IStudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements IStudentService{

    private final IStudentRepository studentRepository;


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Student update(Long id, Student student) {
        studentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
