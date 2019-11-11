<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> submit Target page  </title>
<link rel="stylesheet" href="/css/w3.css">
<script type="text/javascript" src="/js/jquery3.4.1.js"></script>
<style>

</style>
<!-- 
	submit-target.jsp에서 버튼을 클릭하면 
	아이디와 비밀번호를 이 페이지로 전달하도록 처리한다.
	
		1. get방식
		2. post방식
		
 -->
<% 
	String sid = request.getParameter("id");
	String spw = request.getParameter("pw");
	
%>
<script type="text/javascript" >
	$(function(){
		$('#id').text('<%= sid%>');
		$('#pw').text('<%= spw%>');
	});
</script>
</head>
<body>
	<div class="w3-col m3"><p></p></div>
	<div class="w3-col w3-half w3-margin-top ">
		<h1 class="w3-container w3-col w3-orange w3-card w3-round-large">Parameter 받기</h1>
		<div class="w3-container w3-col w3-card w3-round-large">
			<div>
				<h3 class="w3-col m3">I D : </h3>
				<h3 class="w3-col m8" id="id"></h3>
			</div>
			<div>
				<h3 class="w3-col m3">P W : </h3>
				<h3 class="w3-col m8" id="pw"></h3>
			</div>		
		</div>
			
	</div>
</body>
</html>