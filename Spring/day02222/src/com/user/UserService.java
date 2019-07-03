package com.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.frame.Services;
import com.vo.User;
import com.frame.Dao;
@Service("ubiz")
public class UserService implements Services<String, User> {
	@Autowired
	Dao<String,User> dao;
	
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
		if(k.equals("id00"))
			throw new Exception("Not Found 404");
		Thread.sleep(2700);
		return dao.select(k);
	}

	@Override
	public ArrayList<User> select() throws Exception {
		return dao.select();
	}

}







