package com.example.myapp.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAspect {

	@Before("execution(* com.example.myapp..BoardService.*(..))")
	public void beforeLog(JoinPoint joinPoint) {
		System.out.println("==================");
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		log.info("[[[AOP-before Log]]]-{}", methodName);
	}
}
