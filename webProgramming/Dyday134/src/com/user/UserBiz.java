package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.vo.User;

import com.frame.Biz;
import com.frame.Dao;

public class UserBiz extends Biz<String, User> {
	Dao<String, User> dao;

	public UserBiz() {
		dao = new UserDao();
	}

	@Override
	public void register(User v) throws Exception {
		Connection con = null;
		try {
			con = getcon();
			dao.insert(v, con);
			// dao.insert(v, con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;

		} finally {
			close(con);
		}

	}

	@Override
	public void remove(String k) throws Exception {
		Connection con = null;
		try {
			con = getcon();
			dao.delete(k, con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;

		} finally {
			close(con);
		}

	}

	@Override
	public void modify(User v) throws Exception {
		Connection con = null;
		try {
			con = getcon();
			dao.update(v, con);
			con.commit();
		} catch (Exception e) {
			
			con.rollback();
			throw e;

		} finally {
			close(con);
		}

	}

	@Override
	public User get(String k) throws Exception {
		Connection con = null;
		User u = null;
		try {
			con = getcon();
			u = dao.select(k, con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}
		return u;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		ArrayList<User> u = null;
		Connection con = null;
		try {
			con = getcon();
			u = dao.select(con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}
		return u;
	}

}
