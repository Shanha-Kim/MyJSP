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
		return cnt;
	}
	 //아이디체크 전담 처리함수
		public int idCheck(String sid) {
			int cnt = 0 ;
			con = db.getCon();
			String sql = mSQL.getSQL(mSQL.IDCHECK);
			pstmt = db.getPSTMT(con, sql);
			try {
				pstmt.setString(1, sid);
				rs = pstmt.executeQuery();
				rs.next();
				cnt = rs.getInt("cnt");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			
			return cnt;
		}
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
		public int join(MemberVO vo) {
			con = db.getCon();
			String sql = mSQL.getSQL(mSQL.JOIN);
			pstmt = db.getPSTMT(con, sql);
			try {
				pstmt.setString(1, vo.getM_id());
				pstmt.setString(2, vo.getM_pw());
				pstmt.setString(3, vo.getM_name());
				pstmt.setString(4, vo.getM_email());
				pstmt.setString(5, vo.getM_tel());
				return pstmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					db.close(pstmt);
					db.close(con);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return -1;
		}
		public int modify(String sid, String target, String check) {
			int a = 0 ;
			con = db.getCon();
			String sql = null;
			if(check.equals("1")) {
				sql = mSQL.getSQL(mSQL.MODIFY_MAIL);
			}else {
				sql = mSQL.getSQL(mSQL.MODIFY_TEL);
			}
			System.out.println(sql);
			pstmt = db.getPSTMT(con, sql);
			try {
				pstmt.setString(1, target);
				pstmt.setString(2, sid);
				System.out.println(target);
				System.out.println(sid);
				a = pstmt.executeUpdate();
				System.out.println(a);
				return a;
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				db.close(pstmt);
				db.close(con);
			}
			return -1; //DB오류
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