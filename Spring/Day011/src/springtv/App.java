package springtv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		//Spring Container 를 만드는 작업쓰
		//myspring.xml 에서 정의 되어 있는 객체들이 먼저 만들어 진다.
		
		//먼저 만들어진 객체들을 reference 하기 때문에 
		//IoC 라고 한다.
		System.out.println("Spring Started");
		
		TV stv = (TV)factory.getBean("sstv");
		stv.turnOn();
		stv.volumeUp(10);
		System.out.println(stv);
		
		TV stv2 = (TV)factory.getBean("ltv");
		stv2.turnOn();
		stv2.volumeUp(10);
		System.out.println(stv2);

		TV stv3 = (TV)factory.getBean("ltv");
		stv2.turnOn();
		stv2.volumeUp(10);
		System.out.println(stv2);
		
		
		factory.close();
	}

}
