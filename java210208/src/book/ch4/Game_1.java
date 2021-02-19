package book.ch4;

import java.util.Random;
import java.util.Scanner;

public class Game_1 {

	public static void main(String[] args) {
		Random r = new Random();

		int ranNum = r.nextInt(10);
		int cnt = 0;
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
		}
		if(cnt == 3) 
			System.out.println("넌 바보"+ranNum);
		
	}

}
