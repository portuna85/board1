package com.example.board1.repository;

import com.example.board1.domain.Board;
import com.example.board1.domain.Reply;
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

    // 게시글 목록 작성
    @Override
    public int write(Board board) {
        StringBuilder sql = new StringBuilder("INSERT INTO board_db.board (idx, user_idx, title, view_count, created) VALUES (null, ?, ?, ?, now())");
        Object[] obj = {board.getUserIndex(), board.getTitle(), board.getViewCount()};
        return jdbcTemplate.update(sql.toString(), obj);

        /*
        StringBuilder sql = new StringBuilder("INSERT INTO board_db.reply (idx, board_idx, user_idx, content, created) VALUES (null, ?, ?, ?, now())");
        return jdbcTemplate.update(sql.toString(), new Object[]{reply.getBoardIdx(), reply.getUserIdx(), reply.getContent()});
        */
    }

    // 게시글 리스트 조회
    @Override
    public Board find(Board idx) {
        return jdbcTemplate.queryForObject("SELECT user_idx, title FROM board WHERE = ?",
                BeanPropertyRowMapper.newInstance(Board.class), idx);
    }

    // 게시글 리스트 클릭후 게시글 내용 조회
    @Override
    public Board showContent(Integer idx) {
        return jdbcTemplate.queryForObject("SELECT b.idx, b.title, c.content, b.view_count as viewCount, b.user_idx as userIndex, b.created FROM board b LEFT JOIN content c on b.idx = c.board_idx WHERE b.idx = ? ",
                BeanPropertyRowMapper.newInstance(Board.class), idx);
    }


    // 게시글 리스트(목록)과 댓글 내용 조회
    @Override
    public List<Map<String, Object>> getReply(Integer boardIdx) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT r.idx, r.content, r.created, u.id ");
        query.append("FROM reply r ");
        query.append("LEFT JOIN user u on r.user_idx = u.idx ");
        query.append("WHERE r.board_idx = ? ");

        List<Map<String, java.lang.Object>> list = jdbcTemplate.queryForList(query.toString(), boardIdx);

        return list;
    }

    // 게시글에 댓글 달기
    @Override
    public int replyWrite(Reply reply) {
        StringBuilder sql = new StringBuilder("INSERT INTO board_db.reply (idx, board_idx, user_idx, content, created) VALUES (null, ?, ?, ?, now())");
        return jdbcTemplate.update(sql.toString(), new Object[]{reply.getBoardIdx(), reply.getUserIdx(), reply.getContent()});
    }

    @Override
    public List<Map<String, java.lang.Object>> findAll() {
        List<Map<String, java.lang.Object>> list = jdbcTemplate.queryForList("select * from board");
        return list;
    }
}