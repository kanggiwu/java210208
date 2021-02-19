package book.ch4;

import java.util.Scanner;

public class Game_3_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game_3 g3 = new Game_3();
		int ranNum = g3.makeRanNum();
		int userNum = 0;
		int i = 0;

		System.out.println("0~9까지의 답을 입력하시오.");
		
		for(i=0; i < 3;i++) {
			userNum = sc.nextInt();
			if(userNum == ranNum) {
				System.out.println("축하합니다. 정답입니다.");
				break;
			}else if(userNum < ranNum){
				if(i==2) break;
				System.out.println("더 큰 수를 입력하시오");
			}else {
				if(i==2) break;
				System.out.println("더 작은 수를 입력하시오");
			}
		}
		if(i==2) System.out.println("넌 바보, 정답은 "+ranNum);
	
		sc.close();
	}

}
