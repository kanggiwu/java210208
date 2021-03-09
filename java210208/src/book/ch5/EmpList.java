package book.ch5;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class EmpList {
	/****************************************************************
	 * @param empno - 사원번호
	 * @return String[] - 사원이름, 부서명
	 */
	public String[] getEmpDetail(int empno) {
		String[] info = new String[2];//사원이름과 부서명을 넣을 배열 생성
		EmpVO eVO = new EmpVO();//사원테이블 객체 생성
		eVO.setEmpno(7566);//사원테이블의 사원번호 set
		int deptno = eVO.getDeptno();//사원테이블의 부서번호를 변수에 대입
		String ename = eVO.getEname();//사원의 이름을 변수에 대입
		info[0]=ename;//배열에 사원이름 넣기
		DeptVO dVO = new DeptVO();//부서테이블 객체 생성
		dVO.setDeptno(deptno);//사원의 부서번호로 부서테이블의 부서번호를 set
		String dname = dVO.getDname();//부서테이블에서 부서이름을 변수에 대입
		info[1] = dname;//부서이름을 배열에 대입
		return info;//사원이름과 부서명을 가진 배열을 return
	}
	public static void main(String[] args) {
		
		
		
	}

}
