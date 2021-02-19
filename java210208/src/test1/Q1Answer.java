package test1;
import java.util.Scanner;

public class Q1Answer {
	
		public static void main(String[] args) {
			double e_weight = 0.0;
			double m_weight = 0.0;
			
			System.out.println("지구에서의 몸무게를 입력하세요");
			Scanner sc = new Scanner(System.in);
			e_weight = sc.nextDouble();
			
			Q1 q1 = new Q1(e_weight);
			
			m_weight = q1.getM_weight();
			System.out.println("지구 몸무게====>"+e_weight+"kg, 달 몸무게====>" + m_weight+"kg");
			sc.close();
		}
}