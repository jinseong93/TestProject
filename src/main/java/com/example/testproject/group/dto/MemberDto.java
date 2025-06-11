package com.example.testproject.group.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long memberId;
    private String name;
    private String role;
    private String profileImageUrl;
    private String introduction;
} 