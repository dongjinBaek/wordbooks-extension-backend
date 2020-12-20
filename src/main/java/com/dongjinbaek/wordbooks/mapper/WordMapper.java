package com.dongjinbaek.wordbooks.mapper;

import java.util.List;

import com.dongjinbaek.wordbooks.dto.Word;

import org.apache.ibatis.annotations.Param;

public interface WordMapper {
    public List<Word> search(@Param("userId") String userId, @Param("term") String term);
}