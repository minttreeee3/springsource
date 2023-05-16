/**
 * 폼의 모든 요소가 비어있는지 확인
 * 하나라도 비어있으면 못가게 막아야함 
 * 
 */

 const form = document.querySelector("form");
 
/* const userid = document.querySelector("#userid");
 const password = document.querySelector("#password");
 const name = document.querySelector("#name");
 const gender = document.querySelector(".form-check-input");
 const email = document.querySelector("#email");
 
 form.addEventListener("submit", (e) => {
	 e.preventDefault();
	 
	 if(userid.value =="") {
		 alert("아이디를 확인해 주세요");
		 userid.select();
		 return;
	 } else if(password.value =="") {
		 alert("비밀번호를 확인해 주세요");
		 password.select();
		 return;
	 } else if(name.value =="") {
		 alert("이름을 확인해 주세요");
		 name.select();
		 return;
	 } else if(gender.value == null) {
		 alert("성별을 선택해 주세요");
		 return;
	 } else if(email.value =="") {
		 alert("이메일을 확인해 주세요");
		 email.select();
		 return;
	 }
	 
	 form.submit();
	 
 });*/
 
 document.querySelector(".btn-success").addEventListener("click", () => location.href = path);
 
 
 form.addEventListener("submit", (e) => {
	 if(!form.checkValidity()) {
		 e.preventDefault();
		 e.stopPropagation();
	 }
	 form.classList.add("was-validated");
 })
 
 
 document.querySelector(".btn-danger").addEventListener("click", () => {
	 // 사용자가 입력한 userid 가져오기
	 const userid = document.querySelector("#userid").value;
	 
	 fetch("dupId.do", {
		 method:"post",
		 body: new URLSearchParams({userid:userid})
	 })
	 .then((response) => response.text())
	 .then((result) => {
		 console.log(result);
	 	if(result.trim() ==="true") {
			 alert("아이디를 사용할 수 있습니다");
		 } else {
			 alert("아이디를 사용할 수 없습니다");
		 }
	 });
	 
 });
 
 
 
 
 