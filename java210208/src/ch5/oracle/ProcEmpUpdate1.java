package ch5.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;
//프로시저를 이용
public class ProcEmpUpdate1 extends JFrame {
	Connection			con1 	= 	null;
	CallableStatement 	cstmt 	= 	null;
	DBConnectionMgr 	dbMgr 	= 	null;
	

	public void salUpdate(int p_empno){
		int		result		=	0;//0이면 수정 실패, 1이면 수정 성공
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con1	=	dbMgr.getConnetion();//드라이버 클래스를 로딩하고 연결통로를 확보
			cstmt	=	con1.prepareCall("{call proc_emp_update1(?,?)}");//프로시저 이름을 불러온다. 이 프로시저를 쓴다는 뜻
			cstmt.setInt(1, p_empno);//불러온 프로시저에 첫번째 ?에 파라미터를 전달
			cstmt.registerOutParameter(2, java.sql.Types.NVARCHAR);//파라미터로 리턴값을 받아오는 것이다.
			result = cstmt.executeUpdate();
			String msg = cstmt.getString(2);
			System.out.println("result: "+result);
			if(result == 1) {
				JOptionPane.showMessageDialog(this,"수정이 되었습니다.");
			}else {
				JOptionPane.showMessageDialog(this,"실패하였습니다.");
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	public void salUpdate2(int p_deptno){
		int		result		=	0;//0이면 수정 실패, 1이면 수정 성공
		dbMgr = DBConnectionMgr.getInstance();
		/***************************************************************
		 * proc_emp_update1 프로시저 호출테스트
		 * @param p_empno 사원 번호를 입력받아서 단일 레코드 처리 실습
		 * @result	프로시저 처리 결과를 int값으로 학인
		 * ************************************************************/
		try {
			con1	=	dbMgr.getConnetion();//드라이버 클래스를 로딩하고 연결통로를 확보
			cstmt	=	con1.prepareCall("{call proc_emp_update2(?)}");//프로시저이름을 요청
			cstmt.setInt(1, p_deptno);//첫번째 ?에 파라미터를 전달
			result = cstmt.executeUpdate();
			System.out.println("result: "+result);
			if(result == 1) {
				JOptionPane.showMessageDialog(this,"수정이 되었습니다.");
			}else {
				JOptionPane.showMessageDialog(this,"실패하였습니다.");
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	public static void main(String[] args) {
		ProcEmpUpdate1 neu1 = new ProcEmpUpdate1();
		String	user_input = JOptionPane.showInputDialog("사원의 번호를 입력하세요");
		int empno = 0;
		if(user_input !=null||user_input.length()>1) {
			empno	=	Integer.parseInt(user_input);
		}
		neu1.salUpdate(empno);
		String	user_input2 = JOptionPane.showInputDialog("부서의 번호를 입력하세요");
		int deptno = 0;
		if(user_input2 !=null||user_input2.length()>1) {
			deptno	=	Integer.parseInt(user_input2);
		}
		neu1.salUpdate(deptno);
	}

}
