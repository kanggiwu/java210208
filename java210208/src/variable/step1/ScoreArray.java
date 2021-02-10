package variable.step1;

import java.util.Scanner;

public class ScoreArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("학생수를 입력하시오");
		int n = sc.nextInt();
		Account[] a = new Account[n];// 객체배열 초기화
		
		for(int i = 0; i<n;i++) {
			
			System.out.println(i+1+"번째 학생의 점수를 입력합니다.");
			a[i]=new Account();//객체배열 인스턴스화
			System.out.println("국어점수를 입력하세요");
			double kor = sc.nextDouble();

			System.out.println("수학점수를 입력하세요");
			double math = sc.nextDouble();
			
			System.out.println("영어점수를 입력하세요");
			double eng = sc.nextDouble();
			a[i].setVar(kor, math, eng);
			a[i].setTot();	
			a[i].setavg(n);			
		}
		for(int i = 0; i<n;i++) {
			System.out.println(i+1+"번째 학생의 평균은===>"+a[i].printAvg()+"점입니다.");
		}	
		
	}

}
