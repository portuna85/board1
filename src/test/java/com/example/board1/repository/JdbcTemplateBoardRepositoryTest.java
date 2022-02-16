package com.example.board1.repository;

import com.example.board1.domain.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcTemplateBoardRepositoryTest {

    @Autowired
    JdbcTemplateBoardRepository jdbcTemplateBoardRepository;

    @Test
    void write() {
    }

    @Test
    void find() {
    }

    @Test
    void findAll() {
    }

    @Test
    void insertCommentTest() {
        jdbcTemplateBoardRepository.replyWrite(new Reply(4, 2, "TEST" ));
    }
}