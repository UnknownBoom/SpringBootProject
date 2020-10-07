package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Roles;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

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
    @PostMapping("/save")
    public String saveEdit(){
        return "redirect:";
    }
    @PostMapping("/filter")
    public String filterById(@RequestParam(defaultValue = "",required = false) String filter, Model model){
        Iterable<Users> users;
        if(filter.isEmpty() || filter.equals(null)){
            users = usersRepo.findAll();
        }else {
            try{
                users = usersRepo.findUsersById(Long.parseLong(filter));
            }catch (NumberFormatException e){
                users = usersRepo.findAll();
            }

        }
        model.addAttribute("users",users);
        return "mainPage";
    }

    @GetMapping("/registration")
    public String toRegist(){
        return "registration";
    }
    @PostMapping("/registration")
    public String saveUser(Users user,Model model){
        Users user_db = usersRepo.findByUsername(user.getUsername());
        if(user_db!=null){
            System.out.println("Not OK");
            model.addAttribute("message","User already exists");
            return "registration";
        }
        user.setRoles(Collections.singleton(Roles.Customer));
        System.out.println(user.getId());
        usersRepo.save(user);
        System.out.println("Ok");
        return "redirect:/login";
    }
}
