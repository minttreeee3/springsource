package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Criteria {
	private int pageNum; //페이지번호
	private int amount; //한 페이지당 게시물 수
	
	private String type; //검색조건
	private String keyword; //검색어 

	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
