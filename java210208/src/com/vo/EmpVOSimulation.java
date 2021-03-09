package com.vo;

public class EmpVOSimulation {

	public static void main(String[] args) {
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(30);
		dVO.setDname("리서치");
		dVO.setLoc("부산");
		EmpVO evo = new EmpVO(7566,"이순신","세일즈"
				,7800,"2000-10-26",1000
				,200,30,null);
		
		System.out.println(evo.getdVO().getDname());
		System.out.println(dVO.getDname());
		dVO = new DeptVO(40,"ACCOUNTING","인천");
		dVO.setDeptno(40);
		dVO.setDname("개발부");
		dVO.setLoc("제주");
		System.out.println(evo.getdVO().getDname());//해당 사원 VO에 있는 dVO를 연결해서 부서이름 불러오기
		System.out.println(dVO.getDname());
	}

}
