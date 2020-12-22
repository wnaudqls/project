<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	onload = function(){
		var nick = opener.document.getElementsByName("nick")[0].value;
		document.getElementsByName("nick")[0].value = nick;
	}
	
	function confirmnick(bool){
		if (bool == "true") {
			opener.document.getElementsByName("nick")[0].title = 'y';
			opener.document.getElementsByName("name")[0].focus();
		} else {
			opener.document.getElementsByName("nick")[0].focus();
		}
		self.close();
	}	


</script>

<style type="text/css">
	
	#nickform {
		text-align: center;
	}
</style>

</head>
<body>
<div id="nickform">
	<table>
		<tr>
			<td>
				<input type="text" name="nick" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>
			<c:choose>
				<c:when test="${check eq 'true' }">
					닉네임 사용이 가능합니다.
				</c:when>
				<c:otherwise>
					닉네임이 존재합니다.
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="확인" onclick="confirmnick('${check}')" />
			</td>
		</tr>		
	</table>
	</div>


</body>
</html>











