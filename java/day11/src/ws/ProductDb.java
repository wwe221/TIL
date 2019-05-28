package ws;

import java.util.HashMap;
 
public class ProductDb extends Db<Product, Integer, HashMap<Integer, Product>> {
	
 
	@Override
	public void insert(Product obj) {
		System.out.println(obj.getId() + " Inserted");
	}

	@Override
	public Product select(Integer obj) {
		Product p = null;
		System.out.print("Search: " + obj + "  ");
		p = new Product(300, "shirt", 30000);
		return p;
	}

	@Override
	public void delete(Integer obj) {
		String str = obj.toString();
		System.out.println(str + " is deleted");
	}

	@Override
	public HashMap<Integer, Product> select() {
		HashMap<Integer, Product> map = new HashMap<>();
		map.put(1, new Product(1, "a", 3000));
		map.put(2, new Product(2, "b", 4000));
		map.put(2, new Product(2, "c", 33000));
		map.put(3, new Product(3, "d", 5000));
		map.put(4, new Product(4, "e", 6000));
		return map;
	}

	@Override
	public void Update(Product obj) {
		String str = obj.toString();
		System.out.println(str + " is Updated");

	}

}
