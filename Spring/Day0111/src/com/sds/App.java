package com.sds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext factory
		= new GenericXmlApplicationContext("myspring.xml");
		System.out.println("test");
		TV stv = (TV)factory.getBean("stv");
		stv.turnOn();
		TV stv2 = (TV)factory.getBean("stv");
		stv2.turnOn();
		TV ltv = (TV)factory.getBean("ltv");
		ltv.turnOn();
		TV ltv2 = (TV)factory.getBean("ltv");
		ltv2.turnOn();
		System.out.println(stv);
		if(ltv==ltv2)
			System.out.println("OK");
		stv.up();
		ltv.up();
		System.out.println(ltv);
	}

}
