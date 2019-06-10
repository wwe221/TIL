package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Factory;
import vo.Join;
import vo.Products;

public class ProductsDao extends Dao<Integer, Products> {
	@Override
	public void insert(Products v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(Sql.insertProducts);
		try {
			pstmt.setInt(1, v.getPdno());
			pstmt.setString(2, v.getPdname());
			pstmt.setString(3, v.getPdsubname());
			pstmt.setString(4, v.getFactno());
			pstmt.setDate(5, v.getPddate());
			pstmt.setInt(6, v.getPdcost());
			pstmt.setInt(7, v.getPdprice());
			pstmt.setInt(8, v.getPdamount());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void delete(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(Sql.DeleteProducts);
		try {
			pstmt.setInt(1, k);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void update(Products v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(Sql.UpdateProducts);
		try {
			pstmt.setInt(8, v.getPdno());
			pstmt.setString(1, v.getPdname());
			pstmt.setString(2, v.getPdsubname());
			pstmt.setString(3, v.getFactno());
			pstmt.setDate(4, v.getPddate());
			pstmt.setInt(5, v.getPdcost());
			pstmt.setInt(6, v.getPdprice());
			pstmt.setInt(7, v.getPdamount());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}
	@Override
	public Products select(Integer k, Connection con) throws Exception {
		PreparedStatement psm = null;
		ResultSet rs = null;
		Products result;
		psm = con.prepareStatement(Sql.SelectProducts);
		try {
			psm.setInt(1, k);
			psm.executeUpdate();
			rs = psm.executeQuery();
			rs.next();
			result = new Products(rs.getInt("PDNO"),rs.getString("PDNAME"),rs.getString("PDSUBNAME"),rs.getString("FACTNO"),rs.getDate("PDDATE"),rs.getInt("PDCOST"),rs.getInt("PDPRICE"),rs.getInt("PDAMOUNT"));
		} catch (Exception e) {
			throw e;
		} finally {
			close(psm);
			close(rs);
		}
		return result;
	}

	@Override
	public ArrayList<Products> select(Connection con) throws Exception {
		ArrayList<Products> result = new ArrayList<>();
		PreparedStatement psm = null;
		ResultSet rs = null;
		Products u;
		psm = con.prepareStatement(Sql.SelectallProducts);
		try {
			psm.executeUpdate();
			rs = psm.executeQuery();
			while (rs.next()) {
				u = new Products(rs.getInt("PDNO"),rs.getString("PDNAME"),rs.getString("PDSUBNAME"),rs.getString("FACTNO"),rs.getDate("PDDATE"),rs.getInt("PDCOST"),rs.getInt("PDPRICE"),rs.getInt("PDAMOUNT"));
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

	@Override
	public ArrayList<Join> join(Connection con) throws Exception {
		ArrayList<Join> result = new ArrayList<>();
		PreparedStatement psm = null;
		ResultSet rs = null;
		Products u;
		Factory f;
		psm = con.prepareStatement(Sql.SelectallProducts);
		try {
			psm.executeUpdate();
			rs = psm.executeQuery();
			while (rs.next()) {
				//u = new Products(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));				
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getInt(7)+" "+rs.getInt(8));
				//result.add(new Join(f,u));
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
