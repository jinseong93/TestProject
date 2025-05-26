package com.example.testproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("message", "로그인");
        return "member/login";
    }

//    @PostMapping("/login")
//    public String login() {
//        return "redirect:/";
//    }
//
//    @GetMapping("/signup")
//    public String signupForm(Model model) {
//
//        return "member/signup";
//    }
//
//    @PostMapping("/signup")
//    public String signup() {
//        return "redirect:/member/login";
//    }

} 