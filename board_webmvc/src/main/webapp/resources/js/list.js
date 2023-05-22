/**
 *
 */

checkModal(result);

history.replaceState({}, null, null);

function checkModal(result) {
  if (result === "" || history.state) return;

  if (parseInt(result) > 0) {
    document.querySelector(".modal-body").innerHTML =
      "게시글" + result + "번이 등록되었습니다.";
  } else {
    document.querySelector(".modal-title").innerHTML = "게시글";
    document.querySelector(".modal-body").innerHTML = "처리가 완료되었습니다.";
  }

  //   jQuery 사용 (부트스트랩 4.~ 이하 버전이라서)
  $("#registerModal").modal("show");
}

// 하단의 페이지번호 클릭 시
// a 태그 기본 기능 중지
// a 태그의 href값을 가져온 후 operForm의 page 요소의 value값으로 세팅
// operForm 전송

const pagination = document.querySelector(".pagination");
const operForm = document.querySelector("#operForm");

pagination.addEventListener("click", (e) => {
  e.preventDefault();

  // href값 가져오기
  let href = e.target.getAttribute("href");

  // operForm안의 page value 값을 가져온 href로 세팅
  operForm.firstElementChild.value = href;
  console.log(operForm);

  operForm.submit();
});

// 상단의 amount 수정시 operForm의 amount요소의 value값으로 세팅
// operForm 전송
const amount = document.querySelector("#amount");

amount.addEventListener("change", (e) => {
  // 선택한 amount값 가져오기
  const val = e.target.value;

  const amount = document.querySelector("#operForm input:nth-child(2)");
  amount.value = val;

  operForm.submit();
});

// 제목 클릭 시 a태그 기능 중지
// operForm의 action은 /board/read로 변경
// operForm의 bno태그를 추가해서 operForm 전송
const moves = document.querySelectorAll(".move");

moves.forEach((move) => {
  move.addEventListener("click", (e) => {
    e.preventDefault();

    const href = e.target.getAttribute("href");
    const bno = "<input type='hidden' name='bno' value='" + href + "'>";

    operForm.insertAdjacentHTML("beforeend", bno);
    operForm.action = "/board/read";
    console.log(operForm);

    operForm.submit();
  });
});

// 뒤로 가기 이벤트 감지? ==> 새로고침 하기
// 뒤로가기하면서 글 클릭했을때 글번호가 계속해서 쌓이게되는걸 방지하려면 이걸 해야함
window.onpageshow = function (event) {
  // persisted == true : webpage가 로딩될 때 캐시에서 읽어왔다는 뜻
  if (event.persisted) {
    location.reload();
  }
};

// 검색 클릭 시
// type, keyword 입력 여부 확인
// 입력이 안된 경우 : 경고창 보여주기
// 입력이 다 된 경우 : 폼 submit

const searchForm = document.querySelector("#searchForm");

searchForm.addEventListener("submit", (e) => {
  e.preventDefault();

  const type = document.querySelector("#type");
  const keyword = document.querySelector("#keyword");

  if (type.value === "") {
    alert("검색 조건을 입력하세요");
    type.focus();
    return;
  } else if (keyword.value === "") {
    alert("검색어를 입력하세요");
    keyword.focus();
    return;
  }
  searchForm.submit();
});
