package com.SpringBootProject.OurApp.service;

import com.SpringBootProject.OurApp.model.Furnitures;
import com.SpringBootProject.OurApp.repo.FurnituresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FurnituresService {

    @Autowired
    FurnituresRepo  furnituresRepo;

    @Value("${upload_path}")
    private String upload_path;

    public void saveFurniture(Furnitures furniture){
        furnituresRepo.save(furniture);
    }

    public InputStream getFile(String  article,String fileName) throws IOException {
        InputStream is;
        try {
            is = new BufferedInputStream(new FileInputStream(upload_path+"/furnitures/"+fileName));
        } catch (IOException ex) {
            return null;
        }
        return is;
    }
}
