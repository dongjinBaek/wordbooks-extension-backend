package com.dongjinbaek.wordbooks.controller;

import com.dongjinbaek.wordbooks.dto.Word;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/word")
public class WordController {
    
    @GetMapping("/")
    public Word getWord() {
        return new Word();
    }
}