package com.SpringBootProject.OurApp.controller;

import com.SpringBootProject.OurApp.Validator.UsersValidator;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.model.dto.CaptchaResponse;
import com.SpringBootProject.OurApp.service.UserService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;


    @Value("${recaptcha.secret}")
    private String recaptcha;

    private final static String captchaURL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    public RegistrationController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public String toRegist(){
        return "registration";
    }

    @PostMapping
    public String saveUser(@RequestParam(name="g-recaptcha-response") String captcha,
                           Users user,
                           Model model){
        UsersValidator.validate(user,model);
        if (model.getAttribute("errors")!=null){
            return "registration";
        }else{
                String url = String.format(captchaURL, recaptcha, captcha);
                CaptchaResponse captchaResponse = restTemplate.postForObject(url, Collections.EMPTY_LIST, CaptchaResponse.class);
                if(captchaResponse == null || !captchaResponse.isSuccess()){
                    HashMap<String, String> errors = new HashMap<>();
                    errors.put("usererror","Fill captcha");
                    model.addAttribute("errors",errors);
                    return "registration";
                }
            }
            if(userService.addUser(user)){
                return "redirect:/login";
            }else {
                HashMap<String, String> errors = new HashMap<>();
                errors.put("usererror","User already exists");
                model.addAttribute("errors",errors);
                return "registration";
            }
        }

    }

