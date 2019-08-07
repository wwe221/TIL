package com.dao;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.UserMapper;
import com.vo.User;
@Repository("udao")
public class UserDao implements Dao<String, User>{
	@Autowired
	UserMapper um;	
	public void print() {
		System.out.println("OracleDao");		
	}
	@Override
	public String toString() {
		return "UserDao [um=" + um + "]";
	}
	@Override
	public void insert(User v) throws Exception {
		um.insert(v);
		System.out.println(v + "UserOracleDao Inserted...");
	}

	@Override
	public void update(User v) throws Exception {
		um.update(v);
		System.out.println(v + "UserOracleDao Updated...");
	}

	@Override
	public void delete(String k) throws Exception {
		um.delete(k);
		System.out.println(k + "UserOracleDao Deleted...");
	}

	@Override
	public User select(String k) throws Exception {		
		return um.select(k);
	}

	@Override
	public ArrayList<User> select() throws Exception {		
		return um.selectall();
	}
	@Override
	public ArrayList<User> select2(int cate) throws Exception {
		return null;
	}

}
