package com.example.board1.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Board {

    private long idx;
    private long userIndex;
    private String title;
    private long viewCount;
    //private Content content; 이걸로 가능한지 확인 해야됨
    private String content;
    public List<Reply> replies = new ArrayList<>();
    private Date date = new Date();

    public Board() {
    }

    public Board(long userIndex, String title, long viewCount) {
        this.userIndex = userIndex;
        this.title = title;
        this.viewCount = viewCount;
    }

    public long getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(long userIndex) {
        this.userIndex = userIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }
}