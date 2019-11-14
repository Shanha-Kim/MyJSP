package com.koitt.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.www.controller.MainController;

public class Logout implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/login.cls";
		req.setAttribute("isRD", true);
		// 할일
		// 세션을 비운다.
		HttpSession session = req.getSession();
		session.setAttribute("sid", null);
		
		return view;
	}

}
