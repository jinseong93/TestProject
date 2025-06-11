package com.example.testproject.member.controller;

import com.example.testproject.member.dto.MemberDto;
import com.example.testproject.member.entity.Member;
import com.example.testproject.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    private final MemberService memberService;
    
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @PostMapping
    public ResponseEntity<Map<String, Object>> createMember(@RequestBody MemberDto request) {
        Member member = memberService.createMember(request);
        Map<String, Object> response = new HashMap<>();
        response.put("name", member.getName());
        response.put("email", member.getEmail());
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findMember(@PathVariable Long id) {
        Member member = memberService.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("name", member.getName());
        response.put("email", member.getEmail());
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<Map<String, Object>> findMemberByEmail(@RequestParam String email) {
        Member member = memberService.findByEmail(email);
        Map<String, Object> response = new HashMap<>();
        response.put("name", member.getName());
        response.put("email", member.getEmail());
        return ResponseEntity.ok(response);
    }
}