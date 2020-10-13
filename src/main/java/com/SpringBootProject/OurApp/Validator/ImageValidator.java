package com.SpringBootProject.OurApp.Validator;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;


@Component
public class ImageValidator{
    public static void validate(MultipartFile uploadedFile, Model model) {
        if(uploadedFile.isEmpty() || uploadedFile.getSize()==0)
            model.addAttribute("imageError", "Please select a file");
//            model.addAttribute("errors",errors);
        if(!(uploadedFile.getContentType().toLowerCase().equals("image/jpg")
                || uploadedFile.getContentType().toLowerCase().equals("image/jpeg")
                || uploadedFile.getContentType().toLowerCase().equals("image/png"))){
            model.addAttribute("imageError", "jpg/png file types are only supported");
//            model.addAttribute("errors",errors);
        }
        if(uploadedFile.getSize()>41681549){
            model.addAttribute("imageError", "file is too long");
//            model.addAttribute("errors",errors);
        }
    }
}