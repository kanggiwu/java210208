package test1;

import java.util.Scanner;

public class ThreeMul2_and_Sequence2_main {

	public static void main(String[] args) {
		ThreeMul_2 tm2 = new ThreeMul_2();
		System.out.println("2개의 수를 입력받고 두 수 사이의 3의 배수의 개수를 구하자.");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 수를 입력하시오.");
		int firstNum = sc.nextInt();
		System.out.println("두번째 수를 입력하시오.");
		int secondNum = sc.nextInt();
		
		int count = tm2.threeMulNum(firstNum, secondNum);
		System.out.println(firstNum+"과 " + secondNum+"사이의 3의 배수의 개수는: "+count+"개이다.");


		System.out.println("첫항부터 7번재 항까지의 등비수욜을 구하자");
		System.out.println("첫항을 입력하세요");
		int a = sc.nextInt();
		
		System.out.println("공비를 입력하세요");
		int r = sc.nextInt();
		
		Sequence2 s2 = new Sequence2();
		//s2.returnSequence(a, r);
		s2.returnSeqArr(a, r, 7);
		
		sc.close();
	}

}
