package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class ChangeDTO {
	//changePwd.jsp와 일치시키기
	private String userid;
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	
	public boolean passwordEquals() {
		return newPassword.equals(confirmPassword);
	}

}
