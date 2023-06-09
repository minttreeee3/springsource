package com.spring.service;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;

public interface MemberService {
	
	public AuthDTO login(LoginDTO loginDTO);
	public boolean insert(MemberDTO memberDTO);
	//중복 아이디 체크
	public boolean dupId(String userid);
	//회원탈퇴
	public boolean remove(LoginDTO loginDTO);
	//비번변경
	public boolean update(ChangeDTO changeDTO);

}
