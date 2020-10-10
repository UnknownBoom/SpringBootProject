package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Materials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsRepo extends JpaRepository<Materials,String> {
}
