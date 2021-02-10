package variable.step1;

public class MainMethod {
	/*
	 * args - 파라미터의 타입은 배열이다.
	 * String args[] = new String[3];
	 * main메소드에서 설명할 수 있다.
	 */
	public static void main(String[] args) {
		//만일 숫자라면 20
		//만일 문자라면 1010
		//int + int = int
		//int + String = 붙여쓰기
			System.out.println(args[0]+10);
			//instanceof = 타입을 체크하는 연산자: 자바는 컴파일 시 타입을 고려한다.
			if(args[0] instanceof String) {
				System.out.println("나는 문자열이야");
			}else {
				System.out.println("나는 문자열이 아니야");	
			}
			
			if(true) {
				System.out.println("참");
			}else System.out.println("거짓");
	}
}
