package com.spring.factorial;

import org.springframework.stereotype.Component;

@Component("forc")
public class ForCalc implements Calculator {

	@Override
	public long factorial(long num) {
		// for문으로 factorial구하기
		// 10! = 10*9*8*...*1 
		
		int result = 1;
		
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		
		return result;
	}

}
