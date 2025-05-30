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
    public String login(MemberDto memberDto, Model model) {
        try {
            // 로그인
            Member member = memberService.login(memberDto.getUserId(), memberDto.getPassword());
            if (member == null) {
                model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
                return "member/login";
            }
            return "redirect:/?userId=" + member.getUserId();
        } catch (Exception e) {
            model.addAttribute("error", "로그인에 실패했습니다.");
            return "member/login";
        }
    }

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        model.addAttribute("message", "회원가입");
        return "member/signUp";
    }

    @PostMapping("/signUp")
    public String createMember(@ModelAttribute MemberDto memberDto, Model model) {
        try {
            // ID 중복 체크
            if (memberService.findMemberByUserId(memberDto.getUserId()) != null) {
                model.addAttribute("error", "이미 사용 중인 아이디입니다.");
                return "member/signUp";
            }
            // 회원가입
            Member savedMember = memberService.createMember(memberDto);
            if (savedMember == null) {
                model.addAttribute("error", "회원가입에 실패했습니다.");
                return "member/signUp";
            }
            return "redirect:/member/login";

        } catch (Exception e) {
            model.addAttribute("error", "회원가입에 실패했습니다.");
            return "member/signUp";
        }
    }

    @GetMapping("/memberInfo")
    @ResponseBody
    public Map<String, Object> findMemberByUserId (@RequestParam(required = false) String userId) {
        Map<String, Object> paramMap = new HashMap<>();
        // userId 체크
        if (userId == null || userId.trim().isEmpty()) {
            paramMap.put("resultMsg", "아이디를 입력해주세요.");
            return paramMap;
        }

        try {
            // 회원정보 조회
            Member member = memberService.findMemberByUserId (userId);
            if (member == null) {
                paramMap.put("resultMsg", "회원정보 없음");
            } else {
                paramMap.put("resultMsg", "회원정보 조회 성공");
                paramMap.put("member", member);
            }
        } catch (Exception e) {
            paramMap.put("resultMsg", "회원정보 조회에 실패했습니다.");
        }
        return paramMap;
    }
}