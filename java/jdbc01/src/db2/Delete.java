package db2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {

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
		// 3. SQL 전송
		String sql = "Delete * FROM T_Product Where ID = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "P01");
			int result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			System.out.println(" err");
			e.printStackTrace();
		}
		// 4. Close all
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
