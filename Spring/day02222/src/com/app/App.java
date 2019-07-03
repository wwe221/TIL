package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Services;
import com.vo.Product;
import com.vo.User;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started");

		Services<String, User> Service = (Services<String, User>) factory.getBean("ubiz");
		Services<Integer, Product> pService = (Services<Integer, Product>) factory.getBean("pbiz");
		User user = new User("id01", "pwd01", "ÀÌ¸»ÀÚ");
		try {
			Service.insert(user);
			Service.update(user);
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
