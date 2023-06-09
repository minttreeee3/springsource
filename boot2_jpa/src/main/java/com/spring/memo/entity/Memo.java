package com.spring.memo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // 클래스를 엔티티로 선언
@SequenceGenerator(name="mem_seq_gen", sequenceName="mem_seq", allocationSize=1)
@Builder
// @Table(name="memos") // 클래스명으로 테이블 생성할 때 옵션 지정
@AllArgsConstructor @NoArgsConstructor 
@Setter @Getter @ToString
public class Memo {
	
	// name : 임의로 설정하는 이름(필수), sequenceName : mem_seq.nextval 할때 사용하는 이름, allocationSize : 증가할 숫자 (1씩 증가) 
	//@SequenceGenerator(name="mem_seq_gen", sequenceName="mem_seq", allocationSize=1)
	
	// GenerationType : 1)AUTO : JPA구현체가 자동으로 구현, 2)IDENTITY: 기본키 생성을 데이터베이스에 위임, 
	//					3)SEQUENCE: @SequenceGenerator등록후에 사용, 4)TABLE: 키 생성용 테이블 @TableGenerator등록후 사용 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mem_seq_gen")
	@Id // pk생성
	private long mno;
	
	//@CreationTimestamp // insert시 시간 자동저장
	@Column(length = 200, nullable = false) 
	private String memoText;

}
