<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방 만들기</title>




<!-- 
<script type="text/javascript" src="./js/broadcast.js">
</script>
-->

</head>
<body>
<form action="/YORIZORI/roomres" method="post">
<div id="createform">
	<input type="hidden" name="member_id" value="${login.member_id }">
	<input type="hidden" name="member_nick" value="${login.member_nick }">
<div id="createroom">
<div id="title">
	<div class="blocks">
	<div class="title">방 이름</div>
		<span><input type="text" class="inputs" name="broadcast_title" placeholder="방 제목을 입력해주세요." required="required" autofocus="autofocus"></span>
	</div>
</div>
	<div class="blocks">
	<div class="password">비밀번호</div>
		<span class="password"><input type="text" class="inputs" name="broadcast_password" placeholder="비밀번호를 입력해주세요."></span>
	</div>
		<div class="blocks">
		<div class="maxclients">최대인원수(10명 제한)</div>
		<input type="number" class="inputclient"name="broadcast_maxclient" placeholder="최대인원수를 정해주세요." min="1"max="10" required="required">
			
	</div>
	<div class="blocks">
	<div class="public">공개여부</div>
	<select name="broadcast_public" class="inputs" required="required">
	       			<option value="Y">공개</option>
	       			<option value="N">비공개</option>
	 </select>
	</div>
	<div id="buttons">
		<button type="submit">만들기</button>
		<button onclick="history.back();">돌아가기</button>
	</div>
</div>
</div>
</form>

</body>

<style type="text/css">
@import url("/YORIZORI/resources/css/createroom.css");
</style>

</html>