package com.example.testproject.group.repository;

import com.example.testproject.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT DISTINCT g FROM Group g " +
           "LEFT JOIN FETCH g.members m " +
           "LEFT JOIN FETCH g.reviews r " +
           "WHERE g.groupId = :groupId")
    Optional<Group> findGroupWithMembersAndReviews(@Param("groupId") Long groupId);
} 