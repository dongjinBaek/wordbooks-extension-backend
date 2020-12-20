package com.dongjinbaek.wordbooks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Word {
    private String userid;
    private String english;
    private String korean;
    private String example;
    private String updatedAt;
}