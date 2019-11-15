<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>JSP BBS WebSite</title>
<link rel="stylesheet" href="/css/bootstrap.css" >
<script type="text/javascript" src="/js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript" src="/js/bootstrap.js"></script>
<link rel="stylesheet" href="/css/w3.css" >
<c:if test="${empty sid}">
	<meta http-equiv="Refresh" content="3 ;url=/member/login.cls" />
</c:if>
<style>
</style>
<script type="text/javascript">
	$(function(){
// 		$('#cancel').click(function(){
// 			$(location).attr('href', 'boardList.cls');
// 		});
		
		function s1(){
			var ttl = $('#title').val();
			var db = $('#body').val();
			
			if(!ttl || !db){
				alert('필수 입력 사항을 확인하세요!');
				return;
			}
			
			$('#frm').attr('method', 'post');
			$('#frm').attr('action', '/board/boardWriteProc.cls');
			$('#frm').submit();
		}
		
		$('#submit').click(s1);
	});
</script>
</head>
<!-- 
	이곳은 html 페이지에서 사용하는 다중행 주석
	
	이 화면은 글쓰기 폼을 보여주면 된다.
	
	파일게시판 글 입력요청은 GET 으로는 처리를 할 수 없고
	post 방식으로 입력요청을 해야 하는데...
	post 방식은 내부적으로 2가지 방식으로 나눠서 처리해 줄 수 있다.
	
		1. parameter 방식
			==> value 값만 서버에 [ 키값=데이터 ] 의 형태로 전달하는 방식
				꺼낼때는 
					req.getParameter("키값"); 
				로 꺼내면 된다.
				
		2. stream 방식
			==> 폼안에 있는 내용을 스트림으로처리해서 byte[]로 만들어서
				서버에 전달하는 방식
				
				따라서 서버에서는 스트림으로 만들어서 받아야 한다.
				
		파일 첨부가 있는 경우 parameter 방식으로 보내면
		파일 이름만 서버에 전달이 된다.
		(즉, 파일의 내용은 (실제 코드) 서버에 전달되지 않는다.)
		파일의 내용까지 서버에 전달하기 위해서 파일을 스트림으로 변경시켜서 전달해야 한다.
		
		enctype="muntipart/form-data"
		라는 속성은 스트림방식으로 처리하라는 의미를 가진 속성이다.
		
		스트림을 제어하기 위한 라이브러리가 많이 제공되고 있는데
		그중에 가장 많이 사용하는 라이브러리는
			1. cos.jar
				- 중복이름의 파일이 존재할 경우 파일이름을 자동으로 변경해서 처리해준다.
				
			2. fileupload.jar
				- 파일 리네임규칙을 따로 정의해서 지정해줘야 한다.
				
		두가지 라이브러가 대표적으로 많이 사용된다.
		
		결론]
			파일 첨부라는 기능은 
			파일의 내용을 서버에 전달하여
			서버가 그 파일을 원하는 위치에 저장하도록 하는 것이다.
			따라서 반드시 스트림 방식으로 전달해야 하며
			결론적으로 폼을 만들 때 
				enctype="multipart/form-data"
			라는 속성을 반드시 지정해야 한다.
 -->
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
			<a class="navbar-brand" href="/">JSP 게시판 웹사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/">메인</a>
				<li><a href="/">게시판</a>
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
	<c:if test="${empty sid}">
		<div class="w3-col m3"><p></p></div>
		<div class="w3-col m6 w3-center" id="d1">
			<h3>글을 작성하기 위해서는 로그인을 해야합니다.</h3>
			<h6>잠시 후 로그인 페이지로 이동합니다.</h6>
		</div>
	</c:if>
	<c:if test="${not empty sid}">
	<div class="container">
		<div class="row">
			<form id="frm" enctype="Multipart/form-data">
				<table class="talbe table-striped" style="text-align:center; board:1px solid #dddddd; width:100%; margin-bottom:5px;" >
					<thead>
						<tr>
							<th colspan="2" style="background-color:#eeeeee; text-align:center; height:50px;"> 게시판 글쓰기 </th>
						</tr>
					</thead>
					<tbody>
						<input type="hidden" name=sid value="${sid}">
						<tr>
							<td><input type="text" id="title" class="form-control" placeholder="글 제목" name="btitle" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea id="body" class="form-control" placeholder="글 내용" name="bbody" maxlength="4000" style="height:350px;"></textarea></td>
						</tr>
						<tr>
							<td><input type="file" class="form-control" placeholder="파일첨부" name="bfile" maxlength="50"></td>
						</tr>
					</tbody>
				</table>
				<input type="reset" class="btn btn-primary pull-left" value="작성취소">
				<button class="btn btn-primary pull-right" id="submit">작성완료</button>
			</form>
		</div>
	</div>
	</c:if>
</body>
</html>