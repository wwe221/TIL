import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {
	public static void main(String[] args) throws Exception{
		String id ="sn";
		String pwd ="sn";
		String url ="jdbc:oracle:thin:@192.168.111.112:1521:XE";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, id, pwd);	

		String sql = "SELECT * FROM dept";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rset = pstmt.executeQuery();
		while(rset.next()) {
			int iid = rset.getInt("deptno");
			System.out.println(iid);
		}
	}
}