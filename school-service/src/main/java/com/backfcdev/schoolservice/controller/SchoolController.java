package com.backfcdev.schoolservice.controller;


import com.backfcdev.schoolservice.dto.FullSchoolResponse;
import com.backfcdev.schoolservice.model.School;
import com.backfcdev.schoolservice.service.ISchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final ISchoolService schoolService;


    @GetMapping
    ResponseEntity<List<School>> findAll(){
        return ResponseEntity.ok(schoolService.findAll());
    }

    @PostMapping
    ResponseEntity<School> save(@RequestBody School school){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(schoolService.save(school));
    }

    @GetMapping("/{id}")
    ResponseEntity<School> findById(@PathVariable Integer id){
        return ResponseEntity.ok(schoolService.findById(id));
    }

    @GetMapping("/with-students/{schoolId}")
    ResponseEntity<FullSchoolResponse> findSchoolWithStudents(@PathVariable Integer schoolId){
        return ResponseEntity.ok(schoolService.findSchoolWithStudents(schoolId));
    }
}
