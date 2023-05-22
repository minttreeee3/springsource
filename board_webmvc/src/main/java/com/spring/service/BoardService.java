package com.spring.service;

import java.util.List;

import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;

public interface BoardService {
	//전체 리스트 가져오기
	public List<BoardDTO> getList(Criteria cri);
	//글 등록
	public boolean insert(BoardDTO dto);
	//글 하나 조회
	public BoardDTO read(int bno);
	//글 수정
	public boolean modify(BoardDTO dto);
	//글 삭제
	public boolean delete(int bno);
	//전체 게시물 개수
	public int getTotalCnt(Criteria cri);

}
