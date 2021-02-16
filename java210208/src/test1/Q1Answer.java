package test1;
import java.util.Scanner;

public class Q1Answer {
	
		public static void main(String[] args) {
			
			System.out.println("몸무게를 입력하세요");
			Scanner sc = new Scanner(System.in);
			double e_weight = sc.nextDouble();
			Question1 q1 = new Question1(e_weight);
			double m_weight = q1.getM_weight();
			System.out.println("지구 몸무게====>"+e_weight+"kg, 달 몸무게====>" + m_weight+"kg");
			sc.close();
		}
}