package com.koitt.www.sql;
/**
 * 이 클래스는 게시판 정보조회 및 수정에 관련된 질의명령을 관리할 클래스
 * @author 	김산하
 * @since 	2019.11.16
 * @version v.1.0
 * @see
 * 			변경이력
 * 				2019.11.16	- 담장자 : 김산하	
 *
 */
public class BoardSQL {
	public final int SEL_ALL = 1001;
	
	public final int DEL_CONTENT = 2001;
	public final int EDIT_CONTENT = 2002;
	
	public final int ADD_CONTENT = 3001;
	public final int ADD_FILEINFO = 3002;
	
	public final int SEL_FNO = 5001;

	// 코드를 입력하고 실행하면 질의명령을 반환해주는 함수
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_ALL:
			buff.append("SELECT ");
			buff.append("	fb_no bno, ");
			buff.append("	(SELECT m_id FROM member WHERE m_no = fb_writer) writer, ");
			buff.append("	fb_wdate wdate, fb_title title ");
			buff.append("FROM ");
			buff.append("	fileboard ");
			buff.append("WHERE ");
			buff.append("	fb_isshow = 'Y' ");
			break;
		case DEL_CONTENT:
			buff.append("SELECT ");
			buff.append("	m_no mno, m_id id, m_name name, ");
			buff.append("	m_mail mail, m_tel tel, m_join mdate ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	m_id = ? ");
			break;
		case EDIT_CONTENT:
			buff.append("UPDATE MEMBER SET m_mail = ? WHERE m_id = ?");
			break;
		case ADD_CONTENT:
			buff.append("INSERT INTO fileboard(fb_no, fb_writer, fb_title, fb_body, fb_fno)  ");
			buff.append("values((SELECT NVL(MAX(FB_NO) + 1 , 10001) FROM fileboard), ");
			buff.append("(SELECT m_no FROM member WHERE m_id = ?),?,?,?) ");
			break;
		case ADD_FILEINFO:
			buff.append("INSERT INTO fileinfo(f_no, f_oname, f_sname, f_dir, f_len) ");
			buff.append("VALUES((SELECT NVL(MAX(F_NO) + 1 , 10001) FROM fileinfo),  ");
			buff.append("?,?,?,? ");
			break;
		case SEL_FNO:
			buff.append("SELECT f_no fno FROM fileinfo WHERE f_sname = ?");
		}
		
		return buff.toString();
	}
}