package com.test;

public class UserBiz implements Biz{
	public Dao dao;
	
	@Override
	public void register() {		
		dao.insert();
	}
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	@Override
	public String toString() {
		return "UserBiz [dao=" + dao + "]";
	}
	
}
