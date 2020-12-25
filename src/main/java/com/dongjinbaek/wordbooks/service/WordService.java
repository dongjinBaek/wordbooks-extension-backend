package com.dongjinbaek.wordbooks.service;

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

    public Word getWord(String userId, String english) {
        return wordMapper.getWord(userId, english);
    }

    public List<Word> getWordLists(String userId, String term) {
        Translate translate = TranslateOptions.newBuilder().setTargetLanguage("ko").build().getService();

        String korean = translate.translate(term).getTranslatedText();
        if (term.equals(korean)) {
            korean = "";
        }
        Word translated = new Word(term, korean);
        List<Word> words = wordMapper.searchWords(userId, term);
        words.add(0, translated);
        return words;
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