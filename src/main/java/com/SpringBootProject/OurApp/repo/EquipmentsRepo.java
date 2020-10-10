package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Equipments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentsRepo extends JpaRepository<Equipments,String> {
}
