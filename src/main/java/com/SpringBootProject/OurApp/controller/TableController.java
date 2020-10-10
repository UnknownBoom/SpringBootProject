package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Orders;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.OrdersRepo;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@Controller
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @GetMapping("/orders")
    public String getOrdersTable(Model model, @RequestParam(required = false) String id){
        if(id==null || id.isEmpty()){
            Iterable<Orders> orders = ordersRepo.findAll();
            model.addAttribute("orders",orders);
            return "orders";
        }else{
            try{
                Orders OrdersByOrder_id = ordersRepo.findById(Long.parseLong(id));
                model.addAttribute("orders",OrdersByOrder_id);
                return "orders";
            }catch (Exception e){
                return "orders";
            }
        }
    }

    @PostMapping("orders/filter/")
    public String filterById(@RequestParam(defaultValue = "",required = false) String filter, Model model){
        return "orders";
    }

    @GetMapping("/materials")
    public String getMaterialsTable(Model model){
        return "materials";
    }
    @GetMapping("/suppliers")
    public String getSuppliersTable(Model model){
        return "suppliers";
    }
    @GetMapping("/operations")
    public String getOperationsTable(Model model){
        return "operations";
    }
    @GetMapping("/furnitures")
    public String getFurnituresTable(Model model){
        return "furnitures";
    }

}
