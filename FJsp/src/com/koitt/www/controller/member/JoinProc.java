package com.koitt.www.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.*;
import com.koitt.www.vo.*;

/**
 * 이 클래스는 로그인 처리요청이 왔을때 처리하는 클래스
 * @author 	김산하
 * @since 	2019.11.14
 * @version v.1.0
 * @see 	
 * 			변경이력
 * 				2019.11.14	-	JoinProc 클래스 제작	-	담당자 : 김산하
 *
 */
public class JoinProc implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		req.setAttribute("isRD",true);
		String view = "/member/login.cls";
		/*
		 	1. 데이터 받고
		 	2. 받은 데이터로 데이터베읏에 맞는 회원이 있는지 조회
		 	3. 결과에 따라 처리해주고
		 	
		 */
		//1.
		MemberVO vo = new MemberVO();
		vo.setM_id(req.getParameter("userID"));
		vo.setM_pw(req.getParameter("userPW"));
		vo.setM_name(req.getParameter("userName"));
		vo.setM_email(req.getParameter("userEmail"));
		vo.setM_tel(req.getParameter("userTel"));
		
		
		//2.
		MemberDAO dao = new MemberDAO();
		int result  = dao.join(vo);
		
		//3.
		if(result > 0 ){
			System.out.println("회원가입성공");
		}
		else {
			view = "/member/joinForm.cls";
		}
		return view;
	}

}