package com.example.testproject.member.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    private String userId;
    private String password;
    private String name;
    private String email;
}
