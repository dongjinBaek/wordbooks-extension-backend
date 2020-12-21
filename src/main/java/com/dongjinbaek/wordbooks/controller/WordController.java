package com.dongjinbaek.wordbooks.controller;

import java.util.List;

import com.dongjinbaek.wordbooks.dto.Word;
import com.dongjinbaek.wordbooks.service.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    WordService wordService;

    @GetMapping("/search/{term}")
    public List<Word> search(@PathVariable("term") String term) {
        String userId = "dj9136";
        return wordService.search(userId, term);
    }

    @PostMapping("/")
    public Word addWord(@RequestBody Word word) {
        word.setUserId("dj9136");
        wordService.addWord(word);
        return word;
    }
}