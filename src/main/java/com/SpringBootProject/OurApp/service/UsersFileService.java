package com.SpringBootProject.OurApp.service;

import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersFileService {
    @Autowired
    private UsersRepo usersRepo;


    @Value("${upload_path_users}")
    private String upload_path;

    public void saveFile(MultipartFile file,Users user) throws IOException {
        if(file!=null){
            File up_dir = new File(upload_path);
            if(!up_dir.exists()){
                up_dir.mkdir();
            }
            String uuid = UUID.randomUUID().toString();
            String result_path = uuid+"."+file.getOriginalFilename();
            user.setPhoto_name(result_path);
            usersRepo.save(user);
            file.transferTo(Paths.get(upload_path+"/"+result_path));
        }
    }




}
