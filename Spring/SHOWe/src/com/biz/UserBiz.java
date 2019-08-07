package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Biz;
import com.vo.User;
@Service("ubiz")
public class UserBiz implements Biz<String, User>{
	@Resource(name="udao")
	Dao<String,User> dao;
	@Override
	public String toString() {
		return "UserBiz [dao=" + dao + "]";
	}
	public void startBiz() {
		System.out.println("Biz Start");
	}
	public void endBiz() {
		System.out.println("Biz End");
	}
	public void setDao(Dao<String, User> dao) {
		this.dao = dao;
	}
	@Override
	public void insert(User v) throws Exception {
		dao.insert(v);		
	}

	@Override
	public void update(User v) throws Exception {
		dao.update(v);

	}

	@Override
	public void delete(String k) throws Exception {
		dao.delete(k);

	}

	@Override
	public User select(String k) throws Exception {			
		return dao.select(k);
	}

	@Override
	public ArrayList<User> select() throws Exception {
		return dao.select();
	}
	
	@Override
	public ArrayList<User> select2(int cate) throws Exception {	
		return dao.select2(cate);
	}

}