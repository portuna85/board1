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

    @GetMapping("/list")
    public List<Map<String, java.lang.Object>> list() {
        List<Map<String, java.lang.Object>> list = repository.findAll();
        return list;
    }

    @PostMapping("/board")
    public int createBoard(@RequestBody Board board) {
        repository.write(board);
        return 1;
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

    @GetMapping("/reply-list")
    public Board showConReply(@RequestParam("idx") Integer boardIdx) {
        //return repository.getReply(boardIdx);
        return null;
    }

    @GetMapping("/content")
    public Board contentDetail(@RequestParam("idx") Integer boardIndex) {
        return service.getBoardList(boardIndex);
    }

}
