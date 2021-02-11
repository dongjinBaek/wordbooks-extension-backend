package com.dongjinbaek.wordbooks.mapper;

import com.dongjinbaek.wordbooks.dto.user.User;
import com.dongjinbaek.wordbooks.dto.user.UserInfo;
import com.dongjinbaek.wordbooks.dto.user.UserLanguage;

public interface UserMapper {
    UserInfo getUser(String userId);

    User getUserAuthInfo(String userId);

    void addUser(User user);

    int updateLanguage(UserLanguage userLanguage);

    String getLanguage(String userId);
}