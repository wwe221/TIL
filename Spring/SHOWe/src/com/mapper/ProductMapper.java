package com.mapper;

import java.util.ArrayList;

import com.vo.Post;

public interface ProductMapper {
	public void insert(Post obj);
	public void delete(int obj);
	public void update(Post obj);
	public Post select(int obj);
	public ArrayList<Post> selectall();
}



