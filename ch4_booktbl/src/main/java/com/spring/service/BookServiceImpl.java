package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookDTO;
import com.spring.persistence.BookDAO;


@Service("bookService")  //  new BookServiceImpl() 대신 쓰게되는것
public class BookServiceImpl implements BookService {
	
	@Autowired  // 메소드 안에 넣는 인자 new BookDAO() 대신에
	private BookDAO bookDAO;
	
//	public BookServiceImpl(BookDAO bookDAO) {
//		this.bookDAO = bookDAO;
//	}
	

	@Override
	public boolean insertBook(BookDTO insertDto) {
		return bookDAO.insert(insertDto);
	}

	@Override
	public boolean updateBook(BookDTO updateDto) {
		return bookDAO.update(updateDto);
	}

	@Override
	public boolean deleteBook(int code) {
		return bookDAO.delete(code);
	}

	@Override
	public BookDTO getBook(int code) {
		return bookDAO.getRow(code);
	}

	@Override
	public List<BookDTO> getBookList() {
		return bookDAO.getRows();
	}

}
