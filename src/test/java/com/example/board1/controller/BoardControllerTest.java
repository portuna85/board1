package com.example.board1.controller;

import com.example.board1.domain.Board;
import com.example.board1.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardControllerTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardController boardController;

    @Test
    public void createTest() {

        Board board = new Board(null, "2", "테스트를 통한 테스트", "0", new Date());
        int result = boardController.createBoard(board);
        //int result = boardRepository.write(board);
        assertEquals(result, 1);


    }

}