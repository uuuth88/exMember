package com.ex.bbs;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String nick;
	
	public MemberVO() {}
	public MemberVO(String id, String pw, String name, String nick) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nick = nick;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
}
