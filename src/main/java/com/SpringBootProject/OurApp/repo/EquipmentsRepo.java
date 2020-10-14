package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Equipments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentsRepo extends JpaRepository<Equipments,String> {
    Iterable<Equipments> findByMarkContaining(String mark);
}
