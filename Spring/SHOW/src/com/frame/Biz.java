package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.vo.User;

public interface Biz<K,V> {
	@Transactional
	public void insert(V v) throws Exception;
	@Transactional
	public void update(V v) throws Exception;
	@Transactional
	public void delete(K k) throws Exception;
	public V select(K k) throws Exception;
	public ArrayList<V> select() throws Exception;
	public ArrayList<V> select2(int cate) throws Exception;
}
