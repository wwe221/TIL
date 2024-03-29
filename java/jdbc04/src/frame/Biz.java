package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Join;

public abstract class Biz <K,V> {
	private String id;
	private String pwd;
	private String url;

	public Biz() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Oracle DB에 연결 할 것이다! 선언
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading err");
		}
		id = "db";
		pwd = "db";
		url = "jdbc:oracle:thin:@" + "70.12.50.228" + ":" + "1521" + ":xe";
	}

	public Connection getcon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public abstract ArrayList<Join> join() throws Exception;
	public abstract void register(V v) throws Exception;

	public abstract void remove(K k) throws Exception;

	public abstract void modify(V v) throws Exception;

	public abstract V get(K k) throws Exception;

	public abstract ArrayList<V> get() throws Exception;
}
