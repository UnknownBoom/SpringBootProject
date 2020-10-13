package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.Validator.ImageValidator;
import com.SpringBootProject.OurApp.Validator.UsersValidator;
import com.SpringBootProject.OurApp.model.*;
import com.SpringBootProject.OurApp.repo.*;
import com.SpringBootProject.OurApp.service.FurnituresService;
import com.SpringBootProject.OurApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
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

    @Autowired
    private SuppliersRepo suppliersRepo;

    @Autowired
    private Specification_furnitureRepo  specification_furnitureRepo;

    @Autowired
    private Product_typesRepo product_typesRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private FurnituresFileController furnituresFileController;

    @Autowired
    private FurnituresService furnituresService;


    @PreAuthorize("hasAnyAuthority('Manager','Master','Director','Deputy_director')")
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
                List<Materials> byId = materialsRepo.findByArticleContaining(id);
                model.addAttribute("materials",byId);

            }catch (Exception e){
                model.addAttribute("materials", materialsRepo.findAll());
            }

        }else {
            model.addAttribute("materials", materialsRepo.findAll());
        }
        return "materials";
    }

    @GetMapping("/suppliers")
    public String getSuppliersTable(@RequestParam(required = false) String id,Model model){
        List<Suppliers> suppliers = new ArrayList<Suppliers>();
        if(id!=null && !id.isEmpty()){
            try{
                Optional<Suppliers> byId = suppliersRepo.findById(Long.parseLong(id));
                if(byId.isPresent()){
                    suppliers.add(byId.get());
                }
            }catch (Exception e){
            }
        }else {
            suppliers.addAll(suppliersRepo.findAll());
        }
        model.addAttribute("suppliers",suppliers);
        return "suppliers";
    }

    @PreAuthorize("hasAnyAuthority('Manager','Master','Director','Deputy_director')")
    @GetMapping("/operations")
    public String getOperationsTable(Model model,@RequestParam(required = false) String id){
        if(id!=null && !id.isEmpty()){
            try{
                Optional<OperationSpecification> specification = operation_specificationRepo.findById(Long.parseLong(id));
                if(specification.isPresent()){
                    ArrayList<OperationSpecification> list = new ArrayList<>();
                    list.add(specification.get());
                    model.addAttribute("operations",list);
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
            furnitures = furnituresRepo.findByArticleContaining(id);
        }else
        {
            furnitures = furnituresRepo.findAll();
        }

        model.addAttribute("furnitures",furnitures);
        return "furnitures";
    }

    @PreAuthorize("hasAnyAuthority('Manager','Master','Director','Deputy_director')")
    @GetMapping("/users")
    public String getUsersTable(Model model,@RequestParam(required = false) String id){
        if(id!=null && !id.isEmpty()) {
            try {
                Optional<Users> users = usersRepo.findById(Long.parseLong(id));
                if (users.isPresent()) {
                    ArrayList<Users> list = new ArrayList<>();
                    list.add(users.get());
                    model.addAttribute("users", list);
                } else {
                    model.addAttribute("users", new ArrayList<>());
                }

            } catch (Exception e) {
                model.addAttribute("users", usersRepo.findAll());
            }
        }else {
            model.addAttribute("users",usersRepo.findAll());
        }

        return "users";
    }
    @PreAuthorize("hasAnyAuthority('Manager','Master','Director','Deputy_director')")
    @GetMapping("/Specification_furniture")
    public String getSpec_furn(Model model,@RequestParam(required = false) String id){
        List<Specification_furniture> spec_furns = new ArrayList<>();
        if(id!=null && !id.isEmpty()){
            try{
                Optional<Specification_furniture> byId = specification_furnitureRepo.findById(Long.parseLong(id));
                if(byId.isPresent()){
                    spec_furns.add(byId.get());
                }

            }catch (Exception e){
            }
        }else {
            spec_furns.addAll(specification_furnitureRepo.findAll());
        }
        model.addAttribute("spec_furns",spec_furns);
        return "spec_furn";
    }

    @PostMapping
    public String saveNewUser(Users user,Model model){
        userService.addUserFromTable(user,model);
        return "redirect:/tables/users";
    }
    @PreAuthorize("hasAnyAuthority('Manager','Master','Director','Deputy_director')")
    @PostMapping("/furnitures")
    public String saveFurniture(Furnitures furniture ,@RequestParam MultipartFile file, Model model){
        try {
            furnituresFileController.HandleFileUpload(furniture,file);
        } catch (IOException e) {
            return "redirect:/tables/furnitures";
        }
        furnituresService.saveFurniture(furniture);
        return "redirect:/tables/furnitures";
    }

    @GetMapping("/furnitures/{article}/{image_name}")
    public ResponseEntity<InputStreamResource> getFurnitureImage(@PathVariable String article, String image_name, Model model) throws IOException {
        InputStream inputStream = furnituresService.getFile(article, image_name);
        return ResponseEntity.ok()
                .contentLength(inputStream.available())
                .contentType(MediaType.IMAGE_JPEG)
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(inputStream));
    }


}
