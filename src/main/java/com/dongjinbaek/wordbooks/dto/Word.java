package com.dongjinbaek.wordbooks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Word {
    private String userId;
    private String english;
    private String korean;
    private String example;
    private Boolean memorized;
    private String updatedAt;

    public Word(String english, String korean) {
        this.english = english;
        this.korean = korean;
    }
}