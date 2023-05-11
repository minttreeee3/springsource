package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonDTO;
import com.spring.service.PersonSrevice;

public class PersonMain {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		PersonSrevice service = (PersonSrevice) ctx.getBean("person");
		
		//삽입
//		PersonDTO insertPerson = new PersonDTO("hong123", "홍길동");
//		System.out.println(service.insertPerson(insertPerson)? "성공":"실패");
		
		List<PersonDTO> list = service.getRows();
		for (PersonDTO personDTO : list) {
			System.out.println(personDTO);
		}
		
		//
		System.out.println(service.updatePerson(new PersonDTO("kang123", "강동주")));
		
		//
		System.out.println(service.deletePerson("kim123")? "성공":"실패");
		
		
		
	}

}
