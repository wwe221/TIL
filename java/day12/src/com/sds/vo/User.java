package com.sds.vo;

public class User {

	String name;
	String id;
	String pwd;

	public User() {

	}

	public User(String name, String id, String pwd) {
		this.name = name;
		this.id = id;
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", pwd=" + pwd + "]";
	}

}
