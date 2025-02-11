package com.example.diploma.repository;

import com.example.diploma.entity.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DairyRepository extends JpaRepository<DayOfWeek, Long> {
}
