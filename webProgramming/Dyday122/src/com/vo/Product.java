package com.vo;

import java.sql.Date;

public class Product {
	String id;
	String name;
	double price;
	Date regdate;
	String imgname;
	
	public Product() {
	}

	public Product(String id, String name, double price, Date regdate, String imgname) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdate = regdate;
		this.imgname = imgname;
	}

	public Product(String id, String name, double price,String imgname) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgname = imgname;
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	  
	    this.regdate=sqlDate;
	    
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", regdate=" + regdate + ", imgname="
				+ imgname + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

}
