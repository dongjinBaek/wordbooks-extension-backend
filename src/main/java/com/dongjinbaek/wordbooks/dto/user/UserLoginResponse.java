package com.dongjinbaek.wordbooks.dto.user;

import lombok.Data;

@Data
public class UserLoginResponse {
    private String userId;
    private String token;

    public UserLoginResponse(User user) {
        this.userId = user.getUserId();
        this.token = user.getToken();
    }
}