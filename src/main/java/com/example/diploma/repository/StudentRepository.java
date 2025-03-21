package com.example.diploma.repository;

import com.example.diploma.entity.Student;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

  List<Student> findAllByForm_Id(UUID formId);
}
