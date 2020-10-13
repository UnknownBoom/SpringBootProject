package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.Validator.ImageValidator;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.FurnituresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RequestMapping("/upload/users")
@Controller
public class FurnituresFileController {

    @Autowired
    FurnituresRepo furnituresRepo;


//    @PostMapping()
//    public  String HandleFileUpload(
//            @RequestParam MultipartFile file,
//                                    Model model) {
//        ImageValidator.validate(file,model);
//        if(model.getAttribute("imageError")!=null){
//            return "redirect:/tables/furnitures";
//        }
//        furnituresRepo.save()
//
//        model.addAttribute("user",byId);
//        return "redirect:/user_profile";
//    }
}
