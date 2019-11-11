<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="proj1.*" %>
<%@ page import="VO.*" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="vo" class="VO.BBSVO" scope="page" />
<jsp:setProperty name="vo" property="userID" />
<jsp:setProperty name="vo" property="userPassword" />
<jsp:setProperty name="vo" property="userName" />
<jsp:setProperty name="vo" property="userGender" />
<jsp:setProperty name="vo" property="userEmail" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<style>
</style>
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		if(userID != null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인이 되어있습니다.')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}
		if(vo.getUserID() == null || vo.getUserPassword() == null || vo.getUserName() == null
			|| vo.getUserGender() == null || vo.getUserEmail() == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else{
			BBSDAO bbsdao = new BBSDAO();
			int result = bbsdao.join(vo);
			if(result >0 ){
				session.setAttribute("userID", vo.getUserID());
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'main.jsp'");
				script.println("</script>");
			}
			else if(result ==-1 ){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미존재하는 ID입니다.')");
				script.println("history.back()");
				script.println("</script>");
			}
		}
		
		
	
	%>
</body>
</html>