package com.example.diploma.repository;

import com.example.diploma.entity.Schedules;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DairyRepository extends JpaRepository<Schedules, UUID> {

  Schedules getSchedulesByDays(String day);
}
