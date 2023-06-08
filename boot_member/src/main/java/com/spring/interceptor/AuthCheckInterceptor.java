package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.spring.domain.AuthDTO;

public class AuthCheckInterceptor implements HandlerInterceptor {

	// 로그인 전에는 비번 변경 페이지로 가지못하도록
	// http://localhost:8080/member/changePwd ==> 인터셉터가 요청을 가로채도록
	// session 정보가 있는지 확인해서
	// true : 원래 담당 컨트롤러 요청 넘기기
	// false : 로그인 페이지로 이동
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		AuthDTO authDTO = (AuthDTO) session.getAttribute("authDTO");
		
		if(authDTO!=null) {
			return true;
		}
		
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
	}
	
	
	// postHandle() : 컨트롤러 작업 끝난 후에 추가 작업이 필요하다면
	
}
