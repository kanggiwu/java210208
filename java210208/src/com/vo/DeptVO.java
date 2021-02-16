package com.vo;
//오라클과 자바 연결
//VO패턴 - 데이터의 영속성을 유지해주는 오라클 서버 제품과 연결하기 위한 목적
//DATA관리 목적 클래스 -해당되는 모든 집합의 접미사로 VO를 붙임.
//메인메소드는 필요가 없다. 단독으로 실행하지 않는다.
/*
 * Number(2자) -정수형, 담을 수 있는 최대 크기: 99(임계값)-int(4B), long(8B)으로 정의
 * varchar2(4000자) - String
 * VO패턴을 사용하면 한번에 3가지 종류[부서번호, 부서명, 지역]의 값을 관리 가능
 */

public class DeptVO {	
		private int deptno = 0; //원시형 타입- 값출력(4B) 229540 229544 ...
		private String dname = null;//레퍼런스 타입(class)- 주소번지출력, 레퍼런스타입인데 값이 출력되는 예외
		private String loc = null;
		//getter메소드 - Read
		
		public DeptVO() {}
		public DeptVO(int deptno) {
			this.deptno = deptno;
		}
		
		public int getDeptno() {
			return deptno;
		}
		//setter메소드 - Write, Save
		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}
		public String getDname() {
			return dname;
		}
		public void setDname(String dname) {
			this.dname = dname;
		}
		public String getLoc() {
			return loc;
		}
		public void setLoc(String loc) {
			this.loc = loc;
		}

}
