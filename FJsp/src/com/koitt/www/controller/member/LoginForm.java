package com.koitt.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;

public class LoginForm implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/com/temp/test1/member/login.jsp";
		/*
		boolean bool = (boolean) req.getAttribute("isRD");
		req.setAttribute("isRD", true);
		*/
		return view;
	}

}
