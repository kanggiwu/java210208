package ch5.oracle;

import java.sql.Connection;

import com.util.DBConnectionMgr;

public class DBConTest {
	public static void main(String[] args) {
		DBConnectionMgr	dbMgr = DBConnectionMgr.getInstance();//해당 객체가 없을 때만 (null일때) 객체를 생성
		Connection	con	=	null;
		try {
			con	=	dbMgr.getConnection();
		} catch (Exception e) {
			System.out.println("Exception: "+e.toString());
		}
		System.out.println("con: "+con);
		
	}
}
