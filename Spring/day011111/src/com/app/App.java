package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.user.User;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory
		= new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started");
		
		Biz<String, User> biz = 
				(Biz<String, User>) factory.getBean("ubiz");
		
		
		User user = new User("id01", "pwd01", "ÀÌ¸»ÀÚ");
		try {
			biz.insert(user);
			System.out.println("Inserted Ok From app.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		factory.close();
	}

}







