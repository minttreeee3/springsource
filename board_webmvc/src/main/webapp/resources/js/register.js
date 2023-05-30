/**
 * 폼의 모든 요소가 비어있는지 확인
 * ==> 폼의 유효성 검사를 수행하고,
 * 유효성이 false인 경우 폼의 제출을 막고 에러상태를 시각적으로 표시(was-validated)함
 */

const form = document.querySelector("#registerForm");

form.addEventListener("submit", (e) => {
  // 게시글 내용이 다 작성돼도 폼은 못가게 막기
  e.preventDefault();

  //form.checkValidity() : 부트스트랩에서 제공하는 함수 (유효성 검사)
  if (!form.checkValidity()) {
    // e.stopPropagation();  이벤트 전파를 막음
    form.classList.add("was-validated");
  } else {
    // 첨부파일 정보를 hidden으로 담아서 폼 전송하기
    // 첨부파일 정보 수집하기 - f12눌러서 영역이 어딘지 찾기
    const lis = document.querySelectorAll(".uploadResult ul li");
    console.log(lis);

    // lis forEach ==> li 태그 안에 data- 속성 값 수집
    // path,uuid,filename,type

    let str = "";
    lis.forEach((ele, idx) => {
      // console.log("path ", ele.dataset.path);
      // console.log("uuid ", ele.dataset.uuid);
      // console.log("filename ", ele.dataset.filename);
      // console.log("type ", ele.dataset.type);

      str += "<input type='hidden' name='attachList[" + idx + "].uuid' value='" + ele.dataset.uuid + "'/>";
      str += "<input type='hidden' name='attachList[" + idx + "].uploadpath' value='" + ele.dataset.path + "'/>";
      str += "<input type='hidden' name='attachList[" + idx + "].fileName' value='" + ele.dataset.filename + "'/>";
      str += "<input type='hidden' name='attachList[" + idx + "].fileType' value='" + ele.dataset.type + "'/>";
    });

    // 수집한 태그를 폼에 추가
    form.insertAdjacentHTML("beforeend", str);

    console.log(form);

    form.submit();
  }
});
