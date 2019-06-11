package com;

import java.sql.Connection;
import java.util.ArrayList;

import frame.Biz;
import frame.Dao;
import vo.Join;
import vo.Products;

public class ProductsBiz extends Biz<Integer, Products> {
	private Dao<Integer, Products> dao;

	public ProductsBiz() {
		dao = new ProductsDao();
	}

	@Override
	public void register(Products v) throws Exception {
		Connection con = null;
		try {
			con = getcon();
			dao.insert(v, con);			
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;

		} finally {
			close(con);
		}

	}

	@Override
	public void remove(Integer k) throws Exception {
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
	public void modify(Products v) throws Exception {
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
	public Products get(Integer k) throws Exception {
		Connection con = null;
		Products u = null;
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
	public ArrayList<Products> get() throws Exception {
		ArrayList<Products> u = null;
		Connection con = null;
		try {
			con = getcon();
			u = dao.select(con);

		} catch (Exception e) {

			throw e;
		} finally {
			close(con);
		}
		return u;
	}

	@Override
	public ArrayList<Join> join() throws Exception {
		ArrayList<Join> u = null;
		Connection con = null;
		try {
			con = getcon();
			u = dao.join(con);

		} catch (Exception e) {

			throw e;
		} finally {
			close(con);
		}
		return u;
	}


}
