package com.frame;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@Aspect
public class Logadvice {
	public void printlog() {
		Date d = new Date();
		System.out.println(d + "[공통로그] 비즈니스 로직 수행...");
	}
	@Before("execution(* com..Services+.insert(..)) || execution(* com..Service+.update(..))")	
	public void beforelog(JoinPoint jp) {
		String method = jp.getSignature().getName(); // 함수 이름
		Object[] args = jp.getArgs(); // 입력된 매개변수
		System.out.println(method + ":" + args[0]);
		System.out.println("Insert/Update 요청");
	}
	@AfterReturning(
		pointcut="execution(* com..Services+.select(..))",
		returning ="returnobj"
	)
	public void afterlog(JoinPoint jp, Object returnobj) {
		String method = jp.getSignature().getName();
		System.out.println("["+method+"] 수행 결과");
		System.out.println(returnobj);
	}
	@AfterThrowing(
		pointcut="execution(* com..Services+.select(..))",
		throwing ="ex"
	)
	public void exlog(JoinPoint jp , Exception ex) {
		Date d = new Date();
		String method = jp.getSignature().getName();
		System.out.println(method + "[예외발생]"+d);
		System.out.println(ex.getMessage());
	}
	@Around("execution(* com..Services+.*(..))")
	public Object aroundlog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		Date d = new Date();
		System.out.println(d + " Before Action ...");
		Object obj = pjp.proceed();
		d = new Date();
		System.out.println(d + " After Action ...");
		sw.stop();
		System.out.println("메소드 수행 시간 :" +sw.getTotalTimeMillis()+"(ms)초");
		return obj;
	}

}
