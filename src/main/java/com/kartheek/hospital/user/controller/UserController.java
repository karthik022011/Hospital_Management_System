package com.kartheek.hospital.user.controller;

import com.kartheek.hospital.user.model.request.UserDto;
import com.kartheek.hospital.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto>  createAdmin(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto>  getAdminById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return  ResponseEntity.ok(user);

    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>>  getAllAdmins(@RequestBody UserDto adminDto){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
