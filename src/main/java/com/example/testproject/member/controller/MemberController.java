package com.example.testproject.member.controller;

import com.example.testproject.member.repository.MemberRepository;
import com.example.testproject.member.repository.entity.Member;
import com.example.testproject.member.dto.MemberDto;
import com.example.testproject.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("message", "로그인");
        return "member/login";
    }

    @PostMapping("/login")
    public String login(MemberDto memberDto) {
        Member member = memberService.login(memberDto.getUserId(), memberDto.getPassword());
        System.out.println("로그인");
        System.out.println("usrId : "    + memberDto.getUserId());
        System.out.println("password : " + memberDto.getPassword());
        System.out.println("member : "   + member);
        if (member != null) {
            // 로그인 성공
            return "redirect:/?userId=" + member.getUserId();
        }
        // 로그인 실패
        return "redirect:/member/login";
    }

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        model.addAttribute("message", "회원가입");
        return "member/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute MemberDto memberDto) {
        System.out.println(memberDto);
        Member savedMember = memberService.registerMember(memberDto);
        System.out.println(savedMember);
        if (savedMember == null) {
            return "member/signUp";
        }
        return "redirect:/member/login";
    }
} 