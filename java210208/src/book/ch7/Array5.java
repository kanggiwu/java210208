package book.ch7;

public class Array5 {
	void methodB(boolean isOk[]) {
		System.out.println(isOk[3]);
		//선언만- 초기화가 안된ㅁ =>방크기가 결정되지 않았다. isOk, length:NullpointException
	}
	public static void main(String[] args) {
		boolean isOK[] = null;
		Array5 a5 = new Array5();
		
	}

}
/*
 * 변수는 한번에 하나의 값만 담는다
 * 배열은 한번에 여러개 담을 수 있다
 * 그러나 다른 타입은 담을 수 없다 -> 객체 배열, ArrayList
 * 끼어넣기, 크기 조절 불가능 -> ArrayList로 해결
 * 
 * 자료구조(List계열, Map계열, set게열) - 늘었다 줄었다 한다. 끼워넣기 가능
 * FIFO
 * LIFO
 * LILO
 * 
 * 세션과 쿠키
 * 
 * 오라클서버 -영원하다
*/