<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
<script type="text/javascript">

	onload = function(){
		var id = opener.document.getElementsByName("id")[0].value;
		document.getElementsByName("id")[0].value = id;
	}
	
	function confirmId(bool){
		if (bool == "true") {
			opener.document.getElementsByName("id")[0].title = 'y';
			opener.document.getElementsByName("nick")[0].focus();
		} else {
			opener.document.getElementsByName("id")[0].focus();
		}
		self.close();
	}	


</script>
<style type="text/css">
	
	#idform {
		text-align: center;
	}
</style>
</head>
<body>

<div id="idform">
	<table>
		<tr>
			<td>
				<input type="text" name="id"/>
			</td>
		</tr>
		<tr>
			<td>
			<c:if test="${check eq 'true' }">
				아이디 사용이 가능합니다.
			</c:if>
			<c:if test="${check eq 'false' }">
				아이디가 존재합니다.
			</c:if>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="확인" onclick="confirmId('${check}')" />
			</td>
		</tr>		
	</table>
	</div>


</body>
</html>











