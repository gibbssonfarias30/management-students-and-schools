package com.backfcdev.schoolservice.client;

import com.backfcdev.studentservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "student-service",
        url = "${app.config.student-url}"
)
public interface IStudentClient {

    @GetMapping("/school/{schoolId}")
    List<Student> findAllStudentsBySchool(@PathVariable Integer schoolId);
}
