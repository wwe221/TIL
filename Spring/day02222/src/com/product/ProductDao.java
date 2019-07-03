package com.product;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.vo.Product;
@Repository("pdao")
public class ProductDao implements Dao<Integer, Product> {
	public void print() {
		System.out.println("ProductDao");
	}
	@Override
	public void insert(Product v) throws Exception {
		System.out.println(v+" Product Inserted...");	
	}

	@Override
	public void update(Product v) throws Exception {
		System.out.println(v+" Product Updated...");	
		
	}

	@Override
	public void delete(Integer k) throws Exception {
		System.out.println( k +" Product Deleted...");			
	}

	@Override
	public Product select(Integer k) throws Exception {	
		return new Product(100, "product", 3000, "img.jpg");
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product(101, "product", 3000, "img1.jpg"));
		list.add(new Product(102, "product2", 7000, "img2.jpg"));
		list.add(new Product(103, "product3", 8000, "img3.jpg"));
		list.add(new Product(104, "product4", 9000, "img4.jpg"));
		list.add(new Product(105, "product5", 4500, "img5.jpg"));
		return list;
	}

}
