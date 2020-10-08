package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Roles;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import com.SpringBootProject.OurApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String toRegist(){
        return "registration";
    }

    @PostMapping
    public String saveUser(Users user, Model model){
        if(userService.addUser(user)){
            return "redirect:/login";
        }else {
            model.addAttribute("error","User already exists");
            return "registration";
        }

    }

}
