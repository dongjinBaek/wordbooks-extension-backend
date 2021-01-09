package com.dongjinbaek.wordbooks.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {
    private String userId;
    private String password;

    
}