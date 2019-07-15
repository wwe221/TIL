package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Biz;
import com.vo.Post;
@Service("pbiz")
public class PostBiz implements Biz<Integer, Post>{
	@Resource(name="pdao")
	Dao<Integer,Post> dao;
	public void startBiz() {
		System.out.println("pBiz Start");
	}
	public void endBiz() {
		System.out.println("pBiz End");
	}
	public void setDao(Dao<Integer, Post> dao) {
		this.dao = dao;
	}
	@Override
	public void insert(Post v) throws Exception {
		dao.insert(v);		
	}

	@Override
	public void update(Post v) throws Exception {
		dao.update(v);

	}

	@Override
	public void delete(Integer k) throws Exception {
		dao.delete(k);

	}

	@Override
	public Post select(Integer k) throws Exception {			
		return dao.select(k);
	}

	@Override
	public ArrayList<Post> select() throws Exception {
		return dao.select();
	}
	@Override
	public ArrayList<Post> select2(int cate) throws Exception {		
		return dao.select2(cate);
	}
	

}