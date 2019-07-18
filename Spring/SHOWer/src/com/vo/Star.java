package com.vo;

public class Star {
	public int id;
	public String userid;
	public int postid;
	public int score;

	public Star() {
	}

	public Star(int id, String userid, int postid, int score) {
		this.id = id;
		this.userid = userid;
		this.postid = postid;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public String getUserid() {
		return userid;
	}

	public int getPostid() {
		return postid;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Star [id=" + id + ", userid=" + userid + ", postid=" + postid + ", score=" + score + "]";
	}

}
