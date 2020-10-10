package com.SpringBootProject.OurApp.repo;


import com.SpringBootProject.OurApp.model.Specification_furniture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Specification_furnitureRepo extends JpaRepository<Specification_furniture,Long> {
}
