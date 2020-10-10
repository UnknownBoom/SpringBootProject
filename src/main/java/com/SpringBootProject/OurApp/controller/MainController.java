package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Orders;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.OrdersRepo;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class MainController {
    private UsersRepo usersRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    public MainController(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @GetMapping
    public String mainPage(Model model){

        return "mainPage";
    }

}
