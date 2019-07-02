package com.test;

public class UserBiz implements Biz{
	public Dao dao;
	
	public UserBiz(Dao dao) {		
		this.dao = dao;
	}
	public UserBiz() {
	}
	@Override
	public void register() {		
		dao.insert();
	}
	public Dao getDao() {
		return dao;
	}
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	@Override
	public String toString() {
		return "UserBiz [dao=" + dao + "]";
	}
	
}
