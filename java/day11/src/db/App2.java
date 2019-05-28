package db;

public class App2 {
public static void main(String[] args) {
		Product pp = new Product("ptd123", "Phone", 987654);
		Biz b = new ProductBiz("192.168.111.156");
		b.register(pp);
		b.remove("i101");
		Product prd = null;
		prd = (Product) b.get("i101");
		System.out.println(prd);

	}

}
