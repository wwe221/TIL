package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<K, V> {
	String id;
	String pwd;
	String url;

	public Dao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Oracle DB에 연결 할 것이다! 선언
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading err");
		}
		id = "db";
		pwd = "db";
		url = "jdbc:oracle:thin:@" + "70.12.50.222" + ":" + "1521" + ":xe";
	}

	public Connection getcon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
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

	public void close(PreparedStatement con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void close(ResultSet con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public abstract void insert(V v) throws Exception;

	public abstract void delete(K k) throws Exception;

	public abstract void update(V v) throws Exception;

	public abstract V select(K k) throws Exception;

	public abstract ArrayList<V> select() throws Exception;
}
