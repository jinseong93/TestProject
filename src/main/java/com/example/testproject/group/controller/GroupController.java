package com.example.testproject.group.controller;

import com.example.testproject.group.dto.GroupDto;
import com.example.testproject.group.entity.Group;
import com.example.testproject.group.service.GroupService;
import com.example.testproject.group.dto.GroupDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<GroupDto>> findGroups() {
        List<Group> groups = groupService.findGroups();
        List<GroupDto> groupDtos = groups.stream()
                .map(group -> new GroupDto(group.getGroupId(), group.getGroupName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(groupDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> findGroupById(@PathVariable Long id) {
        Group group = groupService.findGroupById(id);
        GroupDto groupDto = new GroupDto(group.getGroupId(), group.getGroupName());
        return ResponseEntity.ok(groupDto);
    }

    @GetMapping("/detail/{groupId}")
    public ResponseEntity<GroupDetailDto> findGroupDetail(@PathVariable Long groupId) {
        GroupDetailDto detail = groupService.findGroupDetail(groupId);
        return ResponseEntity.ok(detail);
    }
} 