package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import com.SpringBootProject.OurApp.service.UsersFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/upload/users")
public class UsersFileController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private UsersFileService usersFileService;


    @PostMapping
    public String HandleFileUpload(@AuthenticationPrincipal Users user, @RequestParam MultipartFile file, Model model) throws IOException {
        usersFileService.saveFile(file,user);
        model.addAttribute("user",user);
        return "user_profile";

    }



}
