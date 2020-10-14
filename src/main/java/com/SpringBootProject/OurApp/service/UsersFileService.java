package com.SpringBootProject.OurApp.service;

import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.UUID;

@Service
public class UsersFileService {

    @Autowired
    private UsersRepo usersRepo;


    @Value("${upload_path}")
    private String upload_path;

    public void saveFile(MultipartFile file,Users user) throws IOException, SQLException {
        if(file!=null){
            File up_dir = new File(upload_path);
            if(!up_dir.exists()){
                if(!up_dir.mkdir()){
                    throw new IOException("Unable to create directory");
                }
            }
            String uuid = UUID.randomUUID().toString();
            String result_photo_name = uuid+"."+file.getOriginalFilename();
            user.setPhoto_name(result_photo_name);
            file.transferTo(Paths.get(upload_path+result_photo_name));
            usersRepo.save(user);
            if(!usersRepo.findUsersById(user.getId()).getPhoto_name().equals(result_photo_name)){
                    throw new SQLException("Unable to save photo_name");
            }
        }
    }


    public InputStream getFile(Long id, String fileName) throws IOException {
        InputStream is;
        try {
            is = new BufferedInputStream(new FileInputStream(upload_path+fileName));
        } catch (IOException ex) {
            return null;
        }
        return is;
    }

}
