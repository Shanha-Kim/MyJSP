package com.koitt.www.dao;

/**
 * 	이 클래스는 회원 관련 데이터베이스 처리를 위한 클래스이다.
 * 
 * @author 	김산하
 * @since	2019.11.13
 * @version	v.1.0
 * @see		DB.DBCP
 * 
 * 			작업이력
 * 				2019.11.13	-	클래스 제작 	- 담당자 : 김산하
 * 
 */

import DB.*;
import sql.BBSSQL;

import com.koitt.www.sql.*;
import com.koitt.www.vo.*;
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {	
	DBCP db = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MemberVO vo = null;
	MemberSQL mSQL = new MemberSQL();
	
	public MemberDAO() {
		db = new DBCP();
	}
	
	// 로그인 처리 전담 함수
	public int login(String sid, String spw) {
		int cnt = -2;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.GET_LOGIN);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("m_pw").equals(spw)) {
					cnt = 1; //로그인 성공
					System.out.println("로그인성공");
				}else {
					cnt = 0; //비밀번호 오류
					System.out.println("비밀번호오류");
				}
			}else {
				System.out.println("*******************");
				cnt =  -1; // 아이디가 없음	
				System.out.println("없는 아이디");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		System.out.println("DB오류");
		return cnt; //DB오류
	}
	// 아이디체크 전담 처리함수
//		public int getIdCnt(String sid) {
//			int cnt = 0 ;
//			// 커넥션 얻어오고
//			con = db.getCon();
//			// 질의 명령 가져오고
//			mSQL = new MemberSQL();
//			String sql = mSQL.getSQL(mSQL.SEL_ID_CK);
//			// PreparedStatement 가져오고
//			pstmt = db.getPSTMT(con, sql);
//			
//			try {
//				// 질의명령 완성하고
//				pstmt.setString(1, sid);
//				// 질의명령 보내고 결과 받고
//				rs = pstmt.executeQuery();
//				// 데이터 꺼내고
//				rs.next();
//				cnt = rs.getInt("cnt");
//			} catch(Exception e) {
//				e.printStackTrace();
//			} finally {
//				db.close(rs);
//				db.close(pstmt);
//				db.close(con);
//			}
//			
//			return cnt;
//		}
		public MemberVO getMemberInfo(String sid) {
			vo = new MemberVO();
			//할일
			con = db.getCon();
			String sql = mSQL.getSQL(mSQL.SEL_MEMB_INFO);
			pstmt = db.getPSTMT(con, sql);
			
			try {
				pstmt.setString(1, sid); 
				rs = pstmt.executeQuery();
				rs.next();
				vo.setM_no(rs.getString("mno"));
				vo.setM_id(rs.getString("id"));
				vo.setM_name(rs.getString("name"));
				vo.setM_email(rs.getString("mail"));
				vo.setM_tel(rs.getString("tel"));
				vo.setJoinDate(rs.getDate("mdate"));
				vo.setJoinTime(rs.getTime("mdate"));
				vo.setsDate();
				vo.setsTime();
				
			}catch (Exception e) {

			}finally {
				try {
					db.close(rs);
					db.close(pstmt);
					db.close(con);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return vo;
		}
		
		
		public ArrayList<MemberVO> getUser() {
			con = db.getCon();
			String sql = mSQL.getSQL(mSQL.SEL_USER);
			stmt = db.getSTMT(con);
			ArrayList<MemberVO> lst = new ArrayList<MemberVO>();
			try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					vo = new MemberVO();
					vo.setM_id(rs.getString("m_id"));
					vo.setM_name(rs.getString("m_name"));
					lst.add(vo);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				db.close(rs);
				db.close(stmt);
				db.close(con);
			}
			
			return lst;
		}
		
		

}