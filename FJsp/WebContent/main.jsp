<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>JSP BBS WebSite</title>
<link rel="stylesheet" href="css/bootstrap.css" >
<link rel="stylesheet" href="css/w3.css" >
<script type="text/javascript" src="js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		/* 회원 정보보기 비동기 처리 */
		$('#memberInfo').click(function(){
			// 회원번호를 mt3 클래스가 적용된 태그에 아이디 값으로 입력해놨으므로
			// 해당태그의 아이디 값을 읽어온다.
			var tid = '${sid}';
			// 이제 화면 전체가 리로드 되어야 하는 것이 아니고
			// detail 아이디가 부여된 태그에만 적용이 되어야 하므로
			// 비동기 통신으로 데이터를 받아서
			// 해당 태그에 적용시켜주면 된다.
			
			$.ajax({
				url : "/member/membInfo.ck",
				type : "post",
				dataType : "json",
				data : {
					mid : tid
				},
				success : function(data){
					alert("success");
					$('#mno').html(data.mno);
					$('#mid').html(data.mid);
					$('#mname').html(data.mname);
					$('#mmail').html(data.mmail);
					$('#mtel').html(data.mtel);
					$('#mdate').html(data.mdate);
					$('#detail').css('display', 'block');
				},
				error : function(){
					alert('### 통신 에러 ###');
				}
			});
		});
		$('#btn').click(function(){
			$('#detail').css('display', 'none');
		});
	//==========================회원정보 수정=======================================
		$('#modi11').click(function(){

			var tid = '${sid}';
			var mail = $('#newmail').val();
			var check2 = "1";
			$.ajax({
				url : "/member/membmodify.ck",
				type : "post",
				dataType : "json",
				data : {
					mid : tid,
					str : mail,
					check : check2
				},
				success : function(data){
					alert("success");
					if(data.result==1){
						alert("회원정보가 수정되었습니다.");
						$('#mmail').html(mail);
						$("#newmail").css("display", "none");
						$("#modi11").css("display", "none");
						$("#mmail").css("display", "block");
						$("#modi1").css("display", "block");
					}else{
						alert("수정 실패")
					}
				},
				error : function(requst, status, error){
					alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
				}
			});
		});
		$('#modi22').click(function(){

			var tid = '${sid}';
			var mtel = $('#newtel').val();
			var check2 = "2";
			
			$.ajax({
				url : "/member/membmodify.ck",
				type : "post",
				dataType : "json",
				data : {
					mid : tid,
					str : mtel,
					check : check2
				},
				success : function(data){
					alert("success");
					if(data.result==1){
						alert("회원정보가 수정되었습니다.");
						alert(mtel);
						$('#mtel').html(mtel);
						$("#newtel").css("display", "none");
						$("#modi22").css("display", "none");
						$("#mtel").css("display", "block");
						$("#modi2").css("display", "block");
					}else{
						alert("수정 실패")
					}
				},
				error : function(requst, status, error){
					alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
				}
			});
		});
	//=========================일반 스크립트===========================
		$("#modi1").click(function(){
			$("#mmail").css("display", "none");
			$("#newmail").css("display", "block");
			$(this).css("display","none");
			$("#modi11").css("display", "block");
		});
		$("#modi2").click(function(){
			$("#mtel").css("display", "none");
			$("#newtel").css("display", "block");
			$(this).css("display","none");
			$("#modi22").css("display", "block");
		});
	});
</script>
<style>
</style>
</head>
<body> 
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main.jsp">메인</a>
				<li><a href="/board/boardList.cls">게시판</a>
			</ul>
			<c:if test="${empty sid}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="ture"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/member/login.cls">로그인</a></li>
						<li><a href="/member/join.cls">회원가입</a></li>
					</ul>
				</li>
			</ul>
			</c:if>
			<c:if test="${not empty sid}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="ture"
						aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/member/logout.cls">로그아웃</a></li>
						<li><a id="memberInfo">회원정보</a></li>
					</ul>
				</li>
			</ul>
			</c:if>
		</div>
	</nav>
	<!-- 회원 상세정보 보기 -->
	
	<div class="w3-modal" id="detail">
		<div class="w3-modal-content">
			<div class="w3-contatiner w3-col w3-white w3-padding">
			<span id="btn" class="close">&times;</span>
				<h2 class="w3-col w3-purple w3-padding w3-card">회원 정보</h2>
				<div class="w3-col w3-border-bottom">
					<h5 class="w3-col m3">회원번호 : </h5>
					<h5 class="w3-col m9" id="mno"></h5>
				</div>
				<div class="w3-col w3-border-bottom">
					<h5 class="w3-col m3">아 이 디 : </h5>
					<h5 class="w3-col m9" id="mid"></h5>
				</div>
				<div class="w3-col w3-border-bottom">
					<h5 class="w3-col m3">회원이름 : </h5>
					<h5 class="w3-col m9" id="mname"></h5>
				</div>
				<div class="w3-col w3-border-bottom" id="new_email">
					<h5 class="w3-col m3">이 메 일 : </h5>
					<h5 class="w3-col m8" id="mmail"></h5>
					<input class="w3-col m8" type="text" id="newmail" style="display:none;">
					<button class="w3-col m1" id="modi1">수정</button> 
					<button class="w3-col m1" id="modi11" style="display:none;">완료</button> 
				</div>
				<div class="w3-col w3-border-bottom" id="new_tel">
					<h5 class="w3-col m3">전화번호 : </h5>
					<h5 class="w3-col m8" id="mtel"></h5>
					<input class="w3-col m8" type="text" id="newtel" style="display:none;">
					<button class="w3-col m1" id="modi2">수정</button>
					<button class="w3-col m1" id="modi22" style="display:none;">완료</button>
				</div>
				<div class="w3-col w3-border-bottom w3-margin-bottom">
					<h5 class="w3-col m3">가 입 일 : </h5>
					<h5 class="w3-col m9" id="mdate"></h5>
				</div>
			</div>
		</div>
	</div>
</body>
</html>