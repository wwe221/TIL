package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAll {

	public static void main(String[] args) {
		// 1. JDBC Driver Loading..
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Oracle DB에 연결 할 것이다! 선언
		} catch (ClassNotFoundException e) {
			System.out.println("DRiver Loading err");
		}
		// 2. Connection 1521 포트 workspace = db, pwd = db
		String id = "db";
		String pwd = "db";
		String url = "jdbc:oracle:thin:@" + "70.12.50.222" + ":" + "1521" + ":xe";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			System.out.println("Connection err");
			System.out.println(e.getMessage());
		}
		// 3. SQL 전송 & Receive
		String sql = "Select * from T_user";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {

			pstmt = con.prepareStatement(sql);
			// int result = pstmt.executeUpdate();
			pstmt.executeUpdate();
			rset = pstmt.executeQuery();

			while (rset.next()) {
				
				String uid = rset.getString("ID");
				String upwd = rset.getString("PWD");
				String uname = rset.getString("NAME");
				System.out.printf("%s %s %s\n",uid,upwd,uname);

			}
		} catch (SQLException e) {
			System.out.println(" err");
			e.printStackTrace();
		}
		// 4. Close all
		try {
			pstmt.close();
			con.close();
			rset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
