package com.example.board1.repository;

import com.example.board1.domain.Board;

import java.util.List;
import java.util.Map;

public interface BoardRepository {

    int write(Board board);

    Board find(Board idx);

    List<Map<String, Object>> findAll();
}