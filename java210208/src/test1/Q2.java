package test1;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		System.out.println("1부터 입력받은 정수의 값까지 더한 값을 출력합니다.");
		System.out.println("값을 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		int end = sc.nextInt();
		int sum=0;
		for(int i = 1; i<=end;i++) {
			sum +=i;
		}
		System.out.println(sum);
		sc.close();
		
	}

}
