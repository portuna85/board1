package com.example.board1.repository;

import com.example.board1.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateBoardRepository implements BoardRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int write(Board board) {


        return jdbcTemplate.update("INSERT INTO board_db.board (idx, user_idx, title, view_count, created) VALUES (null, ?, ?, ?, now())", new Object[]{board.getUserIndex(), board.getTitle(), board.getViewCount()});
    }

    @Override
    public Board find(Board idx) {
        return jdbcTemplate.queryForObject("SELECT user_idx, title FROM board WHERE = ?",  BeanPropertyRowMapper.newInstance(Board.class), idx);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from board");
        return list;
    }
}