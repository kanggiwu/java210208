package test1;

import java.util.Scanner;

public class Sequence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫항을 입력하시오");
		int a = sc.nextInt();
		System.out.println("공비를 입력하시오");
		int r = sc.nextInt();
		int seq = 0;
		for(int i = 0; i<7;i++) {
			if(i == 0) {
				seq = a;
				System.out.println(i+1+"번째 등비수열===>"+a+"*"+r+"^"+i+" = "+seq);
			}
			else {
				seq *=r;
				System.out.println(i+1+"번째 등비수열===>"+a+"*"+r+"^"+i+" = "+seq);
			}
		}
		sc.close();
	}

}
