package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Roles;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private UsersRepo usersRepo;

    public RegistrationController(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @GetMapping
    public String toRegist(){
        return "registration";
    }

    @PostMapping
    public String saveUser(Users user, Model model){
        Users user_db = usersRepo.findByUsername(user.getUsername());
        if(user_db!=null){
            System.out.println("Not OK");
            model.addAttribute("message","User already exists");
            return "registration";
        }
        user.setRoles(Collections.singleton(Roles.Customer));
        usersRepo.save(user);
        return "redirect:/login";
    }

}
