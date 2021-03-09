package ch5.oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnectionMgr;
import com.vo.EmpVO;

/*
 * 물리적으로 떨어져 있는 192.168.0.24번 서버에 접속하려고 한다.
 * 서버 컴퓨터의 오라클 제품에 접속하려면 해당 회사가 제공하는 드라이버 클래스가 있어야 한다.
 * 따라서 우리는 ojdbc6.jar를 주입 받을 수 있오록 등록하였다.
 */
public class JdbcTest2 {
	//선언부
	//물리적으로 떨어져 있는 서버에 연결통로 만들기
	Connection			con		= null; 
	//자바에서 sql을 사용할 수 있도록 모아놓음
	//24번 서버에 내가 작성한 select문을 전달해줄 객체 선언
	PreparedStatement	pstmt	= null;
	//오라클의 커서를 조작하는 객체 선언
	ResultSet			rs		= null;
	DBConnectionMgr		dbMgr	= null;
	//생성자
	public JdbcTest2(){
			String sql = "SELECT empno, ename, sal FROM emp";
			dbMgr = DBConnectionMgr.getInstance();
			try{
				con = dbMgr.getConnection();
				pstmt = con.prepareCall(sql);
				//오라클에 살고 있는 커서 조작 위해서 자바가 제공하는 객체 생성
				rs = pstmt.executeQuery();
				EmpVO eVO = null;
				//rs.next();를 한 횟수만큼 뒤에 있는 row에 접근할것이다!
				while(rs.next()) {//rs.next()의 경우 테이블 내 데이터가 있으면 True, 없으면 false
					eVO = new EmpVO();
					//******EmpVO캡슐화*********setter를 이용해서 VO클래스의 값을 갱신
					//db에서 받아온 데이터를 자바 내 VO 클래스에 넣어준다.->자바에서 이 데이터들을 가지고 처리를 한다.
					eVO.setEmpno(rs.getInt("empno"));
					eVO.setEname(rs.getString("ename"));
					eVO.setSal(rs.getDouble("sal"));
					System.out.println(eVO.getEmpno()+"," + eVO.getEname() + "," + eVO.getSal());
				}
			}catch(SQLException se) {//오라클에서 발생되는 에러를 자바에서 잡아준다.
				/*부적합한 식별자 입니다. ex) select dname FROM emp 테이블 내 없는 속성에 접근
				 * select deptno FROM emp5 없는 테이블에 접근 오라클에서 다음과 같은 에러 발생
				 * ORA-00942: 테이블 또는 뷰가 존재하지 않습니다.
				 */
				System.out.println("SQLException:"+se.getMessage());//좀 더 구체적인 예외처리 클래스 정보를 알 수 있다.
			}
			System.out.println("요기");
	}
	
	//오라클 서버 접속
	public static void main(String[] args) {
		JdbcTest2 jt = new JdbcTest2();
	}

}
