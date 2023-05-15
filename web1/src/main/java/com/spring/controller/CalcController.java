package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.domain.AddDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CalcController {
	
	@GetMapping("/add")
	public void addForm() {
		log.info("add 요청");
	}
	
	
	// 사용자 입력값 가져오기
	// 1) HttpServletRequest 사용하기
	// 2) 변수 사용 : 변수명은 폼 태그의 name과 일치시키기 / 폼태그와 일치하지 않을때는 @RequestParam을 사용 
	// 3) 바인딩 객체 (dto) 사용 
	
	
	
//	@PostMapping("/add")
//	public void addPost(int num1, int num2) {
//		log.info("add post 요청");
//		log.info("num1 "+num1);
//		log.info("num2 "+num2);
//		log.info("result = "+(num1+num2));
//	}
	
//	@PostMapping("/add")
//	public void addPost(AddDTO dto) {
//		log.info("add post 요청");
//		log.info("num1 "+dto.getNum1());
//		log.info("num2 "+dto.getNum2());
//		log.info("result = "+(dto.getNum1()+dto.getNum2()));
//	}
	
	
	@PostMapping("/add")
	public String addPost(AddDTO dto, @ModelAttribute("page") String page, Model model) {
		log.info("add post 요청");
		log.info("num1 "+dto.getNum1());
		log.info("num2 "+dto.getNum2());
		log.info("page "+page);
		
		int result = dto.getNum1()+dto.getNum2();		
		log.info("result = "+result); 
		// ==> result 값을 result.jsp에서 사용하고 싶다면? 
		// ==> 스프링워크의 Model객체 이용  == request.setAttribute()와 같은 역할 
		 model.addAttribute("result", result);  // ==>필요한곳에서 $로 불러서 씀
		// model.addAttribute("page", page);
		
		return "result"; //   /WEB-INF/views/result.jsp
	}
	
	
	
	
	
	
	

}
