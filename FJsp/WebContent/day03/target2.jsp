<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>   </title>
<link rel="stylesheet" href="/css/w3.css">
<style>

</style>
<script type="text/javascript" src="/js/jquery3.4.1.js"></script>
<%
	int no = 10;
	request.setAttribute("no", no);
%>
<script type="text/javascript">
	alert('no :' + '${no}');
</script>
</head>
<body>
	<div class="w3-col m3"><p></p></div>
	<div class="w3-col m6 w3-center">
		<h2 class="w3-orange">Target2</h2>
		<div class="w3-container w3-card">
			<h3 class="w3-col m4">Session ID: </h3>
			<h3 class="w3-col m8"><%=session.getAttribute("sid") %></h3>
		</div>
		<div class="w3-container w3-card">
			<h3 class="w3-col m4">EL session ID : </h3>
			<h3 class="w3-col m8">${sessionScope.sid}</h3>
			<h3 class="w3-col m4">EL session ID(스코프생략) : </h3>
			<h3 class="w3-col m8">${sid}</h3>
		</div>
		<div class="w3-container w3-card">
			<h3 class="w3-col m4">EL session ID : </h3>
			<h3 class="w3-col m8"><c:out value=" ${sid}" /></h3>
			
		</div>
	</div>
</body>
</html>