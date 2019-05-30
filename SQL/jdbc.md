# JDBC

```java
// 1. JDBC Driver Loading..
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Oracle DB에 연결 할 것이다! 선언
		} catch (ClassNotFoundException e) {
			System.out.println("DRiver Loading err");
		}
		// 2. Connection 1521:포트 workspace = db, pwd = db
		String id = "db";
		String pwd = "db";
		String url = "jdbc:oracle:thin:@" + "70.12.50.222"+ ":" + "1521" + ":xe";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			System.out.println("Connection err");
			System.out.println(e.getMessage());
		}
		// 3. SQL 전송
		String sql = "INSERT INTO T_USER VALUES" + "(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
            //setString(n번째 물음표, 값)
			pstmt.setString(1, "id20");
			pstmt.setString(2, "pwd20");
			pstmt.setString(3, "폰말년");
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
```

```java
String sql = "Select * from T_user";
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		//pstmt 가 sql에 접근해서 return 을 받아올수 있는 녀석
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			rset = pstmt.executeQuery(); //pstmt의 return 받기
			while (rset.next()) {
				String uid = rset.getString("ID");
				String upwd = rset.getString("PWD");
				String uname = rset.getString("NAME");
				System.out.println(uid + upwd + uname);

			}
		} catch (SQLException e) {
			System.out.println(" err");
			e.printStackTrace();
		}
```



