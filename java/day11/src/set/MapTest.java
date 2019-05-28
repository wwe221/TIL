package set;

import java.util.HashMap;

import db3.Product;

public class MapTest {

	public static void main(String[] args) {
		HashMap<Integer, Product> map = new HashMap<>();
		map.put(1, new Product(1, "t", 3000));
		map.put(2, new Product(2, "t", 4000));
		map.put(2, new Product(2, "t", 33000));
		map.put(3, new Product(3, "t", 5000));
		map.put(4, new Product(4, "t", 6000));
		System.out.println(map.size() + "\n" + map.get(2) + " ");
		map.replace(2, new Product(2,"a",300));
		System.out.println(map.toString());
		

	}

}
