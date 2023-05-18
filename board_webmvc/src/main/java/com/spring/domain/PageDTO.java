package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 페이지 나누기 정보객체
// 요청된 페이지 : pageNum
// 한 페이지당 목록 수 : amount
// 시작 페이지, 끝나는 페이지 => 1		5		10
//						11		15		20
// 전체 게시물 35개, 한 페이지당 10개씩 보여주기 => 하단에 1 2 3 4 

@Getter @Setter @ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int total;
	
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.total = total;
		this.cri = cri;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total / 1.0) / cri.getAmount()));
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		// startPage가 1보다 클때만 이전버튼 누를수있게, endPage가 마지막보다 작을때만 다음버튼 누를수있게 
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

}
