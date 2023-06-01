package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // @Component의 자식 
@RequestMapping("/sample") // BasicController는 http://localhost:8080/sample/** 요청에 응답하는 컨트롤러다. 라는 뜻 
							// RequestMapping은 option => 안붙이면 그냥 http://localhost:8080로 시작함
public class BasicController {
	//컨트롤러 안에 일반 메소드 작성 가능
	//일반 메소드는 @RequestMapping 어노테이션을 안붙이면 됨
	
	@RequestMapping("/basic")
	public void basic() {
		log.info("basic........요청");
		
		// 컨트롤러 실행후(없을수도 있음) ViewResolver가 실행됨
		// 리턴이 있다면 /WEB-INF/views/리턴값.jsp
		
		// 리턴이 없다면 주소줄 문자열/WEB-INF/views/sample/basic.jsp으로 만들어서 결과를 리턴함
		// [/WEB-INF/views/sample/basic.jsp]
		
		
	}
}
