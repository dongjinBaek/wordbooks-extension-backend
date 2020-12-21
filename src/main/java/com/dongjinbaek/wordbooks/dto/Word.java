package com.dongjinbaek.wordbooks.dto;

import lombok.Data;

@Data
public class Word {
    private String userId;
    private String english;
    private String korean;
    private String example;
    private Boolean memorized;
    private String updatedAt;
}