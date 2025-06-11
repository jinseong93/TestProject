package com.example.testproject.group.repository;

import com.example.testproject.group.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByGroupGroupId(Long groupId);
} 