package com.ocjp;
class Param {
	int ival;
}
public class TestParam {
	void effectParam(Param p) {
		p = new Param();//해당 줄은 새로운 객체가 이 메소드 안에서 생성되었기 때문에,새로 생성된 객체의 값이 바뀌었고 이 객체는 해당 메소드를 빠져나가면 사라지기 때문에, 메인메소드에서 100을 출력할 것 같다. main: 100 sub: 500
		p.ival = 500;	//8번째 줄이 없는 경우는 파라미터로 해당 객체의 전역변수에 접근했기 때문에 500을 출력할 거 같다.	main: 500 sub: 500
		System.out.println("sub ival= " + p.ival);
	}
	public static void main(String[] args) {
		//클래스는 반드시 대문자
		TestParam tp = new TestParam();
		Param p = new Param();
		p.ival = 100;
		tp.effectParam(p);
		System.out.println("main ival= " + p.ival);
	}
}
