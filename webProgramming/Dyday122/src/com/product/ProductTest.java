package com.product;
import com.vo.Product;

import com.frame.Biz;

public class ProductTest {
	public static void main(String[] args) {		
		Biz<String, Product> biz = new ProductBiz();
		Product u = new Product("id123", "Book", 4500,"img2.jpg");
		try {
			biz.register(u);
			//biz.register(u);
			//biz.remove("id0");
			//biz.modify(u);
			for(Product k :biz.get()){
				System.out.println(k);
			}
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
