package com.example.board1.repository;


import com.example.board1.domain.Tutorial;

import java.util.List;

public interface TutorialRepository {
    Tutorial tutoral = new Tutorial();
    int save(Tutorial book);
    int update(Tutorial book);
    Tutorial findById(Long id);
    int deleteById(Long id);
    List<Tutorial> findAll();
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
    int deleteAll();
}