package com.app;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Search;
import com.frame.Services;
import com.vo.Product;
import com.vo.User;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started");

		Services<String, User> uu= (Services<String, User>) factory.getBean("ubiz");
		Services<Integer, Product> pp = (Services<Integer, Product>) factory.getBean("pbiz");
		User user = new User("id8", "pwd01", "ÀÌ·²¼÷");		
		Search<String,User> search=(Search<String , User>) factory.getBean("ubiz");
//		Product p = new Product("Pizza", 20000, "pizza.jpg");
//		Product p2 = new Product("Chicken", 20000, "chick.jpg");
		ArrayList<User> list =null;
		try {
			//uu.insert(user);			
			//uu.update(user);
			//System.out.println(uu.select());
//			pp.insert(p2);
			list = search.search("ÀÌ");
			System.out.println(list);
			System.out.println("Inserted Ok From app.");

		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			User user = Service.select("id01");
//			//Service.insert(new User("id","asdf","asdf"));
//			
//		} catch (Exception e) {			
//			e.printStackTrace();
//		}
		factory.close();
	}

}
