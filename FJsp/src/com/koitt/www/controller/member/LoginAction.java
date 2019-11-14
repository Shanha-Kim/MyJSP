package com.koitt.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;

public class LoginAction implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String view = "/com/temp/test1/member/loginAction.jsp";
		return view;
	}

}
