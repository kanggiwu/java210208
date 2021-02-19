package test1;
/*
 * 에러는 2가지가 있따.
 * 1. 컴파일 타임 에러 - 문법
 * 2. 런타임 에러 - 실행오류(논리오류)
 */
//만약, double 타입이 아닌 다른 타입의 값을 입력하는 경우 발생하는 에러는 어떻게 할까?
//hasNextDouble()과 같이 해당 값이 맞는 타입으로 들어왔는지 확인을 해준다.
//try-catch를 이용해서 예외값 처리를 해준다.
public class Q1_4 {
	
	public static void main(String[] args) {
		//지구의 몸무게
				double wEarth = 0.0;
				System.out.println("지구에서의 몸무게를 입력하시오");
				//시스템(내가 사용하고 있는 pc)에서 in(입력장치로부터)
				java.util.Scanner sc = new java.util.Scanner(System.in);
				try {
					wEarth = sc.nextDouble();
				} catch (Exception e) {
					System.out.println("Exception : " + e.toString());
				}
				if(sc.hasNextDouble()) {//입력한 값이 더블인가?
					wEarth = sc.nextDouble();
					double wMoon = 0.0;
					Q1_4 q4 = new Q1_4();
					Common cm = new Common();
					wMoon = cm.moonWeigth(wEarth);
					System.out.println("지구에서의 몸무게는: " + wEarth + "kg입니다.");
					System.out.println("달에서의 몸무게는: " + wMoon + "kg입니다.");
				}
				else {
					//System.out.println("실수만 입력하세요.");
					sc.close();
					return;//main메소드 탈출, 22번 아래는 진행할 필요가 없다.
				}
				System.out.println("main함수가 제대로 끝났는지 확인합니다.");
				
				sc.close();
	}

}
