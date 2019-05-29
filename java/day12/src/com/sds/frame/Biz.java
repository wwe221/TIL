package com.sds.frame;

import java.util.ArrayList;

import com.sds.vo.User;

public abstract class Biz<K, V> {
	protected Dao<K,V> dao;

	public void checkData(V v) {
		System.out.println("Check Ok..");
	}
	public void transactionStart() {
		System.out.println("Transaction Start...");		
	}
	public void transactionEnd() {
		System.out.println("Transaction End...");		
	}
	

	public abstract void register(V v) throws Exception;

	public abstract void remove(K k) throws Exception;

	public abstract void modify(V v) throws Exception;

	public abstract V get(K k) throws Exception;

	public abstract ArrayList<V> get() throws Exception;

}
