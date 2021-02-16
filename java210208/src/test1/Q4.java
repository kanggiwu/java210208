package test1;

public class Q4 {

	public static void main(String[] args) {
		int x = 5;
		Q4 q = new Q4();
		q.doStuff(x);
		System.out.println("main x = " + x);
		
		
	}

	private void doStuff(int x) {
		System.out.println("doStuff x = " + x++);//해당되는 x는 파라미터 x변수이기 때문에 지역변수이다. 해당 메소드를 나가면 사라진다.?
	}
}
