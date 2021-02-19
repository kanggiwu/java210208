package test1;

import java.util.Scanner;

public class ThreeMul {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수를 입력하시오");
		int num1 = sc.nextInt();

		System.out.println("두번째 정수를 입력하시오");
		int num2 = sc.nextInt();
		sc.close();		
		if(num1<=num2) {
			for(i=num1;i<=num2;i++) {
				if(i%3==0) {
					j++;
					System.out.print(i+" ");
				}
			}
		}else {
			for(i=num2;i<=num1;i++) {
				if(i%3==0) {
					j++;
					System.out.print(i+" ");	
				}
			}
		}
		System.out.println();
		System.out.println("첫번째 정수와 두번째 정수 사이의 3의 배수의 개수는 : " +j);
	}
}

