package com.example.springrest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Before("execution(public * com.example.springrest.DemoController.home())")
	public void BeforeLogger()
	{
		System.out.println("------------------------Before Executed");
	}
	
	@After("execution(public * com.example.springrest.DemoController.home())")
	public void AfterLogger()
	{
		System.out.println("------------------------After Executed");
	}
}
