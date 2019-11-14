package com.koitt.www.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import com.koitt.www.dao.*;
import com.koitt.www.vo.*;

@WebServlet("/member/membInfo.ck")
public class MemberInfo extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//할일
		//1. 데이터 받고
		String sid = req.getParameter("mid");
		
		//2. 데이터베이스 작업으로 데이터 가져오고
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMemberInfo(sid);
		
		//3. 응답문서(json)만들고
		//응답객체에 한글이 포함되는 경우 처리
		resp.setCharacterEncoding("utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("{");
		pw.print("\"mno\": " + vo.getM_no() + ",");
		pw.print("\"mid\": \"" + vo.getM_id() + "\",");
		pw.print("\"mname\": \"" + vo.getM_name() + "\",");
		pw.print("\"mmail\": \"" + vo.getM_email() + "\",");
		pw.print("\"mtel\": \"" + vo.getM_tel() + "\",");
		pw.print("\"mdate\": \"" + vo.getsDate() + "  " + vo.getsTime() + "\"");
		pw.print("}");
	}
}
