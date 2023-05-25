/**
 * 댓글 처리 자바스크립트 모듈
 */
let replyService = (function () {
  // reply : 댓글 작성 자바스크립트 객체
  // callback : function

  function add(reply, callback) {
    console.log("add 함수");

    fetch("/replies/new", {
      method: "post",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(reply),
    })
      .then((response) => {
        // 결과가 도착하게 되면 자동 호출 (비동기호출)
        if (!response.ok) {
          throw new Error("입력 오류");
        }
        return response.text(); //성공시 넘어오는게 success라는 글자이기때문에 text로 받음
      })
      .then((data) => {
        if (callback) {
          callback(data);
        }
      })
      .catch((error) => console.log(error));
  } // add 종료

  //특정 게시물에 대한 전체 댓글 조회
  function getList(param, callback) {
    let bno = param.bno;
    let page = param.page;

    fetch("/replies/pages/" + bno + "/" + page)
      .then((response) => {
        if (!response.ok) {
          throw new Error("리스트 없음");
        }
        return response.json();
      })
      .then((data) => {
        console.log("데이터");
        console.log(data);
        //data가 도착해서 함수가 호출되면 넘겨받은 함수를 호출
        if (callback) {
          callback(data.replyCnt, data.list);
        }
      })
      .catch((error) => console.log(error));
  } // getList 종료

  function displayTime(timeVal) {
    const today = new Date();

    let gap = today.getTime() - timeVal;
    let dateObj = new Date(timeVal);

    let str = "";

    // 작성날짜를 보여줄때 24시간 안에 작성했는지? 넘었는지? 기준으로 나눠서
    // 24시간 안이라면 시분초, 넘었다면 년월일
    if (gap < 1000 * 60 * 60 * 24) {
      let hh = dateObj.getHours(); // 1~9시 10~12시
      let mi = dateObj.getMinutes();
      let ss = dateObj.getSeconds();

      // 시분초
      return [
        (hh > 9 ? "" : "0") + hh,
        ":",
        (mi > 9 ? "" : "0") + mi,
        ":",
        (ss > 9 ? "" : "0") + ss,
      ].join("");
    } else {
      const yy = dateObj.getFullYear();
      const mm = dateObj.getMonth() + 1;
      const dd = dateObj.getDate();
      return [
        yy,
        "/",
        (mm > 9 ? "" : "0") + mm,
        "/",
        (dd > 9 ? "" : "0") + dd,
      ].join("");
    }
  } // ditplayTime끝

  //댓글 하나 가져오기
  function get(rno, callback) {
    fetch("/replies/" + rno)
      .then((response) => {
        if (!response.ok) {
          throw new Error("가져올 댓글 없음");
        }
        return response.json();
      })
      .then((data) => {
        if (callback) {
          callback(data);
        }
      })
      .catch((error) => console.log(error));
  }

  function update(reply, callback) {
    fetch("/replies/" + reply.rno, {
      method: "put",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(reply),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("수정 실패");
        }
        return response.text();
      })
      .then((data) => {
        if (callback) {
          callback(data);
        }
      })
      .catch((error) => console.log(error));
  }

  function remove(rno, callback) {
    fetch("/replies/" + rno, {
      method: "delete",
      //넘어오는 데이터가 없으므로 headers~는 안써도됨
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("삭제 실패");
        }
        return response.text();
      })
      .then((data) => {
        if (callback) {
          callback(data);
        }
      })
      .catch((error) => console.log(error));
  }

  // 외부에서 접근 가능한 함수 지정
  // 이걸 써야만 외부에서 호출이 가능해짐
  return {
    add: add,
    getList: getList,
    displayTime: displayTime,
    get: get,
    update: update,
    remove: remove,
  };
})();
