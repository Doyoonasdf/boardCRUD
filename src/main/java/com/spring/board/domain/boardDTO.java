package com.spring.board.domain;

import java.util.*;


public class boardDTO {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private int view_cnt;
	private int comment_cnt;
	private Date reg_date;
	private Date up_date;
	
    public Integer getBno() {
        return bno;
    }
    public void setBno(Integer bno) {
        this.bno = bno;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    
    public int getView_cnt() {
        return view_cnt;
    }
    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }
    
    public int getComment_cnt() {
        return comment_cnt;
    }
    public void setComment_cnt(int comment_cnt) {
        this.comment_cnt = comment_cnt;
    }
    
    public Date getReg_date() {
        return reg_date;
    }
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
    
    public Date getUp_date() {
        return up_date;
    }
    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }
}