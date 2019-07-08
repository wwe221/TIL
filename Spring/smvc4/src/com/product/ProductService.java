package com.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Services;
import com.vo.Product;
@Service("pbiz")
public class ProductService implements Services<Integer, Product> {
	@Autowired
	Dao<Integer,Product> dao;
	@Override
	public void insert(Product v) throws Exception {
		dao.insert(v);

	}

	@Override
	public void update(Product v) throws Exception {
		dao.update(v);

	}

	@Override
	public void delete(Integer k) throws Exception {
		dao.delete(k);

	}

	@Override
	public Product select(Integer k) throws Exception {
	
		return dao.select(k);
	}

	@Override
	public ArrayList<Product> select() throws Exception {
	
		return dao.select();
	}

}
