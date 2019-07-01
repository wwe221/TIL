package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.vo.User;

import com.frame.Dao;
import com.frame.Sql;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(Sql.insertUser);
		try {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
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
		pstmt = con.prepareStatement(Sql.deleteUser);
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
	public void update(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(Sql.updateUser);
		try {
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public User select(String k, Connection con) throws Exception {
		PreparedStatement psm = null;
		ResultSet rs = null;
		User result;
		psm = con.prepareStatement(Sql.selectUser);
		try {
			psm.setString(1, k);
			psm.executeUpdate();
			rs = psm.executeQuery();
			rs.next();
			result = new User(rs.getString("ID"), rs.getString("PWD"), rs.getString("NAME"));
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(rs);
		}
		return result;
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		ArrayList<User> result = new ArrayList<>();
		PreparedStatement psm = null;
		ResultSet rs = null;
		User u;
		psm = con.prepareStatement(Sql.selectAllUser);
		try {
			psm.executeUpdate();
			rs = psm.executeQuery();
			while (rs.next()) {
				u = new User(rs.getString("ID"), rs.getString("PWD"), rs.getString("NAME"));
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
