<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
* {
	border: 0;
}
#likelisttext{
	font: small-caps bold 15px/1 sans-serif; 
}
.dropuser_content {
	display: none;
	position: absolute;
	background-color: #F5A9A9;
	min-width: 130px;
	overflow: visible;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	right: 10px;
}

a {
	text-decoration: none;
	color: black;
}

div {
	text-align: center;
}


/*굿즈 목록 리스트 큰테두리*/
.recipe_list {
	border: 1px solid black;
	margin: 0 5%;
}

#warning { /* warning이미지 */
	width: 100px;
	height: 100px;
	vertical-align: middle;
}

#message { /* warning 메시지 */
	display: inline-block;
	vertical-align: middle;
}

.nosection { /* 내용없을때 기본크기주기 */
	height: 400px;
}

section {
	margin: 0px;
}

.list_card {
	display: inline-block;
	width: 300px;
	height: 370px;
	/* border : 1px solid black; */
	border-radius: 25px;
	box-sizing: border-box;
	margin: 50px;
}
/* 카드이미지 테두리 */
.list_card_img { /* 이미지 감싸는 div */
	width: 300px;
	height: 250px;
	border-radius: 25px 25px 0 0;
}
.like_card_img { /* 이미지 감싸는 div */
	width: 300px;
	height: 150px;
	border-radius: 25px 25px 0 0;
}
/* 카드이미지태그 */
.list_img_tag { /* 이미지 태그 */
	border-radius: 25px 25px 0 0;
	width: 300px;
	height: 250px;
}
.like_img_tag { /* 이미지 태그 */
	border-radius: 25px 25px 0 0;
	width: 150px;
	height: 100px;
}
/* 카드 내용 */
.list_card_content {
	text-align: center;
	width: 300px;
	height: 120px;
}
.like_card_content {
	text-align: center;
	width: 300px;
	height: 450px;
}

.like_icon {
	margin-top: 13%;
	width: 50px;
	height: 50px;
}
.like_text {
	position: absolute;
	margin-top: 15%;
	font: small-caps 24px/1 sans-serif;
	width: 30px;
	height: 50px;
	/*    display: inline-block;
 */
}
.dislike_icon {
	width: 50px;
	height: 50px;
}
.like_text_2 {
	position: absolute;
	margin-top: 3%;
	font: small-caps 24px/1 sans-serif;
	width: 30px;
	height: 50px;
	/*    display: inline-block;
 */
}
#textrecipe{
font-size: 20pt;
}
/*좋아요 테두리*/
.list_card_like {
	position: relative;
	height: 50px;
}
.like_card{
	position: relative;
}
/*제목들어가는칸*/
.list_card_title {
	height: 30px;
	width: 300px;
	font: small-caps bold 15px/1 sans-serif;
}

.like_card_title {
	height: 70px;
	width: 300px;
	font: small-caps bold 15px/1 sans-serif;
}

.list_card_title_a {
	margin-top: 10px;
}
/* 페이징 css */
.off-screen {
	display: none;
}

/* 검색창 css */
.search {
	width: 36%;
	/* height: 40px; */
	margin: 10px auto;
	min-width: 100%;
	/* position: absolute; */
	/* margin-top: 17%; */
	z-index: 1;
	display: inline-block;
}

[name="search"] {
	width: 500px;
	height: 50px;
	font-size: 30px;
}

.btn {
	height: 50px;
	line-height: 56px;
	background-color: #F5A9A9;
	color: #FAFAFA;
}

.btns {
	width: 65px;
	height: 40px;
	line-height: 46px;
	background-color: #F5A9A9;
	color: #FAFAFA;
	float: right;
	position: relative;
	left: 40%;
	border-radius: 30px;
}

#add {
	width: 300px;
	height: 50px;
	line-height: 56px;
	background-color: #F5A9A9;
	color: #FAFAFA;
}

.search img {
	width: 70px;
	height: 35px;
	border-right: 1px solid #c2c2c2;
	border-top: 1px solid #c2c2c2;
	border-bottom: 1px solid #c2c2c2;
	cursor: pointer;
}

#nav a {
	margin-left: 20px;
	color: black;
	font-size: 25px;
}

input, button {
	position: relative;
	width: 300px;
	height: 50px;
	padding: 0;
	display: inline-block;
	float: left;
	border: solid 1px black;
}

input {
	color: #666;
	z-index: 2;
	border: 0 none;
}

input:focus {
	outline: 0 none;
}

input:focus+button {
	-webkit-transform: translate(0, 0);
	-ms-transform: translate(0, 0);
	transform: translate(0, 0);
	-webkit-transition-duration: 0.3s;
	transition-duration: 0.3s;
}

button {
	z-index: 1;
	width: 50px;
	border: 0 none;
	background: pink;
	cursor: pointer;
	border-radius: 0 5px 5px 0;
	-webkit-transform: translate(-50px, 0);
	-ms-transform: translate(-50px, 0);
	transform: translate(-50px, 0);
	-webkit-transition-duration: 0.3s;
	transition-duration: 0.3s;
}

fieldset {
	position: relative;
	display: inline-block;
	padding: 0 0 0 40px;
	background: #fff;
	border: none;
	border-radius: 5px;
}
#likelist{
	text-align: center;
}
.btn {
	width: 70px;
	height: 35px;
	background-color: #F5A9A9;
	color: #FAFAFA;
	border: 0;
	outline: 0;
	border-radius: 0.35em;
	font-weight: bold;
	cursor: pointer;
	margin: 3px;
	line-height: 1px;
}

#btns {
	text-align: right;
	float: right;
	margin-right: 300px;
}

#checkbox { /* 체크박스 */
	width: 17px;
	height: 17px;
	margin-top: 10px;
}

#chkwrapper {
	text-align: center;
	display: inline-block;
}


</style>
<meta charset="UTF-8">
<title>전체 레시피</title>


</head>
<body>
	<%@ include file="form/header.jsp"%>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
	var b = true;
	
	$(document).ready(function(){
		recipelist();
	})
	
	function recipelist(){
		b = true;
	$("#likelist").css("display","none");
	var member_no = $("#member_no").val();
	$("#recipelist").empty();
	$("#likelist").empty();
	$(".nosection").empty();
	$.ajax({
	    type: "post",
	    url: "/YORIZORI/recipelist",
	    dataType: "json",
	    contentType: "application/json",
	    success: function(data){
	    	var list = data.list;
	    	var nonlist = data.nonlist;
	    	if(nonlist == null || nonlist == ''){
	    		$("#products").append(	
						'<div class="nosection">'
						+'<img id="warning" alt="warning" src="resources/img/warning.jpg">'
						+'<h1 id="message">등록된 레시피가 존재하지 않습니다.</h1>'
						+'</div>'
						
	    		);
	    	}
	    	else{
	    		if(list == null || list == ''){
		    		$("#likelist").append("좋아요를 누른 레시피가 없습니다.");
		    	}
	    		for(i in list){
	    			var recipe_no = list[i].recipe_no;
	    			var recipe_title = list[i].recipe_title;
	    			var recipe_main_photo = list[i].recipe_main_photo;
	    			var recipe_likecount = list[i].recipe_likecount;
	    			console.log(list[i].member_no);
	    		$("#likelist").append(
	    		'<div class="list_card eval-contents">'+
					'<div class="like_card_img">'
						+'<a href="">'
						+'<img class="like_img_tag"'
								+'alt="레시피메인사진" '
						+'src="'+recipe_main_photo+'"'
						+'alt="레시피메인사진" />'
						+'</a>'
					+'</div>'
					+'<div class="like_card_content">'
						+'<div class="like_card_title">'
							+ '『<a class="list_card_title_a"'
								+'href="/YORIZORI/recipe_detail/'+recipe_no+'">'+recipe_title+'</a>』'	
						+'</div>'
						+'<div class="like_card">'
							+'<input type="image"'
								+'onclick="addlikes('+recipe_no+','+member_no+');"'
								+'class="dislike_icon" src="resources/img/recipe/dislike_icon.png" />'
							+'<span class="like_text_2">'+recipe_likecount+'</span>'
						+'</div>'
					+'</div>'
				+'</div>'
				+'</div>');
	    		}
	    		for(i in nonlist){
	    			var recipe_no =  nonlist[i].recipe_no;
	    			var recipe_title = nonlist[i].recipe_title;
	    			var recipe_main_photo = nonlist[i].recipe_main_photo;
	    			var recipe_likecount = nonlist[i].recipe_likecount;
	    			console.log(nonlist[i].member_no);
	    		$("#recipelist").append(
	    		'<div class="list_card eval-contents">'+
					'<div class="list_card_img">'
						+'<a href="">'
						+'<img class="list_img_tag"'
								+'alt="레시피메인사진" '
						+'src="'+recipe_main_photo+'"'
						+'alt="레시피메인사진" />'
						+'</a>'
					+'</div>'
					+'<div class="list_card_content">'
						+'<div class="list_card_title">'
							+'<br> 『<a class="list_card_title_a"'
								+'href="/YORIZORI/recipe_detail/'+recipe_no+'">'+recipe_title+'</a>』'	
						+'</div>'
						+'<div class="list_card_like">'
							+'<input type="image"'
								+'onclick="addlikes('+recipe_no+','+member_no+');"'
								+'class="like_icon" src="resources/img/recipe/like_icon.png" />'
							+'<span class="like_text">'+recipe_likecount+'</span>'
						+'</div>'
					+'</div>'
				+'</div>'
				+'</div>');
	    		}
	    		
	    	}
	    		
	    },
	    error: function(data){

	    	
	    	}
		});
	}

	</script>
	
	

	<script type="text/javascript">
	
$(function() {

	var bool = true;
	$("#allcheck").click(function() {
		if (bool) {
			allChk(bool);
			bool = false;
		} else {
			allChk(bool);
			bool = true;
		}
	});
});

function alldel() {
	var msg = "정말로 전체삭제를 하시겠습니까? 삭제버튼을 누르시면 삭제됩니다.";
	var flag = confirm(msg);
	if (flag == true) {
		allchk();
	
	} else {
		alert("삭제가 취소되었습니다.")
	}

}

function allChk(bool) {
	var chks = document.getElementsByName("chk");
	console.log(chks);
	for (var i = 0; i < chks.length; i++) {
		chks[i].checked = bool;
	}

}

function confirmchk() {
	var chks = document.getElementsByName("chk");
	console.log(chks);
	if ($("#muldelform input:checked").length == 0) {
		alert("하나 이상 체크해주시기 바랍니다.");
	} else {
		$("#muldelform").submit();
	}
};
</script>

	<section>

		<div id="btns">
			<c:if test="${!empty login }">
				<input class="btn" type="button" value="등록"
					onclick="location.href='/YORIZORI/recipeinsert'" />
			</c:if>
			<c:if test="${login.member_role eq '관리자' }">
				<input class="btn" type="submit" value="삭제" onclick="confirmchk();" />
				<input type="hidden" name="recipe_no" value="${dto.recipe_no }" />
				<input class="btn" type="button" value="전체선택 " name="all"
					id="allcheck" />
			</c:if>
		</div>
		<div class="search">
			<form action="/YORIZORI/recipe_search" method="post">
				<fieldset>
					<input type="text" placeholder="레시피 검색" id="recipe_search"
						name="recipe_title">
					<button type="submit" class="btn">
						<i class="fa fa-search"><strong>검색</strong></i>
					</button>
				</fieldset>
			</form>
		</div>


		<!--  
			<form action="recipemuldel" method="post" id="muldelform">
		-->
		
			<div class="recipe_list" id="products">
		
					<a href="#" id="likelisttext">좋아요 한 레시피 목록</a>
					<div id="likelist">
		
					</div>
	

						
		

						<div id="recipelist">
							 <%--  <div class="list_card eval-contents">
								<div id="chkwrapper">
									<c:if test="${rdto.member_role eq '관리자' }">
										<input type="hidden" name="recipe_no"
											value="${dto.recipe_no }" />
										<input type="checkbox" id="checkbox" name="chk"
											value="${dto.recipe_no }" />
									</c:if>
								</div>
								<div class="list_card_img">
									<a
										href="recipe.do?command=recipe_detail&recipe_no=${dto.recipe_no }">
										<c:choose>
											<c:when
												test="${fn:substring(dto.recipe_main_photo,0,4) eq 'http' }">
												<img src="${dto.recipe_main_photo }" class="list_img_tag"
													alt="레시피메인사진" />
											</c:when>
											<c:otherwise>
												<img
													src="${pageContext.request.contextPath }/recipeimages/${dto.recipe_main_photo }"
													class="list_img_tag" alt="레시피메인사진" />
											</c:otherwise>
										</c:choose>
									</a>
								</div>
								<div class="list_card_content">
									<div class="list_card_title">
										<br> 『<a class="list_card_title_a"
											href="recipe.do?command=recipe_detail&recipe_no=${dto.recipe_no }">${dto.recipe_title }</a>
										』
									</div>

									<div class="list_card_like">
										<input type="image"
											onclick="addlikes(${dto.recipe_no}, ${rdto.member_no});"
											class="like_icon" src="resources/img/recipe/like_icon.png" />
										<span class="like_text">${dto.recipe_likecount}</span>
									</div>
								</div>

							</div>   --%>
						</div>
		
		

			</div>
		</form>
	</section>
	<form action="" id="setRows">
		<input type="hidden" name="rowPerPage" value="9">
	</form>
	
	
	
	<script>
      var $setRows = $('#setRows');

      $setRows
            .submit(function(e) {
               e.preventDefault();
               var rowPerPage = $('[name="rowPerPage"]').val() * 1;// 1 을  곱하여 문자열을 숫자형로 변환

               //            console.log(typeof rowPerPage);

               var zeroWarning = 'Sorry, but we cat\'t display "0" rows page. + \nPlease try again.'
               if (!rowPerPage) {
                  alert(zeroWarning);
                  return;
               }
               $('#nav').remove();
               var $products = $('#products');

               $products.after('<div id="nav" class="paging">');

               var $tr = $($products).find('.eval-contents');
               var rowTotals = $tr.length;

               var pageTotal = Math.ceil(rowTotals / rowPerPage);
               var i = 0;

               for (; i < pageTotal; i++) {
                  $('<a href="#"></a>').attr('rel', i).html(i + 1)
                        .appendTo('#nav');
               }

               $tr.addClass('off-screen').slice(0, rowPerPage)
                     .removeClass('off-screen');

               var $pagingLink = $('#nav a');
               $pagingLink.on('click', function(evt) {
                  evt.preventDefault();
                  var $this = $(this);
                  if ($this.hasClass('active')) {
                     return;
                  }
                  $pagingLink.removeClass('active');
                  $this.addClass('active');

                  // 0 => 0(0*4), 4(0*4+4)
                  // 1 => 4(1*4), 8(1*4+4)
                  // 2 => 8(2*4), 12(2*4+4)
                  // 시작 행 = 페이지 번호 * 페이지당 행수
                  // 끝 행 = 시작 행 + 페이지당 행수

                  var currPage = $this.attr('rel');
                  var startItem = currPage * rowPerPage;
                  var endItem = startItem + rowPerPage;

                  $tr.css('opacity', '0.0').addClass('off-screen').slice(
                        startItem, endItem).removeClass('off-screen')
                        .animate({
                           opacity : 1
                        }, 100);

               });

               $pagingLink.filter(':first').addClass('active');

            });

      $setRows.submit();
   </script>
	<%@ include file="form/footer.jsp"%>

</body>


<script type="text/javascript" src="resources/js/likes.js">
</script>
<script type="text/javascript">
document.getElementById("likelisttext").onclick= function(){
	
	if(b == true){
		$("#likelist").css("display", "block");
		b = false;
	}else if(b == false){
		$("#likelist").css("display", "none");
		b = true;
	}
		
}
</script>


</html>