package com.example.board1.controller;

import com.example.board1.domain.Board;
import com.example.board1.repository.BoardRepository;
import com.example.board1.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class BoardControllerTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardService boardService;

    @Test
    public int write(Board board) {
        return jdbcTemplate.update("INSERT INTO board_db.board (idx, user_idx, title, view_count, created) VALUES (null, ?, ?, ?, now())",
                new java.lang.Object[]{board.getIdx(), board.getTitle(), board.getViewCount()});
    }


}