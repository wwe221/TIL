package com.app;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Services;
import com.vo.Product;
import com.vo.User;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started");

		Services<String, User> uu= (Services<String, User>) factory.getBean("ubiz");
		Services<Integer, Product> pp = (Services<Integer, Product>) factory.getBean("pbiz");
		User user = new User("ident", "pass", "³Ã¸ð¹Ð");
//		Product p = new Product("Pizza", 20000, "pizza.jpg");
//		Product p2 = new Product("Chicken", 20000, "chick.jpg");
		User list =null;
		try {
			//uu.insert(user);			
			//uu.update(user);
			list=uu.select("id058");
			System.out.println(list);
//			pp.insert(p2);
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
