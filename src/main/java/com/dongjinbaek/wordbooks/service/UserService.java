package com.dongjinbaek.wordbooks.service;

import com.dongjinbaek.wordbooks.dto.user.User;
import com.dongjinbaek.wordbooks.dto.user.UserInfo;
import com.dongjinbaek.wordbooks.dto.user.UserLanguage;
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

    public User getUserAuthInfo(String userId) {
        return userMapper.getUserAuthInfo(userId);
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public String getLanguage(String userId) {
        return userMapper.getLanguage(userId);
    }

    public int updateLanguage(UserLanguage userLanguage) {
        return userMapper.updateLanguage(userLanguage);
    }
}