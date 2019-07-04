package com.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frame.Services;
import com.vo.User;
import com.frame.Dao;
import com.frame.Search;
@Service("ubiz")
public class UserService implements Services<String, User>,
Search<String,User>{
	@Resource(name="udao")
	Dao<String,User> dao;
	@Resource(name="udao")
	Search<String , User> search;
	
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
	@Override
	public ArrayList<User> search(String k) {		
		return search.search(k);
	}

}