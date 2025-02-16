package com.example.diploma.repository;

import com.example.diploma.entity.Form;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Form, UUID> {

}
