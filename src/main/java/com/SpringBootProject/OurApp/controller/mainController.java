package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class mainController {
    private UsersRepo usersRepo;

    public mainController(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @GetMapping
    public String mainPage(Model model){
        Iterable<Users> users = usersRepo.findAll();
        model.addAttribute("users",users);
        return "mainPage";
    }
    @PostMapping
    public String saveEdit(){
        return "redirect:";
    }
}
