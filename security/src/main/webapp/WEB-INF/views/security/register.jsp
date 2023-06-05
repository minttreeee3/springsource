<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	
	<h1>Login</h1>
	
	<!-- 
		spring security 로그인 페이지 규칙
		
		1) post 방식으로, action="/login" 지정
		2) 아이디를 입력 받은 요소의 이름은 반드시 username이어야 함
		3) 비밀번호를 입력 받는 요소의 이름은 반드시 password이어야 함 
		4) post 방식으로 가는 모든 폼 안에는 csrf토큰 값이 포함되어있어야 함
		
	 -->
	
<main class="form-signin w-100 m-auto">
  	<form method="post" action="">
      <h1 class="h3 mb-3 fw-normal">회원가입</h1>
    <div class="form-floating">
      <label for="floatingInput">UserId</label>
      <input type="text" class="form-control" id="userid" placeholder="userid" name="userid">
    </div>
    <div class="form-floating">
      <label for="floatingPassword">Password</label>
      <input type="password" class="form-control" id="password" placeholder="Password" name="password">
    </div>
    <div class="form-floating">
      <label for="floatingPassword">Email</label>
      <input type="email" class="form-control" id="email" placeholder="email" name="email">
    </div>

    
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button class="w-100 btn btn-lg btn-primary" type="submit">회원가입</button>
     
  </form>
</main>
	
	
<%@ include file="../include/footer.jsp" %>





