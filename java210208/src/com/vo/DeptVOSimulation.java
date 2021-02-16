package com.vo;

public class DeptVOSimulation {
	
	void methodB(){}//반환값 역할x
	DeptVO methodA() {
		return new DeptVO();//반환값이 3가지 가능
	}
	DeptVO[] methodC() {
		return new DeptVO[3];//반환값이 3가지 종류에 대해서 n개 로우까지도 가능
	}
	
	

	public static void main(String[] args) {
		DeptVO dvo = new DeptVO(30);//deptNo에 값을 설정해주는 생성자를 이용해서 객체 생성
		int myDeptNo = dvo.getDeptno();//
		/*insert here - 부서번호 30을 출력
		 * dvo.setDeptno(30);//setDeptno함수를 사용해서 dvo객체 변수 값 변경
		*/
		System.out.println(myDeptNo);
		String myDname = dvo.getDname();//null
		String myLoc = dvo.getLoc();//null
		
		dvo = new DeptVO(3000);//orcle에서 데이터타입이 Number(2)이기 떄문에 99까지만 가능!(※주의: 오라클도 신경 써야함)
		myDeptNo = dvo.getDeptno();
		System.out.println(myDeptNo);
	}

}
