package com.example.testproject.member.controller;

import com.example.testproject.member.repository.MemberRepository;
import com.example.testproject.member.repository.entity.Member;
import com.example.testproject.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("message", "로그인");
        return "member/login";
    }

    @PostMapping("/login")
    public String login(MemberDto memberDto) {
        Member member = memberRepository.findByUserIdAndPassword(memberDto.getUserId(), memberDto.getPassword());
        System.out.println("로그인");
        System.out.println("id : "       + memberDto.getUserId());
        System.out.println("password : " + memberDto.getPassword());
        System.out.println("member : "   + member);
        if (member != null) {
            // 로그인 성공
            return "redirect:/";
        }
        // 로그인 실패
        return "redirect:/member/login";
    }

} 