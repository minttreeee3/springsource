package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mapper.SampleMapper1;
import com.spring.mapper.SampleMapper2;


@Service("sample")
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper1 mapper1;
	
	@Autowired
	private SampleMapper2 mapper2;
	
	
	@Transactional // 하나의 트랜잭션으로 처리하겠다 (=한번에 처리 =하나가 오류나면 전부 실행x) 
	@Override
	public void addData(String data) {		
		
		mapper1.insertCol1(data);
		mapper2.insertCol1(data);

	}

}
