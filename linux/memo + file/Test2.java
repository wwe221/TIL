package oracledb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Product;

public class Test2 {

	public static void main(String[] args) throws Exception {
		String id = "user1";
		String pwd = "111111";
		String id2="db";
		String s1_mdb_url = "jdbc:mariadb://192.168.111.111:3306/shop";
		String s2_orc_url = "jdbc:oracle:thin:@192.168.111.112:1521:XE";
		String s2_mdb_url = "jdbc:mariadb://192.168.111.112:3306/shop";

		Class.forName("oracle.jdbc.OracleDriver");

		Connection s1_mdb_con = DriverManager.getConnection(s1_mdb_url, id, pwd);

		String sql = "SELECT * FROM PRODUCT";

		PreparedStatement pstmt1 = s1_mdb_con.prepareStatement(sql);

		ResultSet rset = pstmt1.executeQuery();
		ArrayList<Product> list = null;

		Connection s2_mdb_con = DriverManager.getConnection(s2_mdb_url, id, pwd);
		String sql2 = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
		PreparedStatement pstmt2;

		Connection s3_orc_con = DriverManager.getConnection(s2_orc_url, id2, pwd);
		String sql3 = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
		PreparedStatement pstmt3;

		
		while (rset.next()) {
			int iid = rset.getInt("ID");
			String name = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			Date regdate = rset.getDate("REGDATE");
			pstmt2 = s2_mdb_con.prepareStatement(sql2);
			pstmt3 = s3_orc_con.prepareStatement(sql3);
			System.out.println(iid + " " + name + " " + price + " " + regdate);
			
			pstmt2.setInt(1, iid);
			pstmt2.setString(2, name);
			pstmt2.setInt(3, price);
			pstmt2.setDate(4, regdate);
			pstmt2.executeQuery();
			System.out.println("11111111111");
			
			pstmt3.setInt(1, iid);
			pstmt3.setString(2, name);
			pstmt3.setInt(3, price);
			pstmt3.setDate(4, regdate);
			pstmt3.executeQuery();
			System.out.println("222222222222");
			
		}

		

	}

}
