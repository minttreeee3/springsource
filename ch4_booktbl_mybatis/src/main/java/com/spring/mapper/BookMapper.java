package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BookDTO;

// 파라메터는 하나로 넘기는게 가장 편함
// 여러개로 넘길때는 반드시 @Param() 이라는 어노테이션을 사용해야함 
public interface BookMapper {
	
	public int insert(BookDTO dto);
	public int update(@Param("price") int price, @Param("code") int code);
	public int delete(int code);
	public BookDTO getRow(int code);
	public List<BookDTO> getRows();

}
