package com.nickglas.gc.Code.generation.controllers;

import com.nickglas.gc.Code.generation.DTO.AssignRoleDTO;
import com.nickglas.gc.Code.generation.models.AppUser;
import com.nickglas.gc.Code.generation.services.UserService;
import com.nickglas.gc.Code.generation.utils.URIBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping()
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        return ResponseEntity.created(URIBuilder.build("/api/v1/user")).body(userService.saveUser(user));
    }

    @PostMapping("/assignRole")
    public ResponseEntity<?> addRole(@RequestBody AssignRoleDTO assignRoleDTO) {
        userService.addRoleToUser(assignRoleDTO.getUsername(), assignRoleDTO.getRoleName());
        return ResponseEntity.ok().build();
    }
}