package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Biz;
import com.vo.Content;
@Service("cbiz")
public class ContentBiz implements Biz<Integer, Content>{
	@Resource(name="cdao")
	Dao<Integer,Content> dao;
	public void startBiz() {
		System.out.println("pBiz Start");
	}
	@Override
	public String toString() {
		return "ContentBiz [dao=" + dao + "]";
	}
	public void endBiz() {
		System.out.println("pBiz End");
	}
	public void setDao(Dao<Integer, Content> dao) {
		this.dao = dao;
	}
	@Override
	public void insert(Content v) throws Exception {
		dao.insert(v);		
	}

	@Override
	public void update(Content v) throws Exception {
		dao.update(v);

	}

	@Override
	public void delete(Integer k) throws Exception {
		dao.delete(k);

	}

	@Override
	public Content select(Integer k) throws Exception {			
		return dao.select(k);
	}

	@Override
	public ArrayList<Content> select() throws Exception {
		return dao.select();
	}	
	@Override
	public ArrayList<Content> select2(int cate) throws Exception {
		// TODO Auto-generated method stub
		return dao.select2(cate);
	}
	

}