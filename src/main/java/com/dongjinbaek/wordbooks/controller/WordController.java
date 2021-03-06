package com.dongjinbaek.wordbooks.controller;

import java.util.Date;
import java.util.List;

import com.dongjinbaek.wordbooks.dto.Word;
import com.dongjinbaek.wordbooks.service.WordService;
import com.dongjinbaek.wordbooks.util.DateUtils;
import com.dongjinbaek.wordbooks.util.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return wordService.getWordLists(SecurityUtils.getLoginUserId(), term);
    }

    @GetMapping("/")
    public List<Word> searchWithWord(@RequestParam("from-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
            @RequestParam("to-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
        fromDate = DateUtils.atStartOfDay(fromDate);
        toDate = DateUtils.atEndOfDay(toDate);
        return wordService.searchWithDate(SecurityUtils.getLoginUserId(), fromDate, toDate);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Word addWord(@RequestBody Word word) {
        word.setUserId(SecurityUtils.getLoginUserId());
        wordService.addWord(word);
        return word;
    }

    @DeleteMapping("/{english}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWord(@PathVariable("english") String english) {
        wordService.deleteWord(SecurityUtils.getLoginUserId(), english);
    }

    @PatchMapping("/{english}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateWord(@PathVariable("english") String english, @RequestBody Word word) {
        if (!english.equals(word.getEnglish())) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        word.setUserId(SecurityUtils.getLoginUserId());
        wordService.updateWord(word);
    }
}