package com.spring.factorial;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 횡단관심사를 처리해줄 클래스
@Component
@Aspect
public class TimeAspect {

	@Around(value = "execution(* com.spring.factorial..*(..))") //factorial패키지 밑의 어떤 메소드라도.라는 뜻의 표현식 
	public Object measure(ProceedingJoinPoint pjp) {
		
		long start = System.nanoTime();
		Object obj = null;
		
		try {
			obj = pjp.proceed(); // 주된관심사를 처리하는 부분 
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			long end = System.nanoTime(); 
			System.out.println("걸린 시간 : "+(end-start));
		} 
		return obj;
	}
}
