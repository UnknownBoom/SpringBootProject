package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import com.SpringBootProject.OurApp.service.UsersFileService;
import jdk.jfr.ContentType;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

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
    public String HandleFileUpload(@AuthenticationPrincipal Users user,
                                   @RequestParam MultipartFile file,
                                   Model model) {
        Users byId = usersRepo.findUsersById(user.getId());
        try {
            usersFileService.saveFile(file,byId);
        } catch (SQLException throwables) {
            byId = usersRepo.findUsersById(user.getId());
            System.out.println(throwables);
            model.addAttribute("errors",throwables.getMessage());
        }catch (IOException e){
            model.addAttribute("errors","System error");
            System.out.println(e.getMessage());
        }
        model.addAttribute("user",byId);
        return "user_profile";
    }

//    @GetMapping("/{id}/{file_name}")
//    public void getFile(@PathVariable Long id,
//                        @PathVariable("file_name") String fileName,
//                        HttpServletResponse response) throws IOException {
//        InputStream photo_is = usersFileService.getFile(id, fileName);
//        if(photo_is==null){
//                throw new IOException("IOError open file to input stream");
//            }
//        try{
//            IOUtils.copy(photo_is, response.getOutputStream());
//            response.flushBuffer();
//        }catch (IOException e){
//            throw new IOException("IOError writing file to output stream");
//        }
//
//    }
    @GetMapping("/{id}/{file_name}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getFile(@PathVariable Long id,
                        @PathVariable("file_name") String fileName,
                        HttpServletResponse response) throws IOException {
        InputStream photo_is = usersFileService.getFile(id, fileName);
        if(photo_is==null){
                throw new IOException("IOError open file to input stream");
            }
        try{
            return ResponseEntity.ok()
                    .contentLength(photo_is.available())
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(photo_is));
        }catch (IOException e){
            throw new IOException("IOError writing file to output stream");
        }

    }


}
