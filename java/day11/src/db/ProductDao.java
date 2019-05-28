package db;

public class ProductDao extends Dao {

	public ProductDao() {
	}

	public ProductDao(String ip) {
		super(ip);
	}

	@Override
	public void insert(Object obj) {
		connection();
		Product u = (Product) obj;
		System.out.println(u.getName());
		close();

	}

	@Override
	public Object select(Object obj) {
		Product u = null;
		String str = (String) obj;
		connection();
		u = new Product("pid237", "Book", 5700.5);

		close();
		return u;
	}

	@Override
	public void delete(Object obj) {
		String str = (String) obj;
		connection();
		System.out.println(str + " is deleted");
		close();

	}

}
