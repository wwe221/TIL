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
	public String img01;
	public String img02;
	public String img03;
	public int contents;
	public int reid;
	public int star;
	MultipartFile mf1;
	MultipartFile mf2;
	MultipartFile mf3;
	

	public int getStar() {
		return star;
	}
				
	public void setStar(int star) {
		this.star = star;
	}

	public Post(int id, String title, String text, Date pdate, int cate, String writer, String img01, String img02,
			String img03, int contents, int reid, MultipartFile mf1, MultipartFile mf2, MultipartFile mf3) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.pdate = pdate;
		this.cate = cate;
		this.writer = writer;
		this.img01 = img01;
		this.img02 = img02;
		this.img03 = img03;
		this.contents = contents;
		this.reid = reid;
		this.mf1 = mf1;
		this.mf2 = mf2;
		this.mf3 = mf3;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public int getCate() {
		return cate;
	}

	public void setCate(int cate) {
		this.cate = cate;
	}

	public String getImg01() {
		return img01;
	}

	public void setImg01(String img01) {
		this.img01 = img01;
	}

	public String getImg02() {
		return img02;
	}

	public void setImg02(String img02) {
		this.img02 = img02;
	}

	public String getImg03() {
		return img03;
	}

	public void setImg03(String img03) {
		this.img03 = img03;
	}

	public MultipartFile getMf1() {
		return mf1;
	}

	public void setMf1(MultipartFile mf1) {
		this.mf1 = mf1;
	}

	public MultipartFile getMf2() {
		return mf2;
	}

	public void setMf2(MultipartFile mf2) {
		this.mf2 = mf2;
	}

	public MultipartFile getMf3() {
		return mf3;
	}

	public void setMf3(MultipartFile mf3) {
		this.mf3 = mf3;
	}

	public Post() {
	}

	public Post(int id, String title, String text, int category, Date regdate, String img1, String img2, String img3,
			int contents) {// ÄÁÅÙÃ÷ ¸®ºäÀÏ ¶§¿¡ - »çÁø 3°³´Ù
		this.id = id;
		this.title = title;
		this.text = text;
		this.cate = category;
		this.pdate = regdate;
		this.img01 = img1;
		this.img02 = img2;
		this.img03 = img3;
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Post(int id, String title, String text, int category, Date regdate, int contents, int reid) {// ´ñ±ÛÀÏ ¶§
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
		return img01;
	}

	public void setImg1(String img1) {
		this.img01 = img1;
	}

	public String getImg2() {
		return img02;
	}

	public void setImg2(String img2) {
		this.img02 = img2;
	}

	public String getImg3() {
		return img03;
	}

	public void setImg3(String img3) {
		this.img03 = img3;
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

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", text=" + text + ", pdate=" + pdate + ", cate=" + cate
				+ ", writer=" + writer + ", img01=" + img01 + ", img02=" + img02 + ", img03=" + img03 + ", contents="
				+ contents + ", reid=" + reid + ", star=" + star + ", mf1=" + mf1 + ", mf2=" + mf2 + ", mf3=" + mf3
				+ "]";
	}

}
