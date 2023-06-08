package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImple implements MemberService {

	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
	
	
	@Override
	public AuthDTO login(LoginDTO loginDTO) {
		// 1234(사용자가 쓴 암호) => bPasswordEncoder.encode(1234) ==> 암호화
		// matches(암호화하기 전 코드, 암호화된 코드)
		// matches(1234, db에 암호화된 문자)
		
		// 암호화된 비번
		String encodePass = mapper.getPass(loginDTO.getUserid());
		
		// 비밀번호가 일치하는가?
		// db에서 암호화된 비번 가져오기
		if(bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
			return mapper.login(loginDTO.getUserid());			
		} else {
			return null;
		}		
	}


	@Override
	public boolean insert(MemberDTO memberDTO) {	
		// 비밀번호 암호화 : encode(암호화할 원본 코드)
		//				matches(암호화하기 전, 암호화 코드) 
		memberDTO.setPassword(bPasswordEncoder.encode(memberDTO.getPassword()));
		
		return mapper.insert(memberDTO)==1? true:false;
	}


	@Override
	public boolean dupId(String userid) {
		return mapper.dupId(userid)==0? true:false;
	}


	@Override
	public boolean remove(LoginDTO loginDTO) {
		
		// 암호화된 비번
		String encodePass = mapper.getPass(loginDTO.getUserid());
				
		// 비밀번호가 일치하는가?
		if(bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
			return mapper.leave(loginDTO.getUserid())==1? true:false;			
		} 
		
		return false;
	}


	@Override
	public boolean update(ChangeDTO changeDTO) {
		// 현재 비밀번호 확인
		String encodePass = mapper.getPass(changeDTO.getUserid());
				
		// 비밀번호가 일치하는가?
		if(bPasswordEncoder.matches(changeDTO.getCurrentPassword(), encodePass)) {
			
			//변경 비밀번호 암호화
			changeDTO.setNewPassword(bPasswordEncoder.encode(changeDTO.getNewPassword()));
			
			return mapper.update(changeDTO)==1? true:false;			
		} 
		return false;
	}



}
