package com.spring.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

/* java.util.Collection interface
 * - java.util.List interface (자식들) 
 * 		ㄴ java.util.ArrayList
 * 		ㄴ java.util.LinkedList
 * 
 * - java.util.Set interface
 * 		ㄴ java.util.HashSet 
 * 
 * - ? extends GrantdAuthority : GrantedAuthority 와 자손들만 가능 
 * 
 * ==> List<GrantdAuthority>, Set<GrantdAuthority> 여야 함 
 * 
 * ==> dto.getAuthorities() ==> List<SpUserAuthorityDTO> ==> SpUserAuthorityDTO를 GrantdAuthority객체로 생성 


*/

@Getter
public class CustomUser extends User {
	
	private SpUserDTO dto;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(SpUserDTO dto) {
		super(dto.getUserid(), dto.getPassword(), 
			dto.getAuthorities().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList()));
		
		this.dto = dto;
	}


}
