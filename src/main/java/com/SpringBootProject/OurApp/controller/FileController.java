package com.SpringBootProject.OurApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {
    @RequestMapping(value="/upload", method= RequestMethod.GET)
    public String provideUploadInfo() {
        return "mainPage";
    }

}
