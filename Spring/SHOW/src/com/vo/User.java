package com.vo;

public class User {
	private String id;
	private String pwd;
	private String email;
	private String nickname;
	private String icon;
	private int admin;
	
	public User() {
	}
	public User(String id, String pwd, String email, String nickname, String icon, int admin) {
		//包府磊
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.nickname = nickname;
		this.icon="default";
		this.admin = admin;
	}

	public User(String id, String pwd, String email, String nickname) {
		//老馆蜡历
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.nickname = nickname;
		this.admin=0;
		this.icon="default";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", email=" + email + ", nickname=" + nickname + ", icon=" + icon
				+ ", admin=" + admin + "]";
	}
	

	
	
	
}
