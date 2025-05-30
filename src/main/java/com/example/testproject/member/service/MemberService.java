package com.example.testproject.member.service;

import com.example.testproject.member.repository.MemberRepository;
import com.example.testproject.member.repository.entity.Member;
import com.example.testproject.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member login(String userId, String password) {
        return memberRepository.findByUserIdAndPassword(userId, password);
    }

    public Member createMember (MemberDto memberDto) {
        Member member = new Member();
        member.setUserId(memberDto.getUserId());
        member.setPassword(memberDto.getPassword());
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        try {
            return memberRepository.save(member);
        } catch (Exception e) {
            return null;
        }
    }

    public Member findMemberByUserId (String userId) {
        return memberRepository.findByUserId(userId);
    }
} 