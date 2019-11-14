package com.koitt.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	(인터페이스에서 변수는 자동으로 public static final, 함수는 public abstract, 일반함수가 오는경우 default) 
 * 	이 인터페이스는 .cls로 오는 요청을 처리할 클래스들의 기준이 되는 인터페이스이다.
 *  객체지향 이론에 따라서
 *  이 인터페이스에 작성된 함수는 클래스에서 구현할 경우 반드시 오버라이드 해야될 것이고
 *  함수 실행은 구현한 클래스의 오버라이드된 함수를 실행을 할 것이다.
 *  
 *  
 * @author user
 *
 */

public interface MainController {
	String execute(HttpServletRequest req, HttpServletResponse resp);
	/*
	 	이 항수를 .cls로 요청이 왔을 경우 실행해줘야 할 함수
	 	요청마다 처리해야할 내용이 다르기때문에
	 	
	 */
}
