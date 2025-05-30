package com.example.testproject.member.controller;

import com.example.testproject.member.repository.entity.Member;
import com.example.testproject.member.dto.MemberDto;
import com.example.testproject.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

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
    public String createMember(@ModelAttribute MemberDto memberDto) {
        System.out.println(memberDto);
        Member savedMember = memberService.createMember(memberDto);
        System.out.println(savedMember);
        if (savedMember == null) {
            return "member/signUp";
        }
        return "redirect:/member/login";
    }

    @GetMapping("/memberInfo")
    @ResponseBody
    public Map<String, Object> findMemberByUserId (@RequestParam String userId) {
        Map<String, Object> paramMap = new HashMap<>();
        Member member = memberService.findMemberByUserId (userId);
        System.out.println(member);
        
        if (member == null) {
            paramMap.put("resultMsg", "회원정보없음");
        } else {
            paramMap.put("resultMsg", "회원정보 조회 성공");
            paramMap.put("member", member);
        }
        System.out.println(paramMap);
        return paramMap;
    }
}