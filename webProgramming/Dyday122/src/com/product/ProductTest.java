package com.product;
import com.vo.Product;

import com.frame.Biz;

public class ProductTest {
	public static void main(String[] args) {		
		Biz<Integer, Product> biz = new ProductBiz();
		Product u = new Product("Book", 100000,"img3.jpg");
		Product u2 = new Product(102,"Phone", 100000,"img3.jpg");
		try {
			//biz.register(u);
			//biz.register(u);
			//biz.remove(100);
			biz.modify(u2);
			for(Product k :biz.get()){
				System.out.println(k);
			}
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
