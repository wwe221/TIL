package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Biz;
import com.vo.Star;
@Service("sbiz")
public class StarBiz implements Biz<Integer, Star>{
	@Resource(name="sdao")
	Dao<Integer,Star> dao;
	public void startBiz() {
		System.out.println("pBiz Start");
	}
	public void endBiz() {
		System.out.println("pBiz End");
	}
	public void setDao(Dao<Integer, Star> dao) {
		this.dao = dao;
	}
	@Override
	public void insert(Star v) throws Exception {
		dao.insert(v);		
	}

	@Override
	public void update(Star v) throws Exception {
		dao.update(v);

	}

	@Override
	public void delete(Integer k) throws Exception {
		dao.delete(k);

	}

	@Override
	public Star select(Integer k) throws Exception {			
		return dao.select(k);
	}

	@Override
	public ArrayList<Star> select() throws Exception {
		return dao.select();
	}

}