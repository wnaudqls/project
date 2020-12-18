<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>






<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

</head>
<body>
	<%@include file="form/header.jsp"%>
	<input id="search" placeholder="방 이름을 입력해 주세요.">
	<button onclick="search()">검색</button>
	<button onclick="resetbroad()">초기화</button>
	<div id="broadcastlist">
	</div>
	<div id="footer">
		<%@include file="form/footer.jsp"%>
	</div>

</body>
<!--  
<style type="text/css">
@import url("./css/broadcast.css");
</style>
-->

<style type="text/css">

	@import url("resources/css/broadcastlist.css");

</style>


<script type="text/javascript">

var loop;
var reset;
window.onload = function(){
	broadlist();
}

function broadlist(){
	$.ajax({
		type: "post",
		url: "/YORIZORI/broadcastlist",
		dataType: "json",
		contentType: "application/json",
		 success: function(data){
			 $("#broadcastlist").empty();
			 var list = data.list;
			 for(i in list){
				 var member_id = list[i].member_id;
				 var mid = member_id.substring(0,4);
				 var member_nick = list[i].member_nick.substring(0,4);
				 var broadcast_title = list[i].broadcast_title;
				 var broadcast_maxclient = list[i].broadcast_maxclient;
				 var broadcast_currentclient = list[i].broadcast_currentclient;
				 
				 $("#broadcastlist").append(
						 '<div class="broadlist"' 
						 + 'onclick="location.href='+'\'broadcast/'+broadcast_title+'\'">'
						 +'<div class="broadcast_title>'
						 +'<span class="title">'
						 +	broadcast_title
						 +'</span>'
						 +'<div class="broadcast_nick">'
						 +'<span class="mid">'
						 +	mid
						 +'</span>'
						 +'</div>'
						 +'<div class="broadcast_nick">'
						 +'<span class="nick">'
						 +	member_nick
						 +'</span>'
						 +'</div>'
						 +'<div class="broadcast_nick">'
						 +'<span class="client">'
						 +	broadcast_currentclient+'/'+broadcast_maxclient
						 +'</span>'
						 +'</div>'
						 +'</div>'
						);
			 }
			
		 
			
			 
		 },error: function(error){
			 
		 }
	})
	
	loop = setTimeout(function() { 
		broadlist(); 
		}, 3000); //3초마다 반복
}
function search(){
	var search = document.getElementById("search").value;
	if(search.trim() == '' || search.trim() == null){
		alert("방 이름을 입력해 주세요.");
	}else{
		
		reset = true;
		clearTimeout(loop);
		var searchval = {
				"search": search
		}
		$.ajax({
			 type: "post",
			 url: "/YORIZORI/broadcastselectlist",
			 dataType: "json",
			 data: JSON.stringify(searchval),
			 contentType: "application/json",
			 success: function(data){
				 $("#broadcastlist").empty();
				 var list = data.list;
				 for(i in list){
					 var member_id = list[i].member_id;
					 var mid = member_id.substring(0,4);
					 var member_nick = list[i].member_nick.substring(0,4);
					 var broadcast_title = list[i].broadcast_title;
					 var broadcast_maxclient = list[i].broadcast_maxclient;
					 var broadcast_currentclient = list[i].broadcast_currentclient;
					 
					 $("#broadcastlist").append(
							 '<div class="broadlist"' 
							 + 'onclick="location.href='+'\'broadcast/'+broadcast_title+'\'">'
							 +'<div class="broadcast_title>'
							 +'<span class="title">'
							 +	broadcast_title
							 +'</span>'
							 +'<div class="broadcast_nick">'
							 +'<span class="mid">'
							 +	mid
							 +'</span>'
							 +'</div>'
							 +'<div class="broadcast_nick">'
							 +'<span class="nick">'
							 +	member_nick
							 +'</span>'
							 +'</div>'
							 +'<div class="broadcast_nick">'
							 +'<span class="client">'
							 +	broadcast_currentclient+'/'+broadcast_maxclient
							 +'</span>'
							 +'</div>'
							 +'</div>'
							);
				 }
				
				
				
				 
				 },error: function(error){
				 
				 }
			})
	}

}
function resetbroad(){
	var search = document.getElementById("search");
	
	if(reset == true){
		reset = false;
		search.value = "";
		console.log(search.value);
		broadlist();
	}
}


</script>
</html>