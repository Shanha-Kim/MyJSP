<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>   </title>
<link rel="stylesheet" href="/css/w3.css">
<style>
</style>
<%
	//세션에 저장
	session.setAttribute("sid", "yayaya");
%>
<script type="text/javascript" src="/js/jquery3.4.1.js"></script>
<script type="text/javascript" src=" "></script>
</head>
<body>
	<div class="w3-col m3"><p></p></div>
	<div class="w3-col m6 w3-center">
		<h2 class="w3-col w3-lime w3-card w3-margin-bottom">Redirect Test start</h2>
		<div class="w3-col w3-button w3-blue" id="btn">target1.jsp</div>
	</div>
	<script type="text/javascript">
		document.getElementById('btn').onclick = function(){
			location.href = 'target1.jsp';
		};
	</script>
</body>
</html>