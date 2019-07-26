import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test2 {
	public static void main(String[] args) throws Exception{
		String id ="user1";
		String pwd ="111111";
		String url ="jdbc:mariadb://192.168.111.137:3306/shop";
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, id, pwd);	

		String sql = "SELECT * FROM PRODUCT";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rset = pstmt.executeQuery();
		while(rset.next()) {
			int iid = rset.getInt("ID");
			String name = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			String regdate = rset.getString("REGDATE");
			System.out.println(iid+" "+name+" "+price+" "+regdate);
		}
	}
}