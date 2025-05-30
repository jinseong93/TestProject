package com.example.testproject.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@RequestParam(required = false) String userId, Model model) {
        if (userId != null && !userId.trim().isEmpty()) {
            model.addAttribute("userId", userId);
        }
        return "home";
    }
}   