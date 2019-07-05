package com.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.ProductMapper;
import com.vo.Product;
@Repository("pdao")
public class ProductDao implements Dao<Integer, Product> {
	@Autowired
	ProductMapper pm;
	public void print() {
		System.out.println("ProductDao");
	}
	@Override
	public void insert(Product v) throws Exception {
		pm.insert(v);
		System.out.println(v+" Product Inserted...");	
	}

	@Override
	public void update(Product v) throws Exception {
		pm.update(v);
		System.out.println(v+" Product Updated...");	
		
	}

	@Override
	public void delete(Integer k) throws Exception {
		pm.delete(k);
		System.out.println( k +" Product Deleted...");			
	}

	@Override
	public Product select(Integer k) throws Exception {	
		return pm.select(k);
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		return pm.selectall();
		
	}

}
