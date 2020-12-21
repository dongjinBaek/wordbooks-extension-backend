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

    public List<Word> search(String userId, String term) {
        Translate translate = TranslateOptions.newBuilder().setTargetLanguage("ko").build().getService();

        String korean = translate.translate(term).getTranslatedText();
        if (term.equals(korean)) {
            korean = "";
        }
        Word translated = new Word(term, korean);
        List<Word> words = wordMapper.search(userId, term);
        words.add(0, translated);
        return words;
    }

    public int addWord(Word word) {
        return wordMapper.addWord(word);
    }
}