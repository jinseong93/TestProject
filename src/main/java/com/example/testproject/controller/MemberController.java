package com.example.testproject.controller;

import com.example.testproject.dto.MemberDTO;
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

    @PostMapping("/login")
    public String login(MemberDTO memberDTO) {
        System.out.println("로그인 시도");
        System.out.println("ID : "     + memberDTO.getUserId());
        System.out.println("비밀번호 : " + memberDTO.getPassword());
        
        if ("test".equals(memberDTO.getUserId()) && "1234".equals(memberDTO.getPassword())) {
            System.out.println("로그인 성공");
            return "redirect:/";
        }
        System.out.println("로그인 실패");
        return "redirect:/member/login";
    }

} 