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
    }

    // 게시글목록에 댓글 작성
    @Override
    public int replyWrite(Reply reply) {
        StringBuilder sql = new StringBuilder("INSERT INTO board_db.reply (idx, board_idx, user_idx, content, created) VALUES (null, ?, ?, ?, now())");
        return jdbcTemplate.update(sql.toString(), new Object[]{reply.getBoardIdx(), reply.getUserIdx(), reply.getContent()});
    }

    // 게시글 리스트 조회
    @Override
    public Board find(Board idx) {
        return jdbcTemplate.queryForObject("SELECT user_idx, title FROM board WHERE = ?",
                BeanPropertyRowMapper.newInstance(Board.class), idx);
    }

    // 게시글 리스트(목록) 게시글 내용 조회
    @Override
    public Board showContent(Integer idx) {
        return jdbcTemplate.queryForObject("SELECT b.idx, b.title, c.content, b.view_count as viewCount, b.user_idx as userIndex, b.created FROM board b LEFT JOIN content c on b.idx = c.board_idx WHERE b.idx = ? ",
                BeanPropertyRowMapper.newInstance(Board.class), idx);
    }


    // 댓글 작성자와 함께 댓글 출력
    @Override
    public List<Map<String, Object>> getReply(Integer boardIdx) {

        StringBuilder sql = new StringBuilder("SELECT r.idx, r.content, r.created, u.id FROM reply r LEFT JOIN user u on r.user_idx = u.idx WHERE r.board_idx = ?");

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString(), boardIdx);

        return list;
    }



    @Override
    public List<Map<String, java.lang.Object>> findAll() {
        List<Map<String, java.lang.Object>> list = jdbcTemplate.queryForList("select * from board");
        return list;
    }
}