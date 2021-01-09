package com.dongjinbaek.wordbooks.dto.user;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String userId;
    private String password;
}