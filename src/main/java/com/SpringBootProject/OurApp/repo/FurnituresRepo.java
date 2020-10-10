package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Furnitures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnituresRepo extends JpaRepository<Furnitures, String> {
    Iterable<Furnitures> findAllByArticleLike(String article);
}
