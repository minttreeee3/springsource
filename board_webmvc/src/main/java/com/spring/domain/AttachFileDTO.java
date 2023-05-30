package com.spring.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class AttachFileDTO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	private int bno;
	

}
