package com.example.board1.controller;

import com.example.board1.domain.Board;
import com.example.board1.repository.JdbcTemplateBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        List<Map<String, Object>> list = repository.findAll();
        return list;
    }

    @PostMapping("/board")
    public int createBoard(@RequestBody Board board) {
        repository.write(board);
        return 1;
    }
}
