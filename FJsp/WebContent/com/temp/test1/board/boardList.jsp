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
<%-- <c:if test="${empty sid}"> --%>
<!-- 	<meta http-equiv="Refresh" content="3 ;url=/member/login.cls" /> -->
<%-- </c:if> --%>
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
<%-- 	<c:if test="${empty sid}"> --%>
<!-- 		<div class="w3-col m6 w3-center" id="d1"> -->
<!-- 			<h3>글을 작성하기 위해서는 로그인을 해야합니다.</h3> -->
<!-- 			<h6>잠시 후 로그인 페이지로 이동합니다.</h6> -->
<!-- 		</div> -->
<%-- 	</c:if> --%>

	<div class="w3-col m1"><p></p></div>
	<div class="w3-col m10 w3-center">
		<h2 class="btn btn-primary w3-col w3-margin-bottom">파일 업로드 게시판</h2>
		<c:if test="${not empty sid}">
			<a href="/board/boardWrite.cls" class="btn btn-primary pull-left" style="margin-bottom:3px;">글쓰기</a>
		</c:if>
		<div class="w3-col" style="margin-bottom:3px;">
			<div class="w3-row w3-border"> <!-- 글번호 | 작성자 | 작성일 | 타이틀 -->
				<div class="w3-col m2 w3-border-right">글번호</div>
				<div class="w3-col m2 w3-border-right">작성자</div>
				<div class="w3-col m3 w3-border-right">작성일</div>
				<div class="w3-col m5">글제목</div>
			</div>
			<c:forEach var="data" items="${lst}">
					<div class="w3-row w3-border" id="${data.bno}">
						<div class="w3-col m2 w3-border-right">${data.bno}</div>
						<div class="w3-col m2 w3-border-right">${data.bwriter}</div>
						<div class="w3-col m3 w3-border-right">${data.wDate}</div>
						<div class="w3-col m5">${data.btitle}</div>
					</div>
			</c:forEach>
		</div>
		<c:if test="${not empty sid}">
			<a href="/board/boardWrite.cls" class="btn btn-primary pull-right">글쓰기</a>
		</c:if>
	</div>
</body>
</html>