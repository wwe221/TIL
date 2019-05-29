package com.sds.component;

import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(User v) throws Exception {
		if (v.getId().equals("id02")) {
			throw new Exception(" E0001");
		}
		System.out.println(v + " Inserted ..");

	}

	@Override
	public void delete(String k) throws Exception {
		// TODO Auto-generated method stub
		if (k.equals("id02")) {
			throw new Exception(" E0002");
		}
		System.out.println(k + " Deleted ..");

	}

	@Override
	public void update(User v) throws Exception {
		// TODO Auto-generated method stub
		if (v.getId().equals("id02")) {
			throw new Exception(" E0003");
		}
		System.out.println(v + " Updated ..");

	}

	@Override
	public User select(String k) throws Exception {
		User u = new User("james", k, "pwd12312");
		return u;
	}

	@Override
	public ArrayList<User> select() throws Exception {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("lee", "id01", "pwd123"));
		list.add(new User("park", "id02", "pwd654"));
		list.add(new User("kim", "id03", "pwd987"));
		list.add(new User("lim", "id04", "pwd741"));
		list.add(new User("jang", "id05", "pwd852"));
		return list;
	}

}
