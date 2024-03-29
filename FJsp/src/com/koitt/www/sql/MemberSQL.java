package com.koitt.www.sql;
/**
 * 이 클래스는 회원 정보 조회에 관련된 질의명령을 관리할 클래스
 * @author 	김산하
 * @since 	2019.11.13
 * @version v.1.0
 * @see
 * 			변경이력
 * 				2019.11.13	-	
 *
 */
public class MemberSQL {
	public final int GET_LOGIN = 1001;
	public final int SEL_MEMB_INFO = 1002;
	public final int MODIFY_MAIL = 1003;
	public final int MODIFY_TEL = 1004;
	public final int JOIN = 1005;
	public final int IDCHECK = 1006;
	
	public final int SEL_USER = 0;
	
	// 코드를 입력하고 실행하면 질의명령을 반환해주는 함수
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case GET_LOGIN:
			buff.append("SELECT m_pw FROM MEMBER WHERE m_id = ?");
			break;
		case SEL_MEMB_INFO:
			buff.append("SELECT ");
			buff.append("	m_no mno, m_id id, m_name name, ");
			buff.append("	m_mail mail, m_tel tel, m_join mdate ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	m_id = ? ");
			break;
		case MODIFY_MAIL:
			buff.append("UPDATE MEMBER SET m_mail = ? WHERE m_id = ?");
			break;
		case MODIFY_TEL:
			buff.append("UPDATE MEMBER SET m_tel = ? WHERE m_id = ?");
			break;
		case JOIN:
			buff.append("INSERT INTO member VALUES( ");
			buff.append("(SELECT NVL(MAX(M_NO) + 1 , 1001) FROM member), ");
			buff.append("?, ?, ?, ?, ?, sysdate) ");
			break;
		case IDCHECK:
			buff.append("SELECT count(*) cnt FROM member WHERE m_id = ? ");
			break;
		case SEL_USER:
			buff.append(" SELECT m_id, m_name FROM member ");
			break;
		}
		
		return buff.toString();
	}
}