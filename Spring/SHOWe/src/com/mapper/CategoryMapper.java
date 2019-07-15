package com.mapper;

import java.util.ArrayList;

import com.vo.Category;

public interface CategoryMapper {
	public Category select(int obj);
	public ArrayList<Category> selectall();
}
