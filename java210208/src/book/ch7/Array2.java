package book.ch7;

public class Array2 {
	int x = 3;
	String names[] = null;
	String enames[] = {"SMITH","KING","WORD"};
	public static void main(String[] args) {
		Array2 a2 = new Array2();
		boolean isOk[] = new boolean[a2.x];
		for(boolean bo:isOk) {//전체를 모두 다 조회할 때 사용하는 것 CH12 컬렉션 프라임워크에서 활용된다.
			System.out.println(bo);
		}
		names = new String[a2.x];//static 안에서는 non-static을 사용할 수 없다.
		a2.names = new String[] {"이순신","강감찬","홍길동"};
	}
}
