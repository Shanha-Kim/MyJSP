package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class UserDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "Shanha";
			String pw = "rlatksgk1";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
		}catch (Exception e) { 
			e.printStackTrace();
		}
	}
	public int login(String userID, String userPassword) {
		String sql = "Select userPassword FROM USER WHERE userID = ?";
		try {
			pstmt = con.prepareStatement(sql);
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
		}
		return -2; //DB오류
	}
	
}
