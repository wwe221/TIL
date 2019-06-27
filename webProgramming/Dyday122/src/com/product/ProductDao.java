package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import com.vo.Product;
public class ProductDao extends Dao<String, Product> {

	@Override
	public void insert(Product v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(Sql.insertProduct);
		try {
			pstmt.setString(1, v.getId());			
			pstmt.setString(2, v.getName());
			pstmt.setDouble(3, v.getPrice());
			pstmt.setDate(4, v.getRegdate());
			pstmt.setString(5, v.getImgname());		
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void delete(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(Sql.deleteProduct);
		try {
			pstmt.setString(1, k);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void update(Product v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(Sql.updateProduct);
		try {
			pstmt.setString(1, v.getName());
			pstmt.setDouble(2, v.getPrice());
			pstmt.setString(3, v.getImgname());
			pstmt.setString(4, v.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public Product select(String k, Connection con) throws Exception {
		PreparedStatement psm = null;
		ResultSet rs = null;
		Product result;
		psm = con.prepareStatement(Sql.selectProduct);
		try {
			psm.setString(1, k);
			psm.executeUpdate();
			rs = psm.executeQuery();
			rs.next();
			result = new Product(rs.getString("ID"),rs.getString("NAME"), rs.getDouble("PRICE"), rs.getString("IMGNAME"));
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(rs);
		}
		return result;
	}

	@Override
	public ArrayList<Product> select(Connection con) throws Exception {
		ArrayList<Product> result = new ArrayList<>();
		PreparedStatement psm = null;
		ResultSet rs = null;
		Product u;
		psm = con.prepareStatement(Sql.selectAllProduct);
		try {
			psm.executeUpdate();
			rs = psm.executeQuery();
			while (rs.next()) {
				u = new Product(rs.getString("ID"),rs.getString("NAME"), rs.getDouble("PRICE"), rs.getString("IMGNAME"));
				result.add(u);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(rs);
		}
		return result;
	}

}
