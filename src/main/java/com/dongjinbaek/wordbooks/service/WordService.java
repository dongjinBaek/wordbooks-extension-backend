package com.dongjinbaek.wordbooks.service;

import java.util.List;

import com.dongjinbaek.wordbooks.mapper.WordMapper;
import com.dongjinbaek.wordbooks.dto.Word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    @Autowired
    WordMapper wordMapper;

    public List<Word> search(String userId, String term) {
        return wordMapper.search(userId, term);
    }

    public int addWord(Word word) {
        return wordMapper.addWord(word);
    }
}