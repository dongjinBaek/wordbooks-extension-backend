package com.dongjinbaek.wordbooks.service;

import java.util.Date;
import java.util.List;

import com.dongjinbaek.wordbooks.mapper.WordMapper;
import com.dongjinbaek.wordbooks.dto.Word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.translate.*;

@Service
public class WordService {
    @Autowired
    WordMapper wordMapper;
    @Autowired
    UserService userService;

    public Word getWord(String userId, String english) {
        return wordMapper.getWord(userId, english);
    }

    public List<Word> getWordLists(String userId, String term) {
        String language = userService.getLanguage(userId);
        Translate translate = TranslateOptions.newBuilder().setTargetLanguage(language).build().getService();

        String translated = translate.translate(term).getTranslatedText();
        if (term.equals(translated)) {
            translated = "";
        }
        Word translatedWord = new Word(term, translated);
        List<Word> words = wordMapper.searchWords(userId, term);
        words.add(0, translatedWord);
        return words;
    }

    public List<Word> searchWithDate(String userId, Date fromDate, Date toDate) {
        return wordMapper.searchWithDate(userId, fromDate, toDate);
    }

    public int addWord(Word word) {
        return wordMapper.addWord(word);
    }

    public int deleteWord(String userId, String english) {
        return wordMapper.deleteWord(userId, english);
    }

    public int updateWord(Word word) {
        return wordMapper.updateWord(word);
    }
}