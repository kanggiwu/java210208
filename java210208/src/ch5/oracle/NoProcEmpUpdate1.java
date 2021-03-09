package ch5.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;
//프로시저 없이 DML 처리
public class NoProcEmpUpdate1 extends JFrame {
	Connection			con1 	= 	null;
	Connection			con2 	= 	null;
	Connection			con3 	= 	null;
	PreparedStatement 	pstmt1 	= 	null;
	PreparedStatement 	pstmt2 	= 	null;
	PreparedStatement 	pstmt3 	= 	null;
	ResultSet 			rs1 	= 	null;
	ResultSet 			rs2 	= 	null;//select절 사용시 사용
	String				sql1 	=	"";
	String				sql2 	=	"";
	String				sql3 	=	"";
	DBConnectionMgr 	dbMgr 	= 	null;
	public void salUpdate(int p_empno){
		String 	r_ename		=	null;
		double 	r_sal		=	0.0;
		double 	r_avg_sal	=	0.0;
		double 	v_rate		=	0.0;
		int		result		=	0;//0이면 수정 실패, 1이면 수정 성공
		sql1+= "SELECT ename, sal";//자바에서는 into를 사용할 수 없다.
		sql1+= " FROM emp";
		sql1+=" WHERE empno=?";//물음표로 치환하는게 좋다. 		
		//sql1+=" WHERE empno="+p_empno;		//변수로 놓으면 값이 치환될 떄마다 새로운 select문으로 받아들이기 때문에 ?로 놓는게 더 동적이다.
		sql2+="SELECT avg(sal) sal";//알리아스명?을 꼭 줘야한다.
		sql2+=" FROM emp";
		sql2+=" WHERE deptno = (SELECT deptno FROM emp WHERE empno=?)";
		//sql2+=" WHERE deptno = (SELECT deptno FROM emp WHERE empno"+p_empno+")";
		sql3+="UPDATE emp SET sal =? WHERE empno=?";
		//sql3+="UPDATE emp SET sal =? WHERE empno="+p_empno;
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con1	=	dbMgr.getConnetion();//드라이버 클래스를 로딩하고 연결통로를 확보
			pstmt1	=	con1.prepareStatement(sql1);//sql문 사용
			pstmt1.setInt(1, p_empno);//첫번째 ?에 파라미터를 전달
			rs1		=	pstmt1.executeQuery();//쿼리문 실행
			rs1.next();//다음 커서로 이동(맨처음의 커서의 위치는 헤더이기 때문에 한칸 뒤로 해줘야한다.
			r_ename	=	rs1.getNString("ename");//해당 변수에 해당 조건을 만족하는 테이블의 ename값을 대입
			r_sal	=	rs1.getDouble("sal");//
			System.out.println("입력받은 사원 " + r_ename + "의 급여: " + r_sal);
			dbMgr.freeConnection(con1, pstmt1, rs1);//사용한 자원을 반납
			
			con2	=	dbMgr.getConnetion();
			pstmt2	=	con2.prepareStatement(sql2);
			pstmt2.setInt(1, p_empno);
			rs2		=	pstmt2.executeQuery();
			rs2.next();
			r_avg_sal	=	rs2.getDouble("sal");
			System.out.println("부서평균 급여는 " + r_avg_sal);
			//dbMgr.freeConnection(con2, pstmt2, rs2);
			
			if(r_sal>r_avg_sal) {
				v_rate	=	1.1;
			}else {
				v_rate	=	1.2;
			}
			/*
			 * lock이 걸리면 이미 해당 부분이 선점이 되어 있기 때문에 lock이 풀릴 때가지 사용을 할 수가 없다.-> 서버를 종료해서 다시 재실행 시켜야한다.
			 * 계속해서 접근하면 이미 선점(lock)이 걸려져 있기 때문에		
			 */
			con3	=	dbMgr.getConnetion();
			pstmt3	=	con3.prepareStatement(sql3);
			pstmt3.setDouble(1, r_sal*v_rate);
			pstmt3.setInt(2, p_empno);
			result = pstmt3.executeUpdate();
			System.out.println("result: "+result);
			if(result == 1) {
				JOptionPane.showMessageDialog(this,"수정이 되었습니다.");
			}else {
				JOptionPane.showMessageDialog(this,"실패하였습니다.");
			}
		} catch (SQLException se) {
			System.err.println("[[sql1]] "+sql1);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	public static void main(String[] args) {
		NoProcEmpUpdate1 neu1 = new NoProcEmpUpdate1();
		String	user_input = JOptionPane.showInputDialog("사원의 번호를 입력하세요");
		int empno = 0;
		if(user_input !=null||user_input.length()>1) {
			empno	=	Integer.parseInt(user_input);
		}
		neu1.salUpdate(empno);
	}

}
