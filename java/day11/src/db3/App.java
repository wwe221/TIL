package db3;

public class App {

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Db<User, String> db = new UserDb();
		User s = new User("Henry", "id123", "pwd33");
		db.insert(s);
		
		
		Db<Product, Integer> db2 = new ProductDb();		
		Product p = new Product(100, "Pants", 49000);
		db2.insert(p);
		Product get = db2.select(300);
		System.out.println(get);

	}

}
