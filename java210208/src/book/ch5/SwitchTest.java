package book.ch5;

public class SwitchTest {
/*
 * [오늘 주신 문제]
1~100까지 숫자를 출력하되, 5의 배수는 buzz, 7의 배수는 fizz, 5와 7의 공배수는 fizzbuzz 를 출력하세요
 */
	public static void main(String[] args) {
		for(int i = 1; i<=100;i++) {
			switch (i%5) {
			case 0:
				if(i%7==0) {
					System.out.println("fizzbuzz");
					break;
				}
				System.out.println("buzz");
				break;
			}	
			if(i%5!=0) {
				switch(i%7) {
					case 0:
						System.out.println("fizz");
						break;
					default:
						System.out.println(i);
				}
			}
		}
	}
}
