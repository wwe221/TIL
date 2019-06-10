package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Factory;
import vo.Join;
import vo.Factory;

public class FactoryDao extends Dao<String, Factory> {
	@Override
	public void insert(Factory v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertFactory);
			pstmt.setString(1, v.getFactno());
			pstmt.setString(2, v.getFacname());
			pstmt.setString(3, v.getFacloc());
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
		try {
			pstmt = con.prepareStatement(Sql.DeleteFactory);
			pstmt.setString(1, k);

			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void update(Factory v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.UpdateFactory);
			pstmt.setString(1, v.getFactno());
			pstmt.setString(2, v.getFacname());
			pstmt.setString(3, v.getFacloc());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public Factory select(String k, Connection con) throws Exception {

		PreparedStatement pstmt = null;
		Factory result = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(Sql.SelectFactory);
			pstmt.setString(1, k);
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			rs.next();
			result = new Factory(rs.getString("FACTNO"), rs.getString("FACNAME"), rs.getString("FACLOC"));
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(rs);
		}

		return result;
	}

	@Override
	public ArrayList<Factory> select(Connection con) throws Exception {
		ArrayList<Factory> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Factory u;
		try {
			pstmt = con.prepareStatement(Sql.SelectallFactory);
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Factory(rs.getString("FACTNO"), rs.getString("FACNAME"), rs.getString("FACLOC"));
				result.add(u);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	@Override
	public ArrayList<Join> join(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
