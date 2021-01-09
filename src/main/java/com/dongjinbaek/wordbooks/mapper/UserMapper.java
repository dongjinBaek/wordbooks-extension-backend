package com.dongjinbaek.wordbooks.mapper;

import com.dongjinbaek.wordbooks.dto.user.User;
import com.dongjinbaek.wordbooks.dto.user.UserInfo;

public interface UserMapper {
    UserInfo getUser(String userId);

    void addUser(User user);
}