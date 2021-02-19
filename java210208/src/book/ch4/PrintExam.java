package book.ch4;
import java.util.Random;
/*
 * java.util에 있는 패키지들은 제공되는 apiㄹㄹ 통해서 뭔가를 만들때 유용한 기능을 모아놓은 패키지
 * java.lang이 아닌 모든 패키지는 모두 import대싱이다.
 */
import java.util.Scanner;

public class PrintExam {

	public static void main(String[] args) {
		
		//디폴트 생성자를 지원하지 않는 클래스가 존재한다.
		//여기서 ststem이란 현재 네가 쓰고 있는 장치(device)-처리주체
		//사용자 혹은 업무 담당자가 키보드에 입력한 값을 읽어온다. 입력장치를 나타내는 속성이 필요하다 - attribute
		//in -> 입력장치를 나타내는 속성
		Scanner sc = new Scanner(System.in);//local device = 서버가 아니다. -> 동기화 불가능 -> 예전 데이터를 계쏙 가지고 있다, 새로 등록된 운동선수에 대한 정보가 없다.
		Scanner sc2 = null;
		System.out.println("당신의 나이를 입력");
		System.out.println("=============");
		System.out.println(sc.nextInt());
		//디폴트 생성자를 제공해
		Random r = new Random();//r.변수/메소드, r= 소유주, 주소번지
		int count = 1;
		int cnt = 0;
		for(int i = 0; i < 10; i=i+1) {
			int answer = r.nextInt(10);//
			System.out.println(i+1+"회차 랜덤 수 출력: "+answer);
			System.out.println(count++ +"회차 랜덤 수 출력(count): "+answer);
			System.out.println(++cnt +"회차 랜덤 수 출력(cnt): "+answer);
		}
	}

}
