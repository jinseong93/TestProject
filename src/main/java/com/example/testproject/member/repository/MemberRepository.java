package com.example.testproject.member.repository;

import com.example.testproject.member.repository.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    Member findByUserIdAndPassword(String userId, String password);
    Member findByUserId(String userId);
}
