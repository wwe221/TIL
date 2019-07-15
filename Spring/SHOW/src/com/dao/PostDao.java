package com.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.PostMapper;
import com.vo.Post;
@Repository("pdao")
public class PostDao implements Dao<Integer, Post>{
	@Autowired
	PostMapper um;	
	public void print() {
		System.out.println("Postdao");		
	}
	@Override
	public void insert(Post v) throws Exception {
		um.insert(v);
		System.out.println(v + "Postdao Inserted...");
	}

	@Override
	public void update(Post v) throws Exception {
		um.update(v);
		System.out.println(v + "Postdao Updated...");
	}

	@Override
	public void delete(Integer k) throws Exception {
		um.delete(k);
		System.out.println(k + "Postdao Deleted...");
	}

	@Override
	public Post select(Integer k) throws Exception {		
		return um.select(k);
	}

	@Override
	public ArrayList<Post> select() throws Exception {		
		return um.selectall();
	}
	@Override
	public ArrayList<Post> select2(int cate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
