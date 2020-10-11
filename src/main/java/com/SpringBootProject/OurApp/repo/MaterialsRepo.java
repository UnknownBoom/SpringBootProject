package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Materials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialsRepo extends JpaRepository<Materials,String> {

    List<Materials> findByArticleContaining(String article);
}
