package com.example.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.naver.service.WishListService;
import com.example.restaurant.wishlist.dto.WishListDTO;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/restaurant")
@RestController
@Slf4j
public class ApiController {
	
	@Autowired
	private WishListService wishListService;
	
	@GetMapping("/search")
	public WishListDTO search(String query) {
		log.info("검색 요청"+query);
		return wishListService.search(query);
	}
	
	@PostMapping("")	// /api/restaurant + post 
	public WishListDTO add(@RequestBody WishListDTO wishListDTO) { // json으로 넘어오는걸 받으려면 어노테이션 필요
		
		log.info("wish 추가");
		return wishListService.add(wishListDTO);
	}

}
