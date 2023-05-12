package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // http://localhost:8080 요청 응답 컨트롤러 
@RequestMapping("/member")  // http://localhost:8080/member 
public class MemberController {
	
	//GET + POST 둘다 응답 
	//@RequestMapping("/login")  // http://localhost:8080/member/login
	
	
	// 사용자 입력값 가져오기
	// 1) HttpServletRequest 사용하기
	// 2) 변수 사용 : 변수명은 폼 태그의 name과 일치시키기
	// 3) 바인딩 객체 사용 
	
	
	
	//@RequestMapping(value="/login", method=RequestMethod.GET)
	@GetMapping("/login")
	public void loginGet(HttpServletRequest req) {
		log.info("login...");
		log.info("method "+req.getMethod());
		//return "/member/login"; // 리턴이 있다면 /WEB-INF/views/login.jsp
		
		// 웹 주소와 views밑의 파일 주소가 같다면 리턴없이 void로 가능, 주소가 다르다면 return으로 주소 적어주면 됨 
	}
		
	//@RequestMapping(value="/login", method=RequestMethod.POST)
//	@PostMapping("/login")
//	public void loginPost(HttpServletRequest req) {
//		log.info("login...");
//		log.info("method "+req.getMethod());		
//		// 사용자 입력값 id, password
//		System.out.println("id "+req.getParameter("id"));
//		System.out.println("password "+req.getParameter("password"));
//	}
	
	@PostMapping("/login")
	public void loginPost(@RequestParam("userid") String id, String password) {
		log.info("login post...");
		// 사용자 입력값 id, password
		System.out.println("id "+id);
		System.out.println("password "+password);
	}
	
	
	
	
	
	
	//@RequestMapping("/register")  // http://localhost:8080/member/register
	@GetMapping("/register")
	public void registerGet() {
		log.info("register...");
		//return "/member/register"; // 리턴이 있다면 /WEB-INF/views/register.jsp
	}

}
