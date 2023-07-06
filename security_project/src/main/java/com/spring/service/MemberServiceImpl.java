package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.SpUserAuthorityDTO;
import com.spring.domain.SpUserDTO;
import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder encoder;	// security-context.xml에서 객체생성한걸 불러오는거임 
	
	
	@Transactional
	@Override
	public boolean register(SpUserDTO dto) {
		// 비밀번호 암호화
		dto.setPassword(encoder.encode(dto.getPassword()));
		
		// 회원가입 
		boolean result = mapper.register(dto) == 1; 
		
		// 회원권한
		mapper.registerAuth(new SpUserAuthorityDTO(dto.getUserid(), "ROLE_USER"));
		// mapper.registerAuth(new SpUserAuthorityDTO(dto.getUserid(), "ROLE_ADMIN")); //관리자계정만들땐 이것까지
		
		return result;
		
	}

}
