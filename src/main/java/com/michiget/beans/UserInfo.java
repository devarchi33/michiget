package com.michiget.beans;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class UserInfo {

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + nick + ", gender=" + gender
				+ ", email=" + email1 + email2 + ", regDate=" + regDate
				+ ", regIp=" + regIp + ", content=" + content + "]";
	}

	private int idx;
	private String id;
	private String pass;
	private String nick;
	private String gender;
	private String email1;
	private String email2;
	private String regDate;
	private String regIp;
	private String content;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
