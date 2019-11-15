package com.koitt.www.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.MemberDAO;
import com.koitt.www.vo.MemberVO;
/**
 * 이 클래스는 회원가입 아이디 확인 처리요청이 왔을때 실행하는 클래스
 * @author 	김산하
 * @since 	2019.11.14
 * @version v.1.0
 * @see 	
 * 			변경이력
 * 				2019.11.14	-	IdCheck 클래스 제작	-	담당자 : 김산하
 *
 */
@WebServlet("/member/idCheck.cls")
public class IdCheck extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String sid = req.getParameter("id");
		MemberDAO mDAO = new MemberDAO();
		int cnt = mDAO.idCheck(sid);
		PrintWriter pw = resp.getWriter();
		
		pw.println("{");
		pw.println("	\"cnt\" : " + cnt);
		pw.println("}");
	}
}
