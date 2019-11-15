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
<c:if test="${not empty sid}">
	<meta http-equiv="Refresh" content="3 ;url=/" />
</c:if>
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
			<a class="navbar-brand" href="/">JSP 게시판 웹사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/">메인</a>
				<li><a href="/board/boardList.cls">게시판</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="ture"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="/member/login.cls">로그인</a></li>
						<li><a href="member/join.cls">회원가입</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<c:if test="${empty sid}">
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top:20px;">
				<form method="post" action="/member/loginProc.cls">
					<h3 style="text-align:center;">로그인 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" 
							   name="id" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호" 
							   name="pw" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인">
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
	</c:if>
	
	<c:if test="${not empty sid}">
		<div class="w3-col m3"><p></p></div>
		<div class="w3-col m6 w3-center" id="d1">
			<h3>${sid} 님은 이미로그인 했습니다.</h3>
			<h6>메인 페이지로 이동합니다.</h6>
		</div>
	</c:if>
	
</body>
</html>