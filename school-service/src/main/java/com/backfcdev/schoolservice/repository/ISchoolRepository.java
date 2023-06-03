package com.backfcdev.schoolservice.repository;

import com.backfcdev.schoolservice.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISchoolRepository extends JpaRepository<School, Integer> {
}
