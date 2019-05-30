package test;

import java.util.ArrayList;
import java.util.Scanner;

import com.ProductDao;
import com.UserDao;

import frame.Dao;
import vo.Product;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cin = 0;
		Dao<String, Product> dao = new ProductDao();
		ArrayList<Product> in = new ArrayList<Product>();
		Product u = null;
		String k = "";
		System.out.println("INSERT : 1, DELETE : 2, UPDATE : 3 , SELECT : 4 , SELECTALL : 5");
		cin = sc.nextInt();
		String id, name;
		double price;
		try {
			switch (cin) {
			case 1:
				System.out.println("putin ID, NAME , PRICE");
				id = sc.next();
				name = sc.next();
				price = sc.nextDouble();
				u = new Product(id, name, price);
				dao.insert(u);
				break;
			case 2:
				System.out.println("putin ID");
				k = sc.next();
				dao.delete(k);
				break;
			case 3:
				System.out.println("putin ID, NAME , PRICE");
				id = sc.next();
				name = sc.next();
				price = sc.nextDouble();
				u = new Product(id, name, price);
				dao.update(u);
				break;
			case 4:
				System.out.println("putin ID");
				k = sc.next();
				u = dao.select(k);
				System.out.println(u.toString());
				break;
			case 5:
				in = dao.select();
				for (Product tmp : in)
					System.out.println(tmp.toString());
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
