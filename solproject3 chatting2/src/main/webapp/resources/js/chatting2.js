$(document).ready(function () {
  console.log("채팅방개설됨" + roomName + ", " + roomId + ", " + username);

  var sockJs = new SockJS("/stomp/chat");
  // SockJS를 내부에 들고있는 stomp를 내어줌
  var stomp = Stomp.over(sockJs);

  // connection이 맺어지면 실행
  stomp.connect({}, function () {
    console.log("STOMP Connection");

    // subscribe(path, callback)으로 메세지를 받을 수 있음
    stomp.subscribe("/sub/chat/room/" + roomId, function (chat) {
      // JSON -> js 객체로 변환
      var content = JSON.parse(chat.body);

      console.log("콜백" + roomName + ":" + content);

      var writer = content.writer;
      var str = "";

      // 내 메세지
      if (writer === username) {
        str = "<div class='col-8 offset-4'>";
        str += "<div class='alert alert-secondary'>";
        str += "<b>" + writer + " : " + content.message + "</b>";
        str += "</div></div>";
        $("#msgArea").append(str);
      } else {
        // 다른사람 메세지
        str = "<div class='col-8'>";
        str += "<div class='alert alert-warning'>";
        str += "<b>" + writer + " : " + content.message + "</b>";
        str += "</div></div>";
        $("#msgArea").append(str);
      }
    });

    // 입장시 메세지 발송 send(path, header, message)
    // js객체 -> JSON 형식으로 변환
    stomp.send("/pub/chat/join", {}, JSON.stringify({ roomId: roomId, writer: username }));
  });

  // 전송 버튼 클릭시 /pub/chat/message 로 메세지 발송
  $("#button-send").on("click", function () {
    var msg = document.getElementById("msg");

    stomp.send(
      "/pub/chat/message",
      {},
      JSON.stringify({ roomId: roomId, message: msg.value, writer: username })
    );
    console.log("메세지 전송 : " + username + ":" + msg.value);
    msg.value = "";
  });

  // 퇴장 버튼 클릭시 /pub/chat/exit 로 메세지 발송
  $("#button-exit").on("click", function () {
    var msg = document.getElementById("msg");

    stomp.send(
      "/pub/chat/exit",
      {},
      JSON.stringify({ roomId: roomId, message: msg.value, writer: username })
    );
    console.log("퇴장 메세지 : " + username + ":" + msg.value);

    // 홈페이지로 이동
    window.location.href = "http://localhost:8080/";
  });
});
