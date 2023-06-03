package com.backfcdev.studentservice.controller;


import com.backfcdev.studentservice.model.Student;
import com.backfcdev.studentservice.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final IStudentService studentService;


    @GetMapping
    ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping
    ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.save(student));
    }

    @GetMapping("/{id}")
    ResponseEntity<Student> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/school/{schoolId}")
    ResponseEntity<List<Student>> findAllStudentsBySchool(@PathVariable Integer schoolId){
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }
}
