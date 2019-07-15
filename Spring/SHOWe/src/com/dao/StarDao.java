package com.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.StarMapper;
import com.vo.Star;
@Repository("sdao")
public class StarDao implements Dao<Integer, Star>{
	@Autowired
	StarMapper um;	
	public void print() {
		System.out.println("Postdao");		
	}
	@Override
	public void insert(Star v) throws Exception {
		um.insert(v);
		System.out.println(v + "Postdao Inserted...");
	}

	@Override
	public void update(Star v) throws Exception {
		um.update(v);
		System.out.println(v + "Postdao Updated...");
	}

	@Override
	public void delete(Integer k) throws Exception {
		um.delete(k);
		System.out.println(k + "Postdao Deleted...");
	}

	@Override
	public Star select(Integer k) throws Exception {		
		return um.select(k);
	}

	@Override
	public ArrayList<Star> select() throws Exception {		
		return um.selectall();
	}

}
