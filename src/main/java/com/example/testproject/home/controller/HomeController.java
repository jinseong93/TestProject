package com.example.testproject.home.controller;

import com.example.testproject.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home(@RequestParam(required = false) String userId, Model model) {
        // userId 체크
        if (memberService.findMemberByUserId(userId) != null) {
            model.addAttribute("userId", userId);
        }

        return "home";
    }
}   