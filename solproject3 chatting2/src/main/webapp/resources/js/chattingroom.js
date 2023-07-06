/**
 *
 */
document.addEventListener("DOMContentLoaded", function () {
  console.log("채팅방개설됨" + roomName + ", " + roomId + ", " + username + "," + csrfToken);

  // SockJS를 내부에 들고있는 stomp를 내어줌
  var sockJs = new SockJS("/stomp/chat");
  var stomp = Stomp.over(sockJs);

  // connection이 맺어지면 실행
  stomp.connect({ "X-CSRF-TOKEN": csrfToken }, function () {
    console.log("STOMP Connection");

    // subscribe(path, callback)으로 메세지를 받을 수 있음
    stomp.subscribe("/sub/chat/room/" + roomId, function (chat) {
      var content = JSON.parse(chat.body);
      console.log("수신이 안됨?" + roomName + ":" + content);

      var message = content.message;

      var messageContainer = document.createElement("div");
      messageContainer.className = "col-6";

      var messageElement = document.createElement("div");
      messageElement.className = "alert alert-secondary";
      messageElement.innerHTML = "<b>" + username + " : " + message + "</b>";

      messageContainer.appendChild(messageElement);
      document.getElementById("msgArea").appendChild(messageContainer);
    });

    // 채팅방 입장시 보내는 메세지 send(path, header, message)
    stomp.send(
      "/pub/chat/join",
      { "X-CSRF-TOKEN": csrfToken },
      JSON.stringify({ roomId: roomId, writer: username })
    );
  });

  // 전송 버튼 눌렀을 때 보내는 메세지
  document.getElementById("button-send").addEventListener("click", function (e) {
    var msg = document.getElementById("msg");

    console.log("메세지 전송 : " + username + ":" + msg.value);
    stomp.send(
      "/pub/chat/message",
      { "X-CSRF-TOKEN": csrfToken },
      JSON.stringify({
        roomId: roomId,
        message: msg.value,
        writer: username,
      })
    );
    msg.value = "";
  });
});
