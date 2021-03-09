package com.vo;

public class EmpVO {
	public DeptVO getdVO() {
		return dVO;
	}
	public void setdVO(DeptVO dVO) {
		this.dVO = dVO;
	}
	//급여명세서에 부서이름을 출력하기 위한 select문을 가지고 결졍해 보세요.
	//SELECT dname FROM dept, emp WHERE d.deptno = e.deptno;
	//여기 변수들은 모두 private으로 한다. 캡슐레이션(은닉화) 보호(위변조) => 직접 값을 변경 불가
	//각각의 값을 유지하거나 재사용하는 문제는 인스턴스화에 따라 각각 다르게 활용이 가능하다.
	/*
	 * 값을 초기화하는 방법에 대해서는 2가지가 있다.
	 * 1) setter
	 * 2) 생성자
	 * 
	 */
	
	private DeptVO dVO = null;
	private int empno = 0;//7566
	private String ename = "";//사원명
	private String job = "";//
	private int mgr = 0;//그룹코드
	private String hiredate = "";//입사일자_날짜
	private double sal = 0.0;//급여
	private double comm = 0.0;//인센티브
	private int deptno = 0;//
	//생성자의 경우 생략할 수 있고 생략되었을 때 JVM이 대신 제공해줌
	//그러나 한개라도 생성자 정의되어 있다면 제공한됨.(디폴트 생성자 포함)
	public EmpVO() {}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public EmpVO(int empno, String ename, String job, int mgr 
			, String hiredate, double sal, double comm
			, int deptno, DeptVO dVO) {
		this.empno	= empno;
		this.ename	= ename; //전변과 초기화를 작성. 외부에서도 그 값을 유지 또는 활용가능함
		this.job	= job;
		this.mgr	= mgr;
		this.hiredate = hiredate;
		this.sal 	= sal;
		this.comm 	= comm;
		this.deptno = deptno;
		this.dVO	= dVO;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}                          
