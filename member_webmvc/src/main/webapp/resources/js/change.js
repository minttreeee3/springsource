/**
 * 
 * 기존비밀번호,새비밀번호,새비밀번호 확인 내용
 * 새비밀번호와 새비밀번호확인 동일한가
 * 
 */

 const currentPwd = document.getElementById("floatingPassword1");
 const newPwd = document.getElementById("floatingPassword2");
 const confirmPwd = document.getElementById("floatingPassword3");
 
 const form = document.querySelector("form");
 
 form.addEventListener("submit", (e) => {
	 
	 e.preventDefault();
	 
	 if(currentPwd.value === "") {
		 alert("기존 비밀번호를 입력해주세요");
		 currentPwd.select();
		 return;
	 } else if(newPwd.value === "") {
		 alert("새 비밀번호를 입력해주세요");
		 newPwd.select();
		 return;		 
	 } else if(confirmPwd.value === "") {
		 alert("새 비밀번호 확인을 입력해주세요");
		 confirmPwd.select();
		 return;		 
	 } 
	 
	 if(newPwd.value!==confirmPwd.value) {
		 alert("새 비밀번호가 일치하지 않습니다");
		 confirmPwd.select();
		 return;
	 }
	 
	 form.submit();
	 
 });