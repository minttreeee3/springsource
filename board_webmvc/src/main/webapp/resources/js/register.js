/**
 * 폼의 모든 요소가 비어있는지 확인
 * ==> 폼의 유효성 검사를 수행하고,
 * 유효성이 false인 경우 폼의 제출을 막고 에러상태를 시각적으로 표시(was-validated)함
 */

const form = document.querySelector("#registerForm");

form.addEventListener("submit", (e) => {
  if (!form.checkValidity()) {
    //form.checkValidity() : 부트스트랩에서 제공하는 함수 (유효성 검사)
    e.preventDefault();
    e.stopPropagation();
  }

  form.classList.add("was-validated");
});
