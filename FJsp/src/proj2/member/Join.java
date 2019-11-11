package proj2.member;
/**
 * 
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Join extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String view = "/com/temp/test1/member/join.jsp";
		// 그런데 이미 로그인을 한 사람이 이 요청을 한 경우는
		// 세션 값을 확인후에 처리하면 되겠다.
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("SID");
		
		if(sid == null || sid.length() == 0) {
			// 이 경우는 로그인 안한경우이므로 회원가입 폼으로 넘겨주자.
			
			// 요청은 유지하고 뷰만 바꿔서 보여주는 forward 방식으로 처리해야 한다.
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, resp);
		} else {
			// 이미 로그인이 된 상태이므로
			// 메인페이지로 강제로 보내도록 하자.
			resp.sendRedirect("/");
		}
	}
}
