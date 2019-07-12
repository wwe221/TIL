package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Biz;
import com.vo.Category;
@Service("ctbiz")
public class CategoryBiz implements Biz<Integer, Category>{
	@Resource(name="ctdao")
	Dao<Integer,Category> dao;
	public void startBiz() {
		System.out.println("pBiz Start");
	}
	public void endBiz() {
		System.out.println("pBiz End");
	}
	public void setDao(Dao<Integer, Category> dao) {
		this.dao = dao;
	}
	@Override
	public void insert(Category v) throws Exception {
		dao.insert(v);		
	}

	@Override
	public void update(Category v) throws Exception {
		dao.update(v);

	}

	@Override
	public void delete(Integer k) throws Exception {
		dao.delete(k);

	}

	@Override
	public Category select(Integer k) throws Exception {			
		return dao.select(k);
	}

	@Override
	public ArrayList<Category> select() throws Exception {
		return dao.select();
	}

}