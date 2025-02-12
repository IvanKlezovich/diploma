package com.example.diploma.repository;

import com.example.diploma.entity.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DairyRepository extends JpaRepository<DayOfWeek, Long> {

  @Query("""
          select dw
          from DayOfWeek dw
          where dw.name = :dayOfWeek
          """)
  DayOfWeek getDayOfWeekByName(@Param("dayOfWeek") String dayOfWeek);
}
