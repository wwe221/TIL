package db3;

public class ProductDb extends Db<Product, Integer> {
	@Override
	public void insert(Product obj) {
		System.out.println(obj.getId() + " Inserted");
	}
	@Override
	public Product select(Integer obj) {
		Product p = null;
		System.out.println("Search:" + obj);
		p = new Product(300, "shirt", 30000);
		return p;
	}

}
