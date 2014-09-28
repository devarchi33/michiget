package com.michiget.beans;

public class Board {
	private int idx;
	private String title;
	private String writer;
	private String regDate;
	private String content;
	private int count;

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", title=" + title + ", writer=" + writer
				+ ", regDate=" + regDate + ", content=" + content + ", count="
				+ count + "]";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegdate() {
		return regDate;
	}

	public void setRegdate(String regDate) {
		this.regDate = regDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
