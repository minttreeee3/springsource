<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<!-- form 안에 file요소가 존재 시 enctype을 반드시 써줘야함  -->
	<form action="" method="post" enctype="multipart/form-data">
		<div>
			<label for="name">name</label>
			<input type="text" name="name" id="name" />
		</div>
		<div>
			<label for="file">file</label>
									<!-- multiple: 파일 여러개 첨부 가능 => DTO에서 배열로 처리해야함,
											첨부가능한 파일 확장자명을 제한할 수 있음 -->
			<input type="file" name="file" id="file" multiple accept="image/*, .txt"/> 
		</div>
		<div>
			<button type="submit">submit</button>
		</div>
	</form>
</body>
</html>