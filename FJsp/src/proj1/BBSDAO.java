package proj1;
import java.sql.*;
import java.util.*;
import DB.*;
import sql.*;
import VO.*;

public class BBSDAO {
	MyJDBC db = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BBSDAO() {
		db = new MyJDBC(); 
	}
	
	public int login(String userID, String userPassword) {
		con = db.getCON();
		String sql = BBSSQL.getSQL(BBSSQL.login);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공
				}else {
					return 0; //비밀번호 오류
				}
			}
			return -1; // 아이디가 없음
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return -2; //DB오류
	}
	
	public int join(BBSVO vo) {
		con = db.getCON();
		String sql = BBSSQL.getSQL(BBSSQL.join);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPassword());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserGender());
			pstmt.setString(5, vo.getUserEmail());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return -1; //DB오류
	}
}
