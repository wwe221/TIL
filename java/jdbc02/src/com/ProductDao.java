package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Product;

public class ProductDao extends Dao<String, Product> {

	@Override
	public void insert(Product v) throws Exception {
		PreparedStatement psm = null;
		Connection con = null;
		con = getcon();
		psm = con.prepareStatement(Sql.insertProduct);
		try {
			psm.setString(1, v.getId());
			psm.setString(2, v.getName());
			psm.setDouble(3, v.getPrice());
			psm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(con);
		}

	}

	@Override
	public void delete(String k) throws Exception {
		PreparedStatement psm = null;
		Connection con = null;
		con = getcon();
		psm = con.prepareStatement(Sql.deleteProduct);
		try {
			psm.setString(1, k);

			psm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(con);
		}
	}

	@Override
	public void update(Product v) throws Exception {
		PreparedStatement psm = null;
		Connection con = null;
		con = getcon();
		psm = con.prepareStatement(Sql.updateProduct);
		try {
			psm.setString(3, v.getId());
			psm.setDouble(2, v.getPrice());
			psm.setString(1, v.getName());
			psm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(con);
		}
	}

	@Override
	public Product select(String v) throws Exception {
		PreparedStatement psm = null;
		Connection con = null;
		ResultSet rs = null;
		Product result;
		con = getcon();
		psm = con.prepareStatement(Sql.selectProduct);
		try {
			psm.setString(1, v);
			psm.executeUpdate();
			rs = psm.executeQuery();
			rs.next();
			result = new Product(rs.getString("ID"), rs.getString("NAME"), rs.getDouble("PRICE")
					);
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(con);
			close(rs);
		}
		return result;
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> result = new ArrayList<>();
		PreparedStatement psm = null;
		Connection con = null;
		ResultSet rs = null;
		con = getcon();
		Product u;
		psm = con.prepareStatement(Sql.selectAllProduct);
		try {
			psm.executeUpdate();
			rs = psm.executeQuery();
			while (rs.next()) {
				u = new Product(rs.getString("ID"), rs.getString("NAME"), rs.getDouble("PRICE"));
				result.add(u);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(con);
			close(rs);
		}
		return result;
	}

}
