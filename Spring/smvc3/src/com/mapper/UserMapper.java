package com.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.vo.User;

public interface UserMapper {
	public void insert(User obj);
	public void delete(String obj);
	public void update(User obj);
	public User select(String obj);
	public ArrayList<User> selectall();
}



