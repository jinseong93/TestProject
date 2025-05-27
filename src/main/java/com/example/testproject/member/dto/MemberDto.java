package com.example.testproject.member.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String userId;    // 로그인용 ID
    private String password;  // 비밀번호
    private String name;      // 사용자 이름
    private String email;     // 이메일
} 