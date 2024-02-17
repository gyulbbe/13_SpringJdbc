package com.feb.jdbc.entity;

public class Notice {
	int noticeIdx;
	String author;
	String content;
	String wrtDtm;
	
	public int getNoticeIdx() {
		return noticeIdx;
	}
	public void setNoticeIdx(int noticeIdx) {
		this.noticeIdx = noticeIdx;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrtDtm() {
		return wrtDtm;
	}
	public void setWrtDtm(String wrtDtm) {
		this.wrtDtm = wrtDtm;
	}
}
