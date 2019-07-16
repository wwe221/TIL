package com.mapper;

import java.util.ArrayList;

import com.vo.Post;

public interface PostMapper {
	public void insert(Post obj);
	public void delete(int obj);
	public void update(Post obj);
	public Post select(int obj);
	public ArrayList<Post> selectall();
	public ArrayList<Post> selectall2(int obj);
}
