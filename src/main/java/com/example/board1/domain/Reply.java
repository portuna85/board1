package com.example.board1.domain;

import java.util.Date;

public class Reply {

    private long idx;
    private long boardIdx;
    private long userIdx;
    private String content;
    private Date created = new Date();

    public Reply() {
    }

    public Reply(long boardIdx, long userIdx, String content) {
        this.boardIdx = boardIdx;
        this.userIdx = userIdx;
        this.content = content;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public void setBoardIdx(long boardIdx) {
        this.boardIdx = boardIdx;
    }

    public void setUserIdx(long userIdx) {
        this.userIdx = userIdx;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getBoardIdx() {
        return boardIdx;
    }

    public long getUserIdx() {
        return userIdx;
    }

    public String getContent() {
        return content;
    }
}
