package test1;

public class Q4_1 {
/*
 * 실행순서는 7-8(x=5), 9(주소번지생김), 10(메소드 호출, 파라미터로 5가 복사됨), 15(후위연산자 x=5)
 * 16(15에서 파라미터로 5가 먼저출력) 17(증감연산자가 적용된 6이 출력)
 */
	public static void main(String[] args) {
		int x = 5;
		Q4_1 q4 = new Q4_1();
		q4.doStuff(x);
		System.out.println("main x = " + x);
	}

	private void doStuff(int x) {
		System.out.println("doStuff x = " + x++);
		System.out.println("doStuff x = " + x);
	}

}
