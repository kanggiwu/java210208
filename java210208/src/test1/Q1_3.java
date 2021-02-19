package test1;

class Common{
	public double moonWeigth(double wEarth) {
		//달에서의 몸무게
		double wMoon = 0.0;
		wMoon = (wEarth*17)/100;
		return wMoon;
	}
}


public class Q1_3 {
	public static void main(String[] args) {
		//지구의 몸무게
		double wEarth = 0.0;
		System.out.println("지구에서의 몸무게를 입력하시오");
		//시스템(내가 사용하고 있는 pc)에서 in(입력장치로부터)
		java.util.Scanner sc = new java.util.Scanner(System.in);
		wEarth = sc.nextDouble();
		Q1_3 q1_1 = new Q1_3();
		Common cm = new Common();
		double wMoon = cm.moonWeigth(wEarth);
		System.out.println("지구에서의 몸무게는: " + wEarth + "kg입니다.");
		System.out.println("달에서의 몸무게는: " + wMoon + "kg입니다.");
		
		sc.close();
	}
}
