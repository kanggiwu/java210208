package com.quiz0222;
class Q36_1{
	void methodC() {
	//	methodB(); //소유주를 알 수 없어서 안된다!
		Q36.methodB();//클래스명.전역변수로 선언된 메소드
		Q36 q36 = new Q36();
		q36.methodB();
	}
}
/*	non-static과 static의 차이
 * 
 *	non-static 영역에서 static 타입은 접근 가능
 *
 * 
 * 
 * 	static 영역에서 non-static영역은 접근 불가능
 */
public class Q36 {
	private int cnt = 0;
	public Q36() {
		cnt++;//non-static
	}
	public static int getINstanceCount() {
		return cnt;
	}
	static {
		System.out.println("static block");
	}
	void methodA() {
		System.out.println(" methodA 호출");
		methodB();//non-static에서 static를 불러올 수 있다.
	}
	static void methodB() {
		System.out.println(" methodB 호출");
	//	methodA();//static에서 non-static를 불러올 수 없다.
	}
	
	//메인메소드도 static이다.
	//main thread라고 한다. 우선순위가 가장 높다. -> static 블럭의 우선순위가 더 높다.
	//java script는 single thread이다.

	public static void main(String[] args) {
		System.out.println("static block");
		methodB();
		Q36 a = new Q36();
		Q36 a1 = new Q36();
		Q36 a2 = new Q36();
		System.out.println(Q36.getInstanceCount());//compilation fails because of an error on line 28 
		//cnt가 static가 아닌게 문제다.
		
	}

}
