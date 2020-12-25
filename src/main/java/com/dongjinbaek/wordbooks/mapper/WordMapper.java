package com.dongjinbaek.wordbooks.mapper;

import java.util.List;

import com.dongjinbaek.wordbooks.dto.Word;

import org.apache.ibatis.annotations.Param;

public interface WordMapper {

    Word getWord(@Param("userId") String userId, @Param("english") String english);

    List<Word> searchWords(@Param("userId") String userId, @Param("term") String term);

    int addWord(Word word);

    int deleteWord(@Param("userId") String userId, @Param("english") String english);

    int updateWord(Word word);
}