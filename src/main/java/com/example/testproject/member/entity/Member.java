package com.example.testproject.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private String email;
    private String name;
} 