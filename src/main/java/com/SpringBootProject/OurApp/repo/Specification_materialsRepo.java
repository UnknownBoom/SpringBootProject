package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Specification_furniture;
import com.SpringBootProject.OurApp.model.Specification_materials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Specification_materialsRepo extends JpaRepository<Specification_materials, Long> {
}
