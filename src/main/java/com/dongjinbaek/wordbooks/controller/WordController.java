package com.dongjinbaek.wordbooks.controller;

import java.util.List;

import com.dongjinbaek.wordbooks.dto.Word;
import com.dongjinbaek.wordbooks.service.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    WordService wordService;

    @GetMapping("/search/{term}")
    public List<Word> search(@PathVariable("term") String term) {
        System.out.println(term);
        return wordService.search(term);
    }
}