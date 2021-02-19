package test1;

import java.util.Scanner;

/*
 * 1~N까지의 정수의 합계//변수가 2개 필요할 것이다.
 */
public class Q2_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = 1;//1~end까지 셀 것을 담은 변수.
		int end = 0;//1~어디까지 셀 것인지 담을 변수.
		int sum = 0;//합을 답을 변수, 0으로 초기값을 준 이유: 합을 구할 떄 영향을 주지 않기 위해서.
		System.out.println("계산하고 싶은 정수를 입력하시오.");
		end = sc.nextInt();
		for(;start<=end;start++) {
			sum +=start;

			System.out.println("더하는 과정: "+sum);
		}
		System.out.println("총합: "+sum);
		sc.close();
	}
}
