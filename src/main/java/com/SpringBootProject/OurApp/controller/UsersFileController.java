package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.Validator.ImageValidator;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import com.SpringBootProject.OurApp.service.UsersFileService;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
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
    public  String HandleFileUpload(@AuthenticationPrincipal Users user,
                                    @RequestParam MultipartFile file,
                                    Model model) {
        ImageValidator.validate(file,model);
        if(model.getAttribute("imageError")!=null){
            model.addAttribute("user",usersRepo.findUsersById(user.getId()));
            return "user_profile";
        }
        Users byId = usersRepo.findUsersById(user.getId());
        try {
            usersFileService.saveFile(file,byId);
        } catch (SQLException throwables) {
            byId = usersRepo.findUsersById(user.getId());
            System.out.println(throwables);
            model.addAttribute("imageError",throwables.getMessage());
        }catch (IOException e){
            model.addAttribute("imageError","System error");
            System.out.println(e.getMessage());
        }
        model.addAttribute("user",byId);
        return "redirect:/user_profile";
    }


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
                    .contentType(MediaType.IMAGE_PNG)
                    .body(new InputStreamResource(photo_is));
        }catch (IOException e){
            throw new IOException("IOError writing file to output stream");
        }

    }

    @ExceptionHandler({SizeLimitExceededException.class, javax.naming.SizeLimitExceededException.class})
    public String handleStorageFileNotFound(SizeLimitExceededException exc) {
        return "redirect:/user_profile";
    }


}
