package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.SampleDTO;

@RestController
public class RestControllerTest {
	
	// 일반 컨트롤러에서 return값은 view이름
	// Rest 컨트롤러에서 return값은 데이터 그대로 
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	// produces : 리턴값을 json형태로 보낼것이다
	// 자바 객체를 ==> json 형태로 변경해주는 라이브러리가 필요함 
	@GetMapping(value="/send", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleDTO sendDto() {
		return new SampleDTO("1234", "홍", "길동");
	}
	
	@GetMapping(value="/sends", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SampleDTO> sendList() {
		
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		list.add(new SampleDTO("1234", "홍", "길동"));
		list.add(new SampleDTO("1235", "박", "길동"));
		list.add(new SampleDTO("1236", "김", "길동"));
		list.add(new SampleDTO("1237", "최", "길동"));
		
		return list;
	}
	
	
	// ResponseEntity : 상태코드(Http의 상태코드-404,500같은거...)와 데이터를 같이 전송
	@GetMapping(value="/check", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleDTO> check(double height, double weight) {
		
		SampleDTO dto = new SampleDTO("1234", ""+height, ""+weight);
		
		ResponseEntity<SampleDTO> entity = null;
		
		if (height < 160) {
			entity = new ResponseEntity<SampleDTO>(dto, HttpStatus.BAD_REQUEST);
		} else {
			entity = new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
		}
		return entity;
	}

}
