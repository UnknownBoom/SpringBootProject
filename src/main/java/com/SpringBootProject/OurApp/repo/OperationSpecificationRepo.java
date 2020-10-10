package com.SpringBootProject.OurApp.repo;


import com.SpringBootProject.OurApp.model.OperationSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface OperationSpecificationRepo extends JpaRepository<OperationSpecification,Long> {
    Optional<OperationSpecification> findById(Long Id);

}

