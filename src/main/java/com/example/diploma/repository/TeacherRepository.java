package com.example.diploma.repository;

import com.example.diploma.entity.Teacher;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

  @Query("""
      select t
      from Teacher t
      where t.name.firstname = :firstname 
              and t.name.lastname = :lastname 
              and t.name.surname = :surname
      """)
  Teacher getTeacherByFirstnameAndLastnameAndSurname(@Param("firstname") String firstname,
      @Param("lastname") String lastname, @Param("surname") String surname);
}
