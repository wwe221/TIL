package com.mapper;

import java.util.ArrayList;

import com.vo.Star;

public interface StarMapper {
	public void insert(Star obj);
	public void delete(int obj);
	public void update(Star  obj);
	public Star select(int obj);
	public ArrayList<Star> selectall();
}
