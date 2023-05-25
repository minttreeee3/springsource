package com.spring.service;

import java.util.List;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.domain.ReplyPageDTO;

public interface ReplyService {
	public ReplyDTO read(int rno);
	public boolean insert(ReplyDTO dto);
	//댓글 목록만 처리
//	public List<ReplyDTO> listAll(Criteria cri, int bno);
	//댓글 총 수 & 댓글 목록을 한번에 처리
	public ReplyPageDTO listAll(Criteria cri, int bno);
	public boolean update(ReplyDTO dto);
	public boolean delete(int rno);
}
