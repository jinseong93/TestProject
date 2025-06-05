package com.example.testproject.member.controller;

import com.example.testproject.member.dto.MemberDto;
import com.example.testproject.member.entity.Member;
import com.example.testproject.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    private final MemberService memberService;
    
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberDto request) {
        Member member = memberService.createMember(request);
        return ResponseEntity.ok(member);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        Member member = memberService.findById(id);
        return ResponseEntity.ok(member);
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<Member> getMemberByEmail(@PathVariable String email) {
        Member member = memberService.findByEmail(email);
        return ResponseEntity.ok(member);
    }
}