package com.dongjinbaek.wordbooks.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLanguage {
    private String userId;
    private String language;
}