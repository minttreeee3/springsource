package com.spring.memo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Member {
	
	@Id
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length=50)
	private String name;
	
	@Column(unique = true)	
	private String email;
	
	@Column(nullable = false, length=50)
	private String password;
	
	@Column(nullable = false, length=100)
	private String address;

}
