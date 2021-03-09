package book.ch5;

public class ParammeterTest {
	String g_rdname = null;
	static int methodA() {
		return 100;
	}
	static int methodA(int p_empno) {
		return 100;
	}
	void methodA(int p_empno, String rdname) {
		g_rdname = rdname;
	}
	public static void main(String[] args) {
	//	int x = ParammeterTest.methodA();
		int x = ParammeterTest.methodA(7566);
		//int x2 = methodA(7566);
		System.out.println(x);
		String rdname = "개발2팀";
		ParammeterTest pt = new ParammeterTest();
		pt.methodA(7566, rdname);
		//여기는 메소드를 경유하지 않고 출력, null이 나옴
		System.out.println(new ParammeterTest().g_rdname);
		//여기서는 전역변수의 값 출력
		//21번 줄 methodA를 경유 시 새로운 값으로 초기화 되기 때문
		System.out.println(pt.g_rdname);
	}

}
