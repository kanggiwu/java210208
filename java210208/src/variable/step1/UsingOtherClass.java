package variable.step1;

import java.util.Scanner;

public class UsingOtherClass {

	
	public static void main(String[] args) {
		
		SumScore ss = new SumScore();
		AvgScore as = new AvgScore();
		
		Scanner sc = new Scanner(System.in);

		System.out.println("===============점수를 입력받고 평균을 구하는 프로그램=============");
		System.out.println("Score,SumScore,AvgScore 클래스를 이용");

		System.out.println("국어점수 입력");
		double kor = sc.nextInt();

		System.out.println("수학점수 입력");
		double math = sc.nextInt();

		System.out.println("영어점수 입력");
		double eng = sc.nextInt();
		Score s = new Score(kor,math,eng);
		
		System.out.println("입력한 점수의 평균======>"+as.avgScroe(ss.sumScore(s.kor,s.math,s.eng), 3));
	}

}
