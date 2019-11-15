package com.koitt.www.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.*;
import com.koitt.www.vo.*;

public class BoardListForm implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//뷰 정하고
		String view = "/com/temp/test1/board/boardList.jsp";
		
		//데이터 받고, 없으니 패스
		
		//DAO 에서 DB작업하고
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> lst = dao.getBoardList();
		
		//데이터 넘기고
		req.setAttribute("lst", lst);
		
		return view;
	}

}
