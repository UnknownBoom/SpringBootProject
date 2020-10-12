package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Orders;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.OrdersRepo;
import com.SpringBootProject.OurApp.repo.UsersRepo;
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

@Controller
@RequestMapping()
public class MainController {
    private UsersRepo usersRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    public MainController(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }


    @GetMapping("/user_profile")
    public String profilePage(@AuthenticationPrincipal Users user, Model model){
        Users buId = usersRepo.findUsersById(user.getId());
        Iterable<Orders> orders_list = ordersRepo.findOrdersByUser_idList(buId.getId());
        buId.setOrders((List<Orders>) orders_list);
        model.addAttribute("user",buId);
        return "user_profile";
    }
    @GetMapping("/")
    public String mainPage(Model model){
        return "mainPage";
    }

    @PostMapping("/profile_edit")
    public String editUser(@AuthenticationPrincipal Users user_origin,
                           @RequestParam Long id,
                           @RequestParam() String username,
                           @RequestParam(required = false) String password,
                           @RequestParam() String first_name,
                           @RequestParam() String surname,
                           @RequestParam() String patronymic,
                           Model model){

        user_origin.setUsername(username);
        if(password!=null && !password.isEmpty()) user_origin.setPassword(passwordEncoder.encode(password));
        user_origin.setFirst_name(first_name);
        user_origin.setSurname(surname);
        user_origin.setPatronymic(patronymic);
        usersRepo.save(user_origin);
        return "redirect:/user_profile";
    }

}
