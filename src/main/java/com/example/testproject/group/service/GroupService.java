package com.example.testproject.group.service;

import com.example.testproject.group.entity.Group;
import com.example.testproject.group.repository.GroupRepository;
import com.example.testproject.group.dto.GroupDetailDto;
import com.example.testproject.group.dto.MemberDto;
import com.example.testproject.group.dto.ReviewDto;
import com.example.testproject.group.repository.MemberRepository;
import com.example.testproject.group.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    public GroupService(GroupRepository groupRepository, MemberRepository memberRepository, ReviewRepository reviewRepository) {
        this.groupRepository = groupRepository;
        this.memberRepository = memberRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Group> findGroups() {
        return groupRepository.findAll();
    }

    public Group findGroupById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("그룹을 찾을 수 없습니다"));
    }

    public GroupDetailDto findGroupDetail(Long groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("그룹을 찾을 수 없습니다"));
        List<MemberDto> members = memberRepository.findByGroupGroupId(groupId)
                .stream()
                .map(m -> new MemberDto(m.getMemberId(), m.getName(), m.getRole(), m.getProfileImageUrl(), m.getIntroduction()))
                .collect(Collectors.toList());
        List<ReviewDto> reviews = reviewRepository.findByGroupGroupId(groupId)
                .stream()
                .map(r -> new ReviewDto(r.getReviewId(), r.getRating(), r.getContent(), r.getAuthor()))
                .collect(Collectors.toList());
        return new GroupDetailDto(
                group.getGroupId(),
                group.getGroupName(),
                group.getRegion(),
                group.getCategory(),
                members.size(),
                group.isPublic(),
                group.getImageUrl(),
                group.getDescription(),
                reviews,
                members
        );
    }
} 