package com.example.board1.controller;

import com.example.board1.domain.Board;
import com.example.board1.domain.Reply;
import com.example.board1.repository.JdbcTemplateBoardRepository;
import com.example.board1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BoardController {
    // C R U D
    // C: http method POST
    // R: http method GET
    // U: http method PUT
    // D: http method GET, POST
    @Autowired
    JdbcTemplateBoardRepository repository;

    @Autowired
    BoardService service;

    @PostMapping("/board")
    public int createBoard(@RequestBody Board board) {
        return repository.write(board);
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        List<Map<String, Object>> list = repository.findAll();
        return list;
    }

    @PostMapping("/reply")
    public ResponseEntity<? extends Object> createReply(@RequestBody Reply reply) {
        try {
            repository.replyWrite(reply);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/content")
    public Board contentDetail(@RequestParam("idx") Integer boardIndex) {
        return service.getBoardList(boardIndex);
    }

    /*
    @GetMapping("/content")
    public List<Map<String, Object>> contentDetail(@RequestParam("idx") Integer boardIndex) {
        return service.getBoardList(boardIndex);
    }
    */

}