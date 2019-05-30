package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(User v) throws Exception {
		PreparedStatement psm = null;
		Connection con = null;
		con = getcon();
		psm = con.prepareStatement(Sql.insertUser);
		try {
			psm.setString(1, v.getId());
			psm.setString(2, v.getPwd());
			psm.setString(3, v.getName());
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
		psm = con.prepareStatement(Sql.deleteUser);
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
	public void update(User v) throws Exception {
		PreparedStatement psm = null;
		Connection con = null;
		con = getcon();
		psm = con.prepareStatement(Sql.updateUser);
		try {
			psm.setString(3, v.getId());
			psm.setString(1, v.getPwd());
			psm.setString(2, v.getName());
			psm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(con);
		}
	}

	@Override
	public User select(String v) throws Exception {
		PreparedStatement psm = null;
		Connection con = null;
		ResultSet rs = null;
		User result;
		con = getcon();
		psm = con.prepareStatement(Sql.selectUser);
		try {
			psm.setString(1, v);
			psm.executeUpdate();
			rs = psm.executeQuery();
			rs.next();
			result = new User(rs.getString("ID"), rs.getString("PWD"), rs.getString("NAME"));
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
	public ArrayList<User> select() throws Exception {
		ArrayList<User> result = new ArrayList<>();
		PreparedStatement psm = null;
		Connection con = null;
		ResultSet rs = null;
		con = getcon();
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
			close(con);
			close(rs);
		}
		return result;
	}

}
