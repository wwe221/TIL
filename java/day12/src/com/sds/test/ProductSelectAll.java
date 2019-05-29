package com.sds.test;

import java.util.ArrayList;

import com.sds.component.ProductBiz;
import com.sds.frame.Biz;
import com.sds.vo.Product;

public class ProductSelectAll {

	public static void main(String[] args) {
		Biz<Integer,Product> biz = new ProductBiz();
		Product p1 = new Product(01, "T-shirt", 45000);
		ArrayList<Product> list;
		try {
			list = biz.get();
			for(Product tmp :list)
				System.out.println(tmp);
		} catch (Exception e) {
			System.out.println(" selectAll Error");
			System.out.println(e.getMessage());
			
		}

	}

}
