<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
	<div>
		<label for="num1">num1</label>
											<!-- value담아두면 입력한 값 보내고나서도 안없어지고 폼에 남아있음 -->
		<input type="text" name="num1" id="num1" value="${addDTO.num1}"/>  
	</div>
	<div>
		<label for="num2">num2</label>
		<input type="text" name="num2" id="num2" value="${addDTO.num2}"/>
	</div>
	<div>
		<button type="submit">더하기</button>
	</div>
	<input type="hidden" name="page" value="3" />
</form>
</body>
</html>