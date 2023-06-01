package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	//@RequestMapping(value="/read", method=RequestMethod.GET)
	@GetMapping("/read")
	public void readGet() {
		log.info("read...");
		
	}
	
	//@RequestMapping(value="/register", method=RequestMethod.GET)
	@GetMapping("/register")
	public void registerGet() {
		log.info("register...");
		
	}
	
	
	// BoardDTO 
	// read이동 
//	@PostMapping("/register")
//	public String registerPost(BoardDTO dto, RedirectAttributes rttr) {
//		log.info("register요청" +dto);
//		
//		// BoardDTO 값이 유지가 되려면 (read.jsp에서 $로 불러서 쓰려면) forward로 움직여야함 (redirect쓰면 유지가 안됨)
//		
//		// BoardDTO 객체에 담긴 값을 read.jsp에서 사용하고 싶다면?
//		// RedirectAttributes ==> 일회성으로 데이터를 전달 (단, 객체상태로 값 전달은 불가)
//		
//		// .addAttribute ==> 주소줄에 정보가 따라가게됨
//		rttr.addAttribute("name", dto.getName());
//		rttr.addAttribute("password", dto.getPassword());
//		rttr.addAttribute("title", dto.getTitle());
//		rttr.addAttribute("content", dto.getContent());
//		
//		rttr.addFlashAttribute("boardDTO", dto);
//		
//		
//		
//		return "redirect:/board/register";
//	}
	
	
	// @ModelAttribute("dto") : 괄호는 생략가능 
	// 							Model 객체 대신 사용, 도메인 객체에 담을 때 이름 지정 기능
	// registerPost(BoardDTO dto) : jsp페이지에서 값을 가져올 때 ${boardDTO.name}
	// registerPost(@ModelAttribute("dto") BoardDTO dto) : jsp페이지에서 값을 가져올 때 ${dto.name}
	@PostMapping("/register")
	public void registerPost(@ModelAttribute("dto") BoardDTO dto, RedirectAttributes rttr) {
		log.info("register요청" +dto);
		
		// BoardDTO 값이 유지가 되려면 (read.jsp에서 $로 불러서 쓰려면) forward로 움직여야함 (redirect쓰면 유지가 안됨)
		
		
	}
	
	
	
	
	
	
	//@RequestMapping(value="/modify", method=RequestMethod.GET)
	@GetMapping("/modify")
	public void modifyGet() {
		log.info("modify...");
		
	}
	
	//@RequestMapping(value="/remove", method=RequestMethod.GET)
	@GetMapping("/remove")
	public void removeGet() {
		log.info("remove...");
		
	}

}
