package com.koitt.www.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;

public class BoardWriteForm implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String view = "/com/temp/test1/board/boardWrite.jsp";
		return view;
	}

}
