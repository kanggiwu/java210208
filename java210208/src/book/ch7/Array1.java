package book.ch7;
/*
 * 배열은 한번 선언하면 원소의 수를 조정 불가하다.
 * 끼워넣기가 안된다.
 * 배열.length : 명사는 배열의 길이
 * "hello".length() : 동사는 문자열의 길이
 * 
 */
public class Array1 {

	public void printArray(int empnos[]) {
		int cnt = 0;
		for(int i = 0; i < empnos.length; i++) {
			System.out.println(++cnt+"번방: "+empnos[i]);
		}
	}
	public static void main(String[] args) {
		int empnos[] = new int[14];
		//14개 방에는 어떤 값이 들어 있을까 0
		Array1 a1 = new Array1();
		a1.printArray(empnos);
	}

}
