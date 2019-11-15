package com.koitt.www.controller.member;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.www.dao.*;
import com.koitt.www.vo.*;

@WebServlet("/member/membmodify.ck")
public class MemberModify extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//할일
		//1. 데이터 받고
		String sid = req.getParameter("mid");
		String target = req.getParameter("str");
		String check = req.getParameter("check");
		
		//2. 데이터베이스 작업으로 데이터 가져오고
		MemberDAO dao = new MemberDAO();
		int result = dao.modify(sid, target, check);
	
		//3. 응답문서(json)만들고
		//응답객체에 한글이 포함되는 경우 처리
		resp.setCharacterEncoding("utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("{");
		pw.print("\"result\": " + result);
		pw.print("}");
	}
}
