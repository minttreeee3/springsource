package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookDTO;
import com.spring.domain.SearchDTO;
import com.spring.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/book")
@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	
//	// http://localhost:8080/book/insert + GET 
//	// => /product/insert.jsp 보여주기 
//	@GetMapping("/insert")
//	public String insertForm() {
//		log.info("도서정보 추가 폼 요청");		
//		return "/product/insert";
//	}
//	
//	// http://localhost:8080/book/insert + POST
//	@PostMapping("/insert")
//	public String insertPost(BookDTO dto) {
//		log.info("도서 정보 추가");
//		
//		//입력값 가져오기 - HttpServletRequest, 변수, ~DTO
//		//서비스 작업
//		try {
//			boolean insertFlag = service.insert(dto);
//			if(insertFlag) {
//				// 입력 성공시 목록 보여주기
//				return "redirect:/book/list";
//			} else {
//				// 입력 실패시 insert.jsp 보여주기
//				return "/product/insert";
//			}
//			
//		} catch (Exception e) {
//			System.out.println("오류");
//			return "/product/insert";
//		}
//				
//	}
//	
//	
//	
//	// http://localhost:8080/book/list + GET => list.jsp 보여주기 
//	@GetMapping("/list")
//	public String list(Model model) {
//		log.info("도서 리스트 요청");
//		
//		// 사용자가 작성한 값 가져오기
//		
//		// 서비스 작업
//		List<BookDTO> list = service.getList();
//		
//		// list에 담긴 정보를 list.jsp에서 보여주고 싶다면?
//		model.addAttribute("list", list); 
//		
//		return "/product/list";
//	}
//	
//	
//	
//	// http://localhost:8080/book/read?code=1001 + GET 
//	@GetMapping("/read")
//	public String readGet(int code, Model model) {
//		log.info("read 요청 "+code);
//		
//		BookDTO dto = service.get(code);
//		model.addAttribute("dto",dto);
//		
//		return "/product/read";
//	}
	

	// 주소를 맞춘다면 (/book 폴더안의 파일들을 보여주기)
	@GetMapping("/insert")
	public void insertForm() {
		log.info("도서정보 추가 폼 요청");	
	}
	
	// 경우의 수가 나뉘는 경우엔 void로 갈 수 없음
	// http://localhost:8080/book/insert + POST
	@PostMapping("/insert")
	public String insertPost(BookDTO dto) {
		log.info("도서 정보 추가");
		
		//입력값 가져오기 - HttpServletRequest, 변수, ~DTO
		//서비스 작업
		try {
			boolean insertFlag = service.insert(dto);
			if(insertFlag) {
				// 입력 성공시 목록 보여주기
				return "redirect:/book/list";
			} else {
				// 입력 실패시 insert.jsp 보여주기
				return "/book/insert";
			}
			
		} catch (Exception e) {
			System.out.println("오류");
			return "/book/insert";
		}
				
	}
	
	
	
	// http://localhost:8080/book/list + GET => list.jsp 보여주기 
	@GetMapping("/list")
	public void list(Model model) {
		log.info("도서 리스트 요청");
		
		// 사용자가 작성한 값 가져오기
		
		// 서비스 작업
		List<BookDTO> list = service.getList();
		
		// list에 담긴 정보를 list.jsp에서 보여주고 싶다면?
		model.addAttribute("list", list); 
		
		
	}
	
	
	
	// http://localhost:8080/book/read?code=1001 + GET   => book/read.jsp 
	// http://localhost:8080/book/modify?code=1001  =>  book/modify.jsp
	@GetMapping({"/read", "/modify"})
	public void readGet(int code, Model model) {
		log.info("read 요청 "+code);
		
		BookDTO dto = service.get(code);
		model.addAttribute("dto",dto);
		
		//ViewResolver 동작  http://localhost:8080/book/read ==> /WEB-INF/views/book/read.jsp
		//					http://localhost:8080/book/modify ==> /WEB-INF/views/book/modify.jsp
		// 같은 경로일때 궅이 나눠서 만들 필요가 없음
		
	}
	
	
//	@GetMapping("/modify")
//	public void modifyGet(int code, Model model) {
//		log.info("read 요청 "+code);
//		
//		BookDTO dto = service.get(code);
//		model.addAttribute("dto",dto);
//		
//	}
	
	
	// http://localhost:8080/book/modify + POST
	@PostMapping("/modify")
	public String updatePost(BookDTO dto, RedirectAttributes rttr) {
		log.info("도서정보 수정"+dto);
		
		service.update(dto);
		
		rttr.addAttribute("code", dto.getCode()); // 이거 안하면 500에러남 code를 안딸려보내서...
		
		//   /book/read
		return "redirect:/book/read";
	}
	
	
	
	@GetMapping("/remove")
	public String removeGet(int code) {
		log.info("도서 정보 삭제"+code);
		
		// 삭제 후 목록 보여주기
		service.delete(code);
		
		return "redirect:/book/list";
	}
	
	
//	변수 사용 방식 
//	@GetMapping("/search")
//	public String searchGet(String criteria, String keyword, Model model) { 
//		log.info("도서 정보 검색"+criteria+", "+keyword);
//		
//		List<BookDTO> list = service.getSearchList(criteria, keyword);
//		
//		model.addAttribute("list", list);
//		
//		return "/book/list";
//	}
	@GetMapping("/search")
	public String searchGet(SearchDTO search, Model model) { 
		log.info("도서 정보 검색"+search);
		
		List<BookDTO> list = service.getSearchList(search.getCriteria(), search.getKeyword());
		
		model.addAttribute("list", list);
		model.addAttribute("searchDTO", search);
		
		return "/book/list";
	}
	

}
