<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	String[] clr = {
			"w3-red", "w3-orange", "w3-yellow", "w3-green",
			"w3-blue", "w3-indigo", "w3-purple", "w3-pink"
	};
	request.setAttribute("clr", clr);
%>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 7단</title>
<link rel="stylesheet" href="/css/w3.css">
<style>
</style>
<script type="text/javascript" src="/js/jquery3.4.1.js"></script>
<script type="text/javascript" src=" "></script>
</head>
<body>
	<div class="w3-col m4"><p></p></div>
	<div class="w3-container w3-col m4">
		<div class="w3-container w3-center">
			<c:forEach var="dan" begin="2" end="9" varStatus="vs">
				<div class="w3-col m4 pd1">
					<h3 class="w3-col ${clr[vs.count -1]} w3-padding w3-card">${dan} 단</h3>
					<div class="w3-col w3-border w3-border${clr[vs.count -1].substring(2)} w3-padding w3-card">
						<c:forEach var="gop" begin="1" end="9" varStatus="st">
							<h5>${dan} * ${gop} = ${dan * gop}</h5>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	
<%-- 
	<c:forEach items=”${clr}” var=”item” varStatus="vs">
		${vs.current}<br/>				<!-- 현재 아이템  -->
		${vs.index}<br/>				<!-- 0부터의 순서-->
		${vs.count}<br/>				<!-- 1부터의 순서-->
		${vs.first}<br />				<!-- 현재 루프가 처음인지 반환-->
		${vs.last}<br />				<!-- 현재 루프가 마지막인지 반환 -->  
		${vs.begin}<br />				<!-- 시작값 -->
		${vs.end}<br />					<!-- 끝값 --> 
		${vs.step}<br />				<!-- 증가값 --> 
	</c:forEach>  
 --%>
</body>
</html>