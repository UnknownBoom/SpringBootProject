package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuppliersRepo extends JpaRepository<Suppliers,Long> {
    Optional<Suppliers> findById(Long id);

}
