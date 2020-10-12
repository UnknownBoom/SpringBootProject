package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import com.SpringBootProject.OurApp.service.UsersFileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
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

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/upload/users")
public class UsersFileController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private UsersFileService usersFileService;

    @Value("${upload_path_users}")
    private String upload_path;


    @PostMapping
    public String HandleFileUpload(@AuthenticationPrincipal Users user, @RequestParam MultipartFile file, Model model) throws IOException {
        Users byId = usersRepo.findUsersById(user.getId());
        usersFileService.saveFile(file,byId);
        model.addAttribute("user",byId);
        return "user_profile";

    }

    @GetMapping("/{id}/{file_name}")
    public void getFile(
            @PathVariable Long id,
            @PathVariable("file_name") String fileName,
            HttpServletResponse response) {
        Users usersById = usersRepo.findUsersById(id);
        try {
            // get your file as InputStream
            InputStream is = new BufferedInputStream(new FileInputStream(upload_path+"/"+usersById.getPhoto_name()));
            // copy it to response's OutputStream
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }

    }




}
