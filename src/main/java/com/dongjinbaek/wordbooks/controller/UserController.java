package com.dongjinbaek.wordbooks.controller;

import com.dongjinbaek.wordbooks.dto.user.User;
import com.dongjinbaek.wordbooks.dto.user.UserLoginResponse;
import com.dongjinbaek.wordbooks.dto.user.UserRegister;
import com.dongjinbaek.wordbooks.service.UserService;
import com.dongjinbaek.wordbooks.util.JwtUtils;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtil;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public void login() {

    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public UserLoginResponse register(@RequestBody UserRegister userRegister) {
        String userId = userRegister.getUserId();
        String encodedPassword = passwordEncoder.encode(userRegister.getPassword());
        String token = jwtUtil.generateToken(userId);
        User user = User.builder().userId(userId).encodedPassword(encodedPassword).token(token).build();

        userService.addUser(user);
        return new UserLoginResponse(user);
    }
}