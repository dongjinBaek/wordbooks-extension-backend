package com.dongjinbaek.wordbooks.controller;

import com.dongjinbaek.wordbooks.dto.Word;
import com.dongjinbaek.wordbooks.service.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    WordService wordService;

    @GetMapping("/")
    public String getWord() {
        return wordService.selectName();
    }
}