package com.mediscreen.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    

    @GetMapping(path = "/swagger")
    public String mainPage() {
        return "redirect:/swagger-ui/index.html";

    }
}
