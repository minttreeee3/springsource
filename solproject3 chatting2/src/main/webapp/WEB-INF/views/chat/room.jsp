<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.css">

  

</head>

<body>
     
     	
		<div class="container">
		<div class="row">
            <div class="col-6">
                <h1>${room.name}</h1>
            </div>
	            <!-- <div class="col-3">
	                <h3>참여자 명단</h3>
	                <ul id="userList" class="list-group">
	                    사용자 목록이 여기에 추가될 것입니다.
	                </ul>
	            </div> -->
        </div>
        <div>
                <div id="msgArea" class="col"></div>
                <div class="col-7">
                    <div class="input-group mb-3">
                        <input type="text" id="msg" class="form-control">
                        <div class="input-group-append">
                            <button class="btn btn-outline-info" type="button" id="button-send">전송</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6"></div>
        </div>
     

<script>
                        
var roomName = '${room.name}';
var roomId = '${room.roomId}';
var username = '${username}';     

const csrfToken = '${_csrf.token}';

</script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
  <script src="../resources/dist/sockjs.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  
<script src="../resources/js/chatting2.js"></script>

</body>
</html>