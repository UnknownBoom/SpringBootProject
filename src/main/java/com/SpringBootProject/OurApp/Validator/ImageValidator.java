package com.SpringBootProject.OurApp.Validator;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;



@Component
public class ImageValidator{
    public static void validate(MultipartFile uploadedFile, Model model) {
        if(uploadedFile.isEmpty() || uploadedFile.getSize()==0)
            model.addAttribute("errors", "Please select a file");
        if(!(uploadedFile.getContentType().toLowerCase().equals("image/jpg")
                || uploadedFile.getContentType().toLowerCase().equals("image/jpeg")
                || uploadedFile.getContentType().toLowerCase().equals("image/png"))){
            model.addAttribute("errors", "jpg/png file types are only supported");
        }
    }
}