package com.spring.mapper;

import com.spring.domain.SpUserDTO;
import com.spring.domain.SpUserAuthorityDTO;

public interface MemberMapper {
	public int register(SpUserDTO dto);
	public int registerAuth(SpUserAuthorityDTO dto);
	
	public SpUserDTO read(String userid);

}
