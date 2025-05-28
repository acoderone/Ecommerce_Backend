package com.Ecommerce.Ecommerce.controller;

import com.Ecommerce.Ecommerce.dto.AuthRequestDTO;
import com.Ecommerce.Ecommerce.dto.AuthResponse;
import com.Ecommerce.Ecommerce.dto.UserRequestDTO;

import com.Ecommerce.Ecommerce.dto.UserResponseDTO;
import com.Ecommerce.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO>register(@RequestBody UserRequestDTO user){
        UserResponseDTO registerUser=userService.registerUser(user);
        return new ResponseEntity<>(registerUser, HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse>login(@RequestBody AuthRequestDTO requestDTO){
        System.out.println(requestDTO.getUsername()+" "+requestDTO.getPassword());
        return ResponseEntity.ok(userService.loginUser(requestDTO));
    }
}
