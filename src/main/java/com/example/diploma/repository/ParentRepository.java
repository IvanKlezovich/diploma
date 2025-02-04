package com.example.diploma.repository;

import com.example.diploma.entity.Parent;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, UUID> {

}
