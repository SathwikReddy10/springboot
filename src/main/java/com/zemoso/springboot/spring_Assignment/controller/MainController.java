package com.zemoso.springboot.spring_Assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/access-denied")
    public String showAccessDenied()
    {
        return "access-denied";
    }
}