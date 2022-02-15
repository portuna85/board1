package com.example.board1.domain;

import java.util.Date;

public class Board {

    private String idx;
    private String userIndex;
    private String title;
    private String viewCount;
    private Date date = new Date();

    public Board() {
    }

    public Board(String idx, String userIndex, String title, String viewCount, Date date) {
        this.idx = idx;
        this.userIndex = userIndex;
        this.title = title;
        this.viewCount = viewCount;
        this.date = date;
    }

    public String getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(String userIndex) {
        this.userIndex = userIndex;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Board{" +
                "idx='" + idx + '\'' +
                ", title='" + title + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", date=" + date +
                '}';
    }
}