package book.ch4;
//생성자 안에서 화면을 생성
	//생성자를 선언하면 인스턴스화 없이 생성자 내에서 구현한 메소드를 실행할 수 있다.
	//메소드 오버로딩 규칙을 준수한다.:다양한 경우의 수 ex) 팝업창을 용도에 따라 띄운다.
	//생성자의 역할 : 전역변수의 초기화
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

public class Game_2 {
	int ranNum = 0;
	
	int makeRanNum () {
		Random r = new Random();
		ranNum = r.nextInt(10);
		
		return ranNum;
	}
	public Game_2() {}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);//AbstractWindowToolkt - 윈도우 운영체제 화면을 가져온다 MVC패턴(화면적으로 모여줌)
		int cnt = 0;
		Game_2 g2 = new Game_2();
		int ranNum = g2.makeRanNum();
		
		System.out.println("랜덤함수 맞추기");
		System.out.println("0~9사이 수를 입력하시오.");
		for(int i = 0; i < 3;i++) {
			Scanner sc = new Scanner(System.in);
			int userNum = sc.nextInt();
			if(ranNum==userNum) {
				System.out.println("축하합니다.정답입니다.");
				break;
			}else if(ranNum<userNum) {
				cnt++;
				if (cnt==3) break;				
				System.out.println("더 낮은 수를 입력하시오.");
			}
			else {
				cnt++;
				if (cnt==3) break;
				System.out.println("더 높은 수를 입력하시오.");
				
			}
			sc.close();
		}
		if(cnt == 3) 
			System.out.println("넌 바보"+ranNum);
	}
}
