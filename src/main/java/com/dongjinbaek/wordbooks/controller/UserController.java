package com.dongjinbaek.wordbooks.controller;

import com.dongjinbaek.wordbooks.dto.user.User;
import com.dongjinbaek.wordbooks.dto.user.UserLanguage;
import com.dongjinbaek.wordbooks.dto.user.UserLoginRequest;
import com.dongjinbaek.wordbooks.dto.user.UserLoginResponse;
import com.dongjinbaek.wordbooks.dto.user.UserRegister;
import com.dongjinbaek.wordbooks.exception.InvalidPasswordException;
import com.dongjinbaek.wordbooks.exception.NoSuchUserException;
import com.dongjinbaek.wordbooks.service.UserService;
import com.dongjinbaek.wordbooks.util.JwtUtils;
import com.dongjinbaek.wordbooks.util.SecurityUtils;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    public UserLoginResponse login(@RequestBody UserLoginRequest userLoginRequest)
            throws InvalidPasswordException, NoSuchUserException {
        String userId = userLoginRequest.getUserId();
        User user = userService.getUserAuthInfo(userId);
        if (user == null) {
            throw new NoSuchUserException();
        } else if (!passwordEncoder.matches(userLoginRequest.getPassword(), user.getEncodedPassword())) {
            throw new InvalidPasswordException();
        }
        return new UserLoginResponse(user);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public UserLoginResponse register(@RequestBody UserRegister userRegister) {
        String userId = userRegister.getUserId();
        String encodedPassword = passwordEncoder.encode(userRegister.getPassword());
        String language = userRegister.getLanguage();
        String token = jwtUtil.generateToken(userId);
        User user = User.builder().userId(userId).encodedPassword(encodedPassword).token(token).language(language)
                .build();

        userService.addUser(user);
        return new UserLoginResponse(user);
    }

    @PatchMapping("/change-language")
    @ResponseStatus(HttpStatus.OK)
    public void changeLanguage(@RequestBody UserLanguage userLanguage) {
        userLanguage.setUserId(SecurityUtils.getLoginUserId());
        userService.updateLanguage(userLanguage);
    }

    @GetMapping("/get-language")
    @ResponseStatus(HttpStatus.OK)
    public String getLanguag() {
        return userService.getLanguage(SecurityUtils.getLoginUserId());
    }
}