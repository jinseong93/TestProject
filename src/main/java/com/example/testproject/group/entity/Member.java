package com.example.testproject.group.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String name;
    private String role;
    private String profileImageUrl;
    private String introduction;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
} 