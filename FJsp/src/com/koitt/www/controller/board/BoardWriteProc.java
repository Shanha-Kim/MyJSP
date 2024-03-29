package com.koitt.www.controller.board;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.*; //con.jar 라이브러리
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.koitt.www.controller.MainController;
import com.koitt.www.dao.BoardDAO;
import com.koitt.www.vo.BoardVO;
import com.koitt.www.vo.FileInfoVO;

public class BoardWriteProc implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 성공을 하던 실패하던 뷰 전환방식은 Redirect 방식일 것이다.
		req.setAttribute("isRD", true);
		String view = "/board/boardList.cls";
		int check = 0;
		/*
			이 컨트롤러는 지금까지의 컨트롤러와는 조금 다르다.
			지금까지는 파라미터 방식으로 데이터가 전달이 되고
				req.getParameter("???");
			방식으로 처리를 했지만
			
			지금은 파라미터방식이 아닌 
			스트림 방식으로 데이터가 전달이 되기 때문에
			받는 방식도 스트림 방식으로 받아야 된다.
			
			스트림방식으로 전달되는 데이터를 처리해주는 라이브러리가 두가지 있는데
			우리는 cos.jar 라는 라이브러리를 사용해서 처리할 것이고
			cos.jar 라이브러리에서는 스트림 처리를 해주는 기능이 
				MultipartRequest
			라는 클래스가 그 데이터를 관리하도록 하고 있다.
			
			데이터 처리는 먼저 스트림을 이용해서 파라미터를 저장하도록 한다.
			즉, byte[] 로 온 데이터를 우리가 지금까지 사용한 방법으로 사용가능하도록
			변환시켜야 한다.
			
			이 작업을 도와주기 위해서 cos.jar 라이브러리를 등록했고
			이 라이브러리 안에 위 작업을 할 수있는 기능이 포함되어 있고
				클래스		: MultipartRequest
				생성방법	: 
								
					new MulitpartRequest(req, 저장경로, 업로드최대크기,
											인코딩방식, 파일리네임정책);
											
			이 클래스를 new 시키면
				1. byte[] 로 전달받은 데이터를 우리가 사용하기 편한 파라미터 방식으로 변환시켜준다.
				2. 이 클래스만의 특징으로 파일 업로드 기능이 완성이 된다.
					즉, 서버의 지정한 디렉토리에 파일이 저장된다.
					
					이때 가장 중요한 기능이 저장 경로를 지정하는 것이다.
					
			문제점]
				이 클래스를 new 시키는 순간 이미 파일은 서버에 저장된다.
				즉, 업로드가 된다.
				따라서 파라미터가 매우 중요한 파라미터인데......
				
				
			저장 경로를 지정하는 방법(목적에 따라 달라진다.)
				1. 오직 다운로드용으로만 저장하는 경우
					이 경우는 서버의 아무 폴더에나 강제로 지정하면 된다.
					
					예]
						String sPath = "d:\\upload";
						
				2. 업로드한 파일을 뷰에서 사용하기 위해 저장하는 경우
					예]
						사진을 첨부하면 상세보기에서 그 사진이 나오도록 해야한다.
						이 경우는 반드시 서버가 이용하는 폴더를 찾아서 지정해야 한다.
						왜냐하면 서버는 프로젝트에 존재하지 않는 파일을 사용할 수 없기 때문이다.
						
							1) 프로젝트 안에 저장할 경로가 들어갈 폴더를 만든다.
							2)	getRealPath() 를 이용해서 지정한 경로의 실제 패스를 찾아서 저장해야 한다.
								예]
									String sPath = req.getSession().getServletContext().getRealPath("찾을폴더이름");
									
				3. 업로드할 파일의 최대크기를 바이트단위로 지정한다.
					예]
						int size = 1024 * 1024 * 1024 * 10 ; // ==> 10Gb
						
				4. 인코딩방식 지정
					파일의 이름이 한글인 경우 파일의 이름이 깨질 수 있다.
					이런경우 한글 파일의 이름을 복구할 인코딩 방식을 지정한다.
					예]
						encoding="UTF-8"
				
				5. 파일이름 리네임 정책
					이것은 아직(?) 한가지 방법만 제공되고 있다.
					업로드할 파일의 이름이 이미 대상폴더에 존재하는 경우
					파일이름 뒤에 (1), (10) 등의 숫자를 이용해서 변경하는 방식
					
					예]
						DefaultFileRenamePolicy p = new DefaultFileRenamePolicy();
		*/
		
		//데이터 받고
		// 1. 스트림방식으로 넘어온 데이터를 파라미터 방식으로 변환시킨다.
		
		MultipartRequest multi = null;
		String sPath = req.getSession().getServletContext().getRealPath("upload");
		try {
			multi = new MultipartRequest(req, sPath,
					1024*1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
			check = 1;
			//위 작업이 완료되면 
			//byte[]이 파라미터로 변경되고
			//업로드가 왼료된다.
		}catch (Exception e) {
			System.out.println("---------- upload Error ------------");
			e.printStackTrace();
		}
		//일반 컨트롤러보다 한가지 작업을 추가해야 하는데
		//byte[] 을 파라미터로 바꾸는 작업

		/*
			파라미터를 받을 때
				*****
				스트림방식으로 전달된 데이터를 파라미터로 바꿔서 저장하고 있는데
				저장된 곳이 지금까지는 req 였지만
				파일업로드 기능의 경우는 multi 에 저장되어 있다
				따라서 파라미터는 multi 에서 꺼내야 한다.
		 */
		
		String sid = multi.getParameter("sid");
		String title = multi.getParameter("btitle");
		String body = multi.getParameter("bbody");
		
		// 데이터베이스 입력작업의 경우
		// 먼저 파일 정보테이블에 데이터가 입력된 이후 
		// 파일게시판 테이블에 정보가 입력이 되어야 하므로
		// 먼저 파일 정보 입력부터 처리한다.
		/*
			지금 파일이 업로드는 되었지만
			단순히 서버의 특정폴더에 저장한 것 뿐이고
			이 파일의 실제 어떤이름으로 저장되어 있고
			어떤 폴더에 저장되어 있는지는 전혀 알지 못한다.
			따라서 그 정보를 알아내야 하겠다.
			
			참고]
				MultipartRequest 가 가진 주요함수
					- 업로드한 파일의 정보를 알려주는 기능의 함수
					
					getFile("키값")				- 업로드된 파일의 정보를 알려준다.
					getFilesystemName("키값")	- 업로드된 파일의 실제 저장된 이름을 알려준다.
					getOriginFileName("키값")	- 업로드된 파일의 원래 이름을 알려준다.
					getFileNames()				- 업로드된 파일의 모든 이름을 알려준다.
				
		 */
		
		// multi 에 저장되어 있는 파일 정보들을 꺼내온다.
		String oriname = multi.getOriginalFileName("bfile");
		String savename = multi.getFilesystemName("bfile");
		File file = multi.getFile("bfile");
		long len = file.length();
		String savePath = "/upload";
		FileInfoVO vo = new FileInfoVO();
		vo.setOriname(oriname);
		vo.setSavename(savename);
		vo.setDir(savePath);
		vo.setLen(len);
		
		BoardDAO dao = new BoardDAO();
		int fno = dao.fileUpload(vo); // 업로드 성공하면 0초과
		
		return view;
	}

}
