package com.frame;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import com.user.User;

public class Logadvice {
	public void printlog() {
		Date d = new Date();
		System.out.println(d + "[공통로그] 비즈니스 로직 수행...");
	}

	public void beforelog(JoinPoint jp) {
		String method = jp.getSignature().getName(); // 함수 이름
		Object[] args = jp.getArgs(); // 입력된 매개변수
		System.out.println(method + ":" + args[0]);
		System.out.println("[before] 로직 수행");
	}

	public void afterlog(JoinPoint jp, Object returnobj) {
		System.out.println("[after] 로직 수행");
		System.out.println(returnobj);
	}

	public void exlog(JoinPoint jp , Exception ex) {
		Date d = new Date();
		System.out.println(d + "[예외발생]...");
		System.out.println(ex.getMessage());
	}

	public Object aroundlog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		Date d = new Date();
		System.out.println(d + "Before Action ...");
		Object obj = pjp.proceed();
		d = new Date();
		System.out.println(d + "After Action ...");
		sw.stop();
		System.out.println("메소드 수행 시간 :" +sw.getTotalTimeMillis()+"(ms)초");
		return obj;
	}

}
