/**
 * 1) 검색기준 선택 여부 확인
 * 2) 검색어가 입력되었는지 확인
 * ==> 둘다 입력이 된 경우에만 submit
 * 
 * /search.do
 * 
 * Action, Service, DAO 메소드 
 * 
 */

 const form = document.querySelector("form");
 
 const sel = document.querySelector(".form-select");
 const keyword = document.querySelector(".form-control");
 
 // select요소의 선택된 value 가져오기
/* const selectedVal = sel.options[sel.selectedIndex].value;
 console.log(selectedVal);*/
 
 
 
 form.addEventListener("submit", (e) => {
	 
	 e.preventDefault();
	 
	 if (sel.value === "검색기준선택") {
		 alert("검색기준을 선택해 주세요");
		 sel.focus();
		 return;
	 } else if (keyword.value === "") {
		 alert("검색어를 입력해 주세요");
		 keyword.select();
		 return;
	 }
	 	 
		 form.submit();
 });