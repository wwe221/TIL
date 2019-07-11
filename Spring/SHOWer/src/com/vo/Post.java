package com.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Post {
	public int id;
	public String title;
	public String text;
	public int category;
	public Date regdate;
	public String img1;
	public String img2;
	public String img3;
	public int contents;
	public int reid;
	MultipartFile mf;

	public Post() {
	}

	public Post(int id, String title, String text, int category, Date regdate, String img1, String img2, String img3,
			int contents) {// ÄÁÅÙÃ÷ ¸®ºäÀÏ ¶§¿¡ - »çÁø 3°³´Ù
		this.id = id;
		this.title = title;
		this.text = text;
		this.category = category;
		this.regdate = regdate;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.contents = contents;
	}

	public Post(int id, String title, String text, int category, Date regdate, int contents, int reid
		) {// ´ñ±ÛÀÏ ¶§
		this.id = id;
		this.title = title;
		this.text = text;
		this.category = category;
		this.regdate = regdate;
		this.contents = contents;
		this.reid = reid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public int getContents() {
		return contents;
	}

	public void setContents(int contents) {
		this.contents = contents;
	}

	public int getReid() {
		return reid;
	}

	public void setReid(int reid) {
		this.reid = reid;
	}

	public MultipartFile getMf() {
		return mf;
	}

	public void setMf(MultipartFile mf) {
		this.mf = mf;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", text=" + text + ", category=" + category + ", regdate="
				+ regdate + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", contents=" + contents
				+ ", reid=" + reid + ", mf=" + mf + "]";
	}

}
