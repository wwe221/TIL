package com.sds.test;

import com.sds.component.ProductBiz;
import com.sds.frame.Biz;
import com.sds.vo.Product;

public class ProductInsertTest {


	public static void main(String[] args) {
		
		Biz<Integer,Product> biz = new ProductBiz();
		Product p1 = new Product(01, "T-shirt", 45000);
		try {
			biz.register(p1);
		} catch (Exception e) {
			System.out.println("Insert Error");
			System.out.println(e.getMessage());
			
		}

	}

}
