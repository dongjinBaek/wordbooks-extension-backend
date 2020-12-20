package com.dongjinbaek.wordbooks.service;

import java.util.List;

import com.dongjinbaek.wordbooks.mapper.WordMapper;
import com.dongjinbaek.wordbooks.dto.Word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    @Autowired
    WordMapper WordMapper;

    public List<Word> search(String term) {
        String userId = "dj9136";
        return WordMapper.search(userId, term);
    }
}