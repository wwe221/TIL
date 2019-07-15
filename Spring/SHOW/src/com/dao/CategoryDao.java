package com.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.CategoryMapper;
import com.vo.Category;
@Repository("ctdao")
public class CategoryDao implements Dao<Integer, Category>{
	@Autowired
	CategoryMapper cm;	
	public void print() {
		System.out.println("Postdao");		
	}@Override
	public Category select(Integer k) throws Exception {		
		return cm.select(k);
	}

	@Override
	public ArrayList<Category> select() throws Exception {		
		return cm.selectall();
	}
	@Override
	public void insert(Category v) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Category v) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Category> select2(int cate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
