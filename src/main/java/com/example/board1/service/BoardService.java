package com.example.board1.service;

import com.example.board1.domain.Board;
import com.example.board1.repository.JdbcTemplateBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    JdbcTemplateBoardRepository repository;

    public Board getBoardList(Integer boardIndex) {

        // 게시글 index를 이용하여 게시글 획득
        Board board = repository.showContent(boardIndex);

        // 게시글 index를 이용하여 게시글의 댓글 획득
        List<Map<String, Object>> list = repository.getReply(boardIndex);

        return board;
    }
}