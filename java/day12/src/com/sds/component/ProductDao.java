package com.sds.component;

import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.vo.Product;
import com.sds.vo.User;

public class ProductDao extends Dao<Integer, Product> {

	@Override
	public void insert(Product v) throws Exception {
		if (v.getId() == 02) {
			throw new Exception(" E0001");
		}
		System.out.println(v + " Inserted ..");

	}

	@Override
	public void delete(Integer k) throws Exception {
		// TODO Auto-generated method stub
		if (k == 02) {
			throw new Exception(" E0002");
		}
		System.out.println(k + " Deleted ..");

	}

	@Override
	public void update(Product v) throws Exception {
		// TODO Auto-generated method stub
		if (v.getId() == 02) {
			throw new Exception(" E0003");
		}
		System.out.println(v + " Updated ..");

	}

	@Override
	public Product select(Integer k) throws Exception {
		Product u = new Product(01, "T", 3000);
		return u;
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product(01, "T", 3000));
		list.add(new Product(02, "pants", 4500));
		list.add(new Product(03, "shirts", 5000));
		list.add(new Product(04, "shoes", 8000));
		list.add(new Product(05, "cap", 2000));
		return list;
	}

}
