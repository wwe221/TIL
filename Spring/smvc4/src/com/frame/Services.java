package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface Services<K,V> {
	@Transactional
	public void insert(V v) throws Exception;
	@Transactional
	public void update(V v) throws Exception;
	@Transactional
	public void delete(K k) throws Exception;
	public V select(K k) throws Exception;
	public ArrayList<V> select() throws Exception;
}
