package frame;

public class Sql {
	public static String insertProducts = "INSERT INTO PRODUCTS VALUES(?,?,?,?,?,?,?,?)";
	public static String DeleteProducts = "DELETE FROM PRODUCTS WHERE PDNO = ?";
	public static String UpdateProducts = "UPDATE PRODUCTS SET PDNAME=?,PDSUBNAME=?,FACTNO=?,PDDATE=?,PDCOST=?,PDPRICE=?,PDAMOUNT=? WHERE PDNO=?";
	public static String SelectProducts = "SELECT * FROM PRODUCTS WHERE PDNO = ?";
	public static String SelectallProducts = "SELECT * FROM PRODUCTS";

	public static String insertFactory = "INSERT INTO FACTORY VALUES(?,?,?)";
	public static String DeleteFactory = "DELETE FROM FACTORY WHERE FACTNO = ?";
	public static String UpdateFactory = "UPDATE FACTORY SET FACNAME =?, FACLOC = ? WHERE FACTNO=?";
	public static String SelectFactory = "SELECT * FROM FACTORY WHERE FACTNO = ?";
	public static String SelectallFactory = "SELECT * FROM FACTORY";
	public static String selectJoin = "select P.PDNO , P.PDNAME , F.FACTNO , F.FACNAME, P.PDSUBNAME , P.FACTNO , P.PDCOST. P.PDPRICE, P.PDAMOUNT , F.FACLOC from PRODUCTS P, FACTORY F" + "where P.FACTNO = F.FACTNO";

}
