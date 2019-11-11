<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Multiplication Table</title>
<style>
	.a{ border : 1px solid black;
		float:left;
		padding : 8px;
	}
</style>
</head>
<body>
	<center>
		<h1>Multiplication Table</h1>
	</center>
	<% for(int i=1;i<10;i++){%>
	<%if(i%3==1){%><div>--</div><%} %>
	<div class="a">
		<center><h2> <%= i %> 단</h2></center>
		<%for(int j=1;j<10;j++){%>
			<h3> <%=i%>*<%=j%>=<%=i*j %> </h3>
		<%}%>
	</div>
	<% } %>	 
</body>
</html>