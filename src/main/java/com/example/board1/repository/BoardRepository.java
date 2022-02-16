package com.example.board1.repository;

import com.example.board1.domain.Board;
import com.example.board1.domain.Reply;

import java.util.List;
import java.util.Map;

public interface BoardRepository {

    int write(Board board);

    Board find(Board idx);

    // 게시글 리스트 클릭후 게시글 내용 조회
    Board showContent(Integer idx);

    // 게시글 리스트(목록)과 댓글 내용 조회
    List<Map<String, java.lang.Object>> getReply(Integer idx);

    // 게시글에 댓글 달기
    int replyWrite(Reply reply);

    List<Map<String, java.lang.Object>> findAll();
}