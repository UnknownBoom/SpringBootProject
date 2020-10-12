package com.SpringBootProject.OurApp.Validator;

import com.SpringBootProject.OurApp.model.Users;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

public class UsersValidator {
    public static void validate(Users user, Model model) {
        Map<String, String> errors = new HashMap<>();

        if(user.getPassword()==null || user.getPassword().isEmpty()
        || !user.getPassword().trim().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,18}$") ){
            errors.put("passwordError","6-18 length & contains (#?!@$%^&*-)&[A-Z]&[a-z]");
        }else{

        }
        if(user.getUsername()==null || user.getUsername().isEmpty()){
            errors.put("usernameError","Please select username");
        }
        if(!errors.keySet().isEmpty()){
            model.addAttribute("errors", errors);
        }

    }
    public static boolean validatePassword(String password) {
        return password != null && !password.isEmpty()
                && password.trim().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,18}$");
    }
}
