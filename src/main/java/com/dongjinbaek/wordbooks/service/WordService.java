package com.dongjinbaek.wordbooks.service;

import com.dongjinbaek.wordbooks.dao.WordDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    @Autowired WordDao wordDao;

    public String selectName() {
        return wordDao.selectName();
    }
}