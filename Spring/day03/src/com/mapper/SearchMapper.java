package com.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.vo.User;

public interface SearchMapper<K,V> {
	public ArrayList<V> search(K k);
}



