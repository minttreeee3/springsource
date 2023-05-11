package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.spring.domain.PersonDTO;

public interface PersonMapper {
		// interface + 어노테이션 (sql짧을때는 어노테이션에 한번에 써버림)
//		@Insert("insert into person(id,name) values(#{id},#{name})")
//		public int insert(PersonDTO insert);
		
		// interface + XML (sql을 XML에 따로)
		// 메소드명과 XML에 작성한 id명이 일치해야함
		public int insertPerson(PersonDTO insert);
		public int updatePerson(PersonDTO update);
		public int deletePerson(String id);
		public PersonDTO selectOne(String id);
		public List<PersonDTO> selectAll();
		
		
		
}
