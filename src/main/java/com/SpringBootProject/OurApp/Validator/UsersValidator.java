package com.SpringBootProject.OurApp.Validator;

import com.SpringBootProject.OurApp.model.Users;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

public class UsersValidator {
    public static boolean validate(Users user, Model model) {
        Map<String, String> errors = new HashMap<>();
        boolean isValid = true;

        if(user.getPassword()==null || user.getPassword().isEmpty()
        || !user.getPassword().trim().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,18}$") ){
            errors.put("passwordError","6-18 length & contains (#?!@$%^&*-)&[A-Z]&[a-z]");
            isValid = false;
        }else{

        }
        if(user.getUsername()==null || user.getUsername().isEmpty()){
            errors.put("usernameError","Please select username");
            isValid = false;
        }
        if(!errors.keySet().isEmpty()){
            if(model!=null)
                model.addAttribute("errors", errors);
            isValid = false;
        }
        return isValid;

    }
    public static boolean validatePassword(String password) {
        return password != null && !password.isEmpty()
                && password.trim().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,18}$");
    }

    public static boolean validateUsername(String username) {
        return username != null && !username.isEmpty();
    }
}
