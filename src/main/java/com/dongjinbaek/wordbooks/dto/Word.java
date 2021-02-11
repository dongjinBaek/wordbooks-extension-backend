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
    private String translated;
    private String example;
    private Boolean memorized;
    private String createdAt;

    public Word(String english, String translated) {
        this.english = english;
        this.translated = translated;
    }
}