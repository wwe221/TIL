package com.mapper;

import java.util.ArrayList;

import com.vo.Content;

public interface ContentMapper {
	public void insert(Content obj);
	public void delete(int obj);
	public void update(Content obj);
	public Content select(int obj);
	public ArrayList<Content> selectall();
}
