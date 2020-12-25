package com.dongjinbaek.wordbooks.controller;

import java.util.List;

import com.dongjinbaek.wordbooks.dto.Word;
import com.dongjinbaek.wordbooks.service.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    WordService wordService;

    @GetMapping("/search/{term}")
    public List<Word> search(@PathVariable("term") String term) {
        String userId = "dj9136";
        return wordService.getWordLists(userId, term);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Word addWord(@RequestBody Word word) {
        word.setUserId("dj9136");
        wordService.addWord(word);
        return word;
    }

    @DeleteMapping("/{english}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWord(@PathVariable("english") String english) {
        String userId = "dj9136";
        wordService.deleteWord(userId, english);
    }

    @PutMapping("/{english}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateWord(@PathVariable("english") String english, @RequestBody Word word) {
        if (!english.equals(word.getEnglish())) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        word.setUserId("dj9136");
        wordService.updateWord(word);
    }
}