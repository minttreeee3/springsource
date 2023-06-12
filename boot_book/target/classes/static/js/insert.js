/**
 * 
 * form이 submit되기 전에 유효성 검증
 * 
 * 1) 내용은 비어있지 않아야 함 (단, description은 비어있어도 됨)
 * 2) 코드는 무조건 4자리 입력되었는지 확인
 * 3) 가격은 숫자로 입력되었는지 확인
 * 
 * 전부 만족한다면 form submit 
 */

 document.querySelector(".btn-success").addEventListener("click", () => location.href = path); 
 														//path는 insert.jsp에서 c:url을 변수에 담은 경로임



 const code = document.getElementById("code");
 const title = document.getElementById("title");
 const writer = document.getElementById("writer");
 const price = document.getElementById("price");
 
 const form = document.querySelector("form");
 
 form.addEventListener("submit", (e) => {
	
	e.preventDefault();
	 
	 if(code.value==="" || code.value.length !== 4 || isNaN(code.value)) {
		 alert("코드를 확인해 주세요");
		 code.select();
		 return; 
	 } else if(title.value === "") {
		 alert("도서명을 확인해 주세요");
		 title.select();
		 return; 
	 } else if(writer.value === "") {
		 alert("저자명을 확인해 주세요");
		 writer.select();
		 return; 
	 } else if(price.value === "" || isNaN(price.value)) {
		 alert("가격을 확인해 주세요");
		 price.select();
		 return; 
	 }
	 
	 form.submit();
	 	 
 });
 
 
 

 
 
 
 
 
 