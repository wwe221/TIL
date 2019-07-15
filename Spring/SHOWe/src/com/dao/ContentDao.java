package com.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.ContentMapper;
import com.vo.Content;
@Repository("cdao")
public class ContentDao implements Dao<Integer, Content>{
	@Autowired
	ContentMapper cm;	
	public void print() {
		System.out.println("Postdao");		
	}
	@Override
	public String toString() {
		return "ContentDao [cm=" + cm + "]";
	}
	@Override
	public void insert(Content v) throws Exception {
		cm.insert(v);
		System.out.println(v + "Postdao Inserted...");
	}

	@Override
	public void update(Content v) throws Exception {
		cm.update(v);
		System.out.println(v + "Postdao Updated...");
	}

	@Override
	public void delete(Integer k) throws Exception {
		cm.delete(k);
		System.out.println(k + "Postdao Deleted...");
	}

	@Override
	public Content select(Integer k) throws Exception {		
		return cm.select(k);
	}

	@Override
	public ArrayList<Content> select() throws Exception {		
		return cm.selectall();
	}

}
