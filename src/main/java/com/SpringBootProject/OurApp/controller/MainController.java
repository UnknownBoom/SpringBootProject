package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Orders;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.OrdersRepo;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import com.SpringBootProject.OurApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping()
public class MainController {
    private UsersRepo usersRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;


    public MainController(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }


    @GetMapping("/user_profile")
    public String profilePage(@AuthenticationPrincipal Users user, Model model){
        Users userWithOrders = userService.getUserWithOrders(user);
        model.addAttribute("user",userWithOrders);
        return "user_profile";
    }
    @GetMapping("/")
    public String mainPage(Model model){
        return "mainPage";
    }

    @PostMapping("/profile_edit")
    public String editUser(@AuthenticationPrincipal Users user_origin,
                           @RequestParam Long id,
                           @RequestParam String username,
                           @RequestParam(required = false) String password,
                           @RequestParam String first_name,
                           @RequestParam String surname,
                           @RequestParam String patronymic,
                           Model model){
        userService.editUser(user_origin,id,username,password,first_name,surname,patronymic,model);
        model.addAttribute("user",usersRepo.findUsersById(user_origin.getId()));
        return "user_profile";
    }

}
