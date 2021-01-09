package com.dongjinbaek.wordbooks.service;

import com.dongjinbaek.wordbooks.dto.user.User;
import com.dongjinbaek.wordbooks.dto.user.UserInfo;
import com.dongjinbaek.wordbooks.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfo getUser(String userId) {
        return userMapper.getUser(userId);
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }
}