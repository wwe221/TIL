package com.vo;



import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Post {

	public int id;
	public String title;
	public String text;
	public Date pdate;
	public int cate;
	public String writer;
	public String img1;
	public String img2;
	public String img3;
	public int contents;
	public int reid;
	MultipartFile mf;
	
	public Post(int id, String title, String text, int category, Date regdate, String writer, String img1, String img2,
			String img3, int contents, int reid, MultipartFile mf) {
		super();
		this.pdate = new Date(2016);
		this.id = id;
		this.title = title;
		this.text = text;
		this.cate = category;
		this.pdate = regdate;
		this.writer = writer;
		this.img1 = "1";
		this.img2 = "1";
		this.img3 = "1";
		this.contents = contents;
		this.reid = reid;
		this.mf = mf;
	}

	

	public Post() {
	}

	public Post(int id, String title, String text, int category, Date regdate, String img1, String img2, String img3,
			int contents) {// ƒ¡≈Ÿ√˜ ∏Æ∫‰¿œ ∂ßø° - ªÁ¡¯ 3∞≥¥Ÿ
		this.id = id;
		this.title = title;
		this.text = text;
		this.cate = category;
		this.pdate = regdate;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Post(int id, String title, String text, int category, Date regdate, int contents, int reid) {// ¥Ò±€¿œ ∂ß
		this.id = id;
		this.title = title;
		this.text = text;
		this.cate = category;
		this.pdate = regdate;
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
		return cate;
	}

	public void setCategory(int category) {
		this.cate = category;
	}

	public Date getRegdate() {
		return pdate;
	}

	public void setRegdate(Date regdate) {
		this.pdate = regdate;
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
		return "Post [id=" + id + ", title=" + title + ", text=" + text + ", regdate=" + pdate + ", cate=" + cate
				+ ", writer=" + writer + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", contents="
				+ contents + ", reid=" + reid + ", mf=" + mf + "]";
	}

	

}
