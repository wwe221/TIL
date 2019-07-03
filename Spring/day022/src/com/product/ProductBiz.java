package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.frame.Dao;
@Component("pbiz")
public class ProductBiz implements Biz<Integer, Product> {
	@Resource(name="pDao")
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
