package com.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory
		= new GenericXmlApplicationContext("myspring.xml");
		Biz b = (Biz)factory.getBean("uBiz");
		Biz c = (Biz)factory.getBean("uBiz2");
		b.register();
		c.register();
	}

}
