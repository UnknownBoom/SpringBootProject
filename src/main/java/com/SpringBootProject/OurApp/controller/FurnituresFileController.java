package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.Validator.ImageValidator;
import com.SpringBootProject.OurApp.model.Furnitures;
import com.SpringBootProject.OurApp.repo.FurnituresRepo;
import org.apache.tomcat.util.http.fileupload.impl.InvalidContentTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@RequestMapping("/upload/users")
@Controller
public class FurnituresFileController {

    @Autowired
    private FurnituresRepo furnituresRepo;
    @Value("{upload_path}")
    private String upload_path;


    public  void HandleFileUpload(Furnitures furnitures, MultipartFile file) throws IOException {
        if(file!=null){
            boolean validate = ImageValidator.validate(file, null);
            if(!validate){
                throw new InvalidContentTypeException();
            }
        }
        File up_dir = new File(upload_path);
        if(!up_dir.exists()){
            if(!up_dir.mkdir()){
                throw new IOException("Unable to create directory");
            }
        }
        String uuid = UUID.randomUUID().toString();
        String result_path =uuid +  file.getName();
        furnitures.setImage_name(result_path);
        file.transferTo(Paths.get(upload_path+"/furnitures/"+result_path));
    }
}
