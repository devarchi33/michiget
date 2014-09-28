package com.michiget.beans;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class UserInfo {
	
	/*@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", pass="
				+ pass + ", gender=" + gender + ", ph1=" + ph1
				+ ", ph2=" + ph2 + ", ph3=" + ph3 + ", regDate=" + regDate
				+ ", hello=" + hello + "]";
	}*/
	private int idx;
	private String id; //아이디
	
	private String pass; //비밀번호
	private String nick; //이름
	private String gender; //성별
	private String email1;
	private String email2;
	/*private int ph1; //핸드폰 010 , 011
	private int ph2; //핸드폰 가운데자리
	private int ph3; //핸드폰 마지막자리 */	
	private String regDate; // 가입일자
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
