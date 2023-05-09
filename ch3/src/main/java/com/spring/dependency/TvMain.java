package com.spring.dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {
	
	String str = "String";  // == new와 같은 역할  -> 이거안하면 널포인트익셉션 나서 
	
	public static void main(String[] args) {
		

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		// @Component로 생성시 id는 클래스명을 사용함(앞자리는 소문자) 
		// TV tv = (TV) ctx.getBean("samsungTV");
		
		// id를 사용하려면 @Component("id")를 설정함 
		TV tv = (TV) ctx.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		

	}
	


}
