package com.koitt.www.dao;

/**
 * 	이 클래스는 회원 관련 데이터베이스 처리를 위한 클래스이다.
 * 
 * @author 	김산하
 * @since	2019.11.16
 * @version	v.1.0
 * @see		DB.DBCP
 * 
 * 			작업이력
 * 				2019.11.16	-	클래스 제작 	- 담당자 : 김산하
 * 
 */

import DB.*;

import com.koitt.www.sql.*;
import com.koitt.www.vo.*;
import java.sql.*;
import java.util.ArrayList;

public class BoardDAO {	
	DBCP db = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BoardVO vo = null;
	BoardSQL bSQL = new BoardSQL();
	
	public BoardDAO() {
		db = new DBCP();
	}
	
	public ArrayList<BoardVO> getBoardList() {
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_ALL);
		stmt=db.getSTMT(con);
		ArrayList<BoardVO> lst = new ArrayList<BoardVO>();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBno(rs.getInt(1));
				vo.setBwriter(rs.getString("writer"));
				
				vo.setwDate(rs.getDate("wdate"));
				vo.setwTime(rs.getTime("wdate"));
				
				vo.setBtitle(rs.getString("title"));
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
	public int fileUpload(FileInfoVO vo) {
		int cnt=0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.ADD_FILEINFO);
		String sql2 = bSQL.getSQL(bSQL.SEL_FNO);
		pstmt=db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, vo.getOriname());
			pstmt.setString(2, vo.getSavename());
			pstmt.setString(3, vo.getDir());
			pstmt.setLong(4, vo.getLen());
			
			cnt = pstmt.executeUpdate();
			if(cnt==1) {
				db.close(pstmt);
				pstmt = db.getPSTMT(con, sql2);
				pstmt.setString(1, vo.getSavename());
				rs = pstmt.executeQuery();
				rs.next();
				cnt = rs.getInt(1);
				db.close(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	public int bWrite(String sid, String title, String body, int check) {
		int cnt=0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.ADD_CONTENT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, sid);
			pstmt.setString(2, title);
			pstmt.setString(3, body);
			if(check == 1 ) {
				pstmt.setString(4, "(SELECT NVL(MAX(F_NO) + 1 , 10001) FROM fileinfo)");
			}else {
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
}