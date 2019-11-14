package com.koitt.www.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.*;

/**
 * 이 클래스는 로그인 처리요청이 왔을때 처리하는 클래스
 * @author 	김산하
 * @since 	2019.11.13
 * @version v.1.0
 * @see 	
 * 			변경이력
 * 				2019.11.13	-	LoginProc 클래스 제작	-	담당자 : 김산하
 *
 */
public class LoginProc implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		req.setAttribute("isRD",true);
		String view = "/";
		/*
		 	1. 데이터 받고
		 	2. 받은 데이터로 데이터베읏에 맞는 회원이 있는지 조회
		 	3. 결과에 따라 처리해주고
		 	
		 */
		//1.
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		
		//2.
		MemberDAO dao = new MemberDAO();
		int result  = dao.login(sid, spw);
		
		//3.
		if(result == 1 ){
			HttpSession session = req.getSession();
			session.setAttribute("sid", sid);
		}
		else {
			view = "/member/loginAction.cls";
		}
		
		
		return view;
	}

}
