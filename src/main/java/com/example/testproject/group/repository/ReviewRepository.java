package com.example.testproject.group.repository;

import com.example.testproject.group.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByGroupGroupId(Long groupId);
} 