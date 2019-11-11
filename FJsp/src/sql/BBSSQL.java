package sql;

public class BBSSQL {
	public static final int login = 1001;
	public static final int join = 1002;
	public static final int SEL_ENAME = 1003;
	public static final int SEL_DNO = 1004;
	public static final int SEL_ALL = 1005;
	
	// 코드를 입력하면 질의명령을 반환해주는 함수
	public static String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case login:
			buff.append("Select userPassword FROM member WHERE userID = ?");
			break;
		case join:
			buff.append("INSERT INTO MEMBER VALUES(?,?,?,?,?)");
			break;
		case SEL_ENAME:
			buff.append("SELECT ");
			buff.append("	empno eno, ename, job, mgr, hiredate, sal, comm, deptno dno ");
			buff.append("FROM ");
			buff.append("	emp ");
			buff.append("WHERE ");
			buff.append("	ename = ?");
			break;
		case SEL_DNO:
			buff.append("SELECT ");
			buff.append("	empno eno, ename, job, mgr, hiredate, sal, comm, deptno dno ");
			buff.append("FROM ");
			buff.append("	emp ");
			buff.append("WHERE ");
			buff.append("	deptno = ?");
			break;
		}
		
		return buff.toString();
	}
}