package com.example.diploma.repository;

import com.example.diploma.entity.Schedules;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulerRepository extends JpaRepository<Schedules, UUID> {

  List<Schedules> findAllByFormId(UUID formId);

  Schedules findByFormIdAndDays(UUID id, String day);
}
