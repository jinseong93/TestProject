package com.example.testproject.group.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDetailDto {
    private Long groupId;
    private String name;
    private String region;
    private String category;
    private int memberCount;
    private boolean isPublic;
    private String imageUrl;
    private String description;
    private List<ReviewDto> reviews;
    private List<MemberDto> members;
} 