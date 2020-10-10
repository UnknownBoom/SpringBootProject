package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.model.Furnitures;
import com.SpringBootProject.OurApp.model.Materials;
import com.SpringBootProject.OurApp.model.OperationSpecification;
import com.SpringBootProject.OurApp.model.Orders;
import com.SpringBootProject.OurApp.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private FurnituresRepo furnituresRepo;

    @Autowired
    private OperationSpecificationRepo operation_specificationRepo;

    @Autowired
    private MaterialsRepo materialsRepo;

    @GetMapping("/orders")
    public String getOrdersTable(Model model, @RequestParam(required = false) String id){
        Iterable<Orders> orders;
        if(id!=null && !id.isEmpty()){
            try{
                orders = Arrays.asList(ordersRepo.findById(Long.parseLong(id)));
            }catch (Exception e){
                orders = ordersRepo.findAll();
            }

        }else{
            orders = ordersRepo.findAll();

        }
        model.addAttribute("orders",orders);
        return "orders";
    }


    @GetMapping("/materials")
    public String getMaterialsTable(Model model,@RequestParam(required = false) String id){
        if(id!=null && !id.isEmpty()){
            try{
                Optional<Materials> byId = materialsRepo.findById(id);
                if(byId.isPresent()){
                    ArrayList<Materials> materials = new ArrayList<>();
                    materials.add(byId.get());
                    model.addAttribute("materials",materials);
                }else{
                    model.addAttribute("materials",new ArrayList<>());
                }

            }catch (Exception e){
                model.addAttribute("materials", materialsRepo.findAll());
            }

        }else {
            model.addAttribute("materials", materialsRepo.findAll());
        }
        return "materials";
    }
    @GetMapping("/suppliers")
    public String getSuppliersTable(Model model){
        return "suppliers";
    }
    @GetMapping("/operations")
    public String getOperationsTable(Model model,@RequestParam(required = false) String id){
        if(id!=null && !id.isEmpty()){
            try{
                Optional<OperationSpecification> specification = operation_specificationRepo.findById(Long.parseLong(id));
                if(specification.isPresent()){
                    ArrayList<OperationSpecification> list = new ArrayList<>();
                    list.add(specification.get());
                    model.addAttribute("operations",specification);
                }else{
                    model.addAttribute("operations",new ArrayList<>());
                }

            }catch (Exception e){
                model.addAttribute("operations",operation_specificationRepo.findAll());
            }

        }
        else{
            model.addAttribute("operations",operation_specificationRepo.findAll());
        }
        return "operations";
    }
    @GetMapping("/furnitures")
    public String getFurnituresTable(Model model,@RequestParam(required = false) String id){
        Iterable<Furnitures> furnitures;
        if(id!=null && !id.isEmpty()){
            furnitures = furnituresRepo.findAllByArticleLike(id);
        }else
        {
            furnitures = furnituresRepo.findAll();
        }

        model.addAttribute("furnitures",furnitures);
        return "furnitures";
    }

}
