<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.broadcast_title }</title>
<script type="text/javascript">
window.onunload = function(event) {

	disconnect();
};

</script>


</head>
<link href="/YORIZORI/resources/css/chatroom.css" rel="stylesheet">
<body>
	<jsp:include page="/WEB-INF/views/form/header.jsp"></jsp:include>


<c:choose>
		<c:when test="${empty dto.broadcast_title }">
			방이 존재하지 않습니다.
			<script type="text/javascript">
				setTimeout(function() {
					// 3초 후 작동해야할 코드
					location.href = "/YORIZORI/stream";
				}, 3000);
			</script>
		</c:when>
		<c:otherwise>
			<c:if test="${dto.broadcast_currentclient ge dto.broadcast_maxclient}">
				<script type="text/javascript">
					alert("인원수 초과.");
					location.href = "/YORIZORI/stream";
				</script>
			</c:if>


			<c:if test="${!empty dto.broadcast_password }">
				<script type="text/javascript">
					var password = prompt("비밀번호를 입력하십시오.");
					if (password != '${dto.broadcast_password }') {
						alert("비밀번호가 틀렸습니다.");
						location.href = "/YORIZORI/stream";
					}
				</script>
			</c:if>
	</c:otherwise>
</c:choose>


<div id="localvideo">

</div>
<div id="remotevideo">

</div>


<div id="chatarea">
<input type="text" id="message" placeholder="채팅을 입력하세요." onkeyup="enterkey();"> 
<button id="sendBtn">전송</button>
<div id="messageArea">

</div>
</div>



<input type="hidden" id="nickname" value="${login.member_nick }">
<input type="hidden" id="broadcast_no" value="${dto.broadcast_no }">
<input type="hidden" id="rid" value="${dto.broadcast_title}">
</body>


<script type="text/javascript" src="https://cdn.jsdelivr.net/sockjs/latest/sockjs.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script type="text/javascript">
var sock;
var nickname = document.getElementById("nickname").value;
var client;  
var rid = document.getElementById("rid").value;
var messageArea = document.getElementById("messageArea");
var broadcast_no = document.getElementById("broadcast_no").value;


sock = new SockJS("/YORIZORI/chatserver");
client = Stomp.over(sock);
client.connect({}, connect, onError);
function connect(){
	   client.send("/sendmsg/chat/join", {}, JSON.stringify({chat_title: rid, type:'ENTER', user_id: nickname})); 
	    // 4. subscribe(path, callback)로 메시지를 받을 수 있다. callback 첫번째 파라미터의 body로 메시지의 내용이 들어온다.
	     client.subscribe("/getmsg/chat/room/"+rid, function (chat) {
	        var content = JSON.parse(chat.body);
	        $("#messageArea").prepend(content.user_id+": "+ content.chat_content+ "<br>")
	    });
		 client.subscribe("/getmsg/chat/join/"+rid, function (chat) {
	        var content = JSON.parse(chat.body);
	        $("#messageArea").prepend(content.chat_content+ "<br>");
			
	    });
		 client.subscribe("/getmsg/chat/leave/"+rid, function (chat) {
		        var val = JSON.parse(chat.body);
		        console.log(val.chat_content);
		        $("#messageArea").prepend(val.chat_content+ "<br>");
		    });
}
function onError(){
	
}

function enterkey() {
	//keyCode: 입력한 코드(13번 == enter)
	if (window.event.keyCode == 13) {
		var msg = document.getElementById("message");
		var aadd = msg.value;
		if(aadd.trim() == null || aadd.trim() == ''){
			alert("하나라도 입력하세요.");
		}else{
		sendMessage();
		}
	}
}


function textclear(){
	$("#messageArea").empty();
	
}

window.onpageshow = function (event)
{
	if (event.persisted || (window.performance && window.performance.navigation.type == 2)) {
		alert("잘못된 접근 입니다.");
		location.href = "/YORIZORI/stream";
	}

}

function disconnect(){
	client.send("/sendmsg/chat/disconnect", {}, JSON.stringify({chat_title: rid, type:'LEAVE', user_id: nickname}));
	//document.getElementById("disconnect").style.display="none";
	client.disconnect();
	location.href="/YORIZORI/stream"
}

//메시지 전송
function sendMessage() {
	msg = document.getElementById("message");
    client.send('/sendmsg/chat/message', {}, JSON.stringify({broadcast_no: broadcast_no , chat_title: rid, type:'CHAT', user_id: nickname , chat_content: msg.value}));
	msg.value = '';
}



	//handler에서 정해준 서버 겅로로 설정

	// SockJS로 연결한 웹소켓 주소에 Stomp을 씌움

	// sock의 이벤트

	

$("#sendBtn").click(function() {
	var msg = document.getElementById("message");
	var aadd = msg.value;
	if(aadd.trim() == null || aadd.trim() == ''){
		alert("하나라도 입력하세요.");
	}else{
		sendMessage();
		$('#message').val('')
	}

});


	


 //document.getElementById("disconnect").style.display="inline";




</script>
</html>