package book.ch5;

public class PrideSimulation {

	public static void main(String[] args) {
/*
 * private으로 안했을 경우 인캡슐레이션이 적용되는 것이다
 * 생성자를 선언할 때 private으로 선언했으므로 디폴트 생성자를 활용하고 싶다면 싱글톤패턴으로 정의하여 사용해야 한다.
 * pride myCar = new Pride();
 */
		Pride herCar = new Pride(10);
		Pride himCar = new Pride(100,40);
		himCar.wheelNum = 4;
		herCar.wheelNum = 14;
		Pride.wheelNum = 5;//전역변수로 선언한 변수는 이렇게 접근하자!!!!!!!
		himCar.speed = 10;
		herCar.speed = 50;
		System.out.println("himCar.wheelNum : "+himCar.wheelNum);
		System.out.println("himCar.wheelNum : "+herCar.wheelNum);
		//클래스변수를 사용할 떄는 아래처럼 클래스를 통해 전역변수에 접근하자!!!
		System.out.println("himCar.wheelNum : "+Pride.wheelNum);
		System.out.println("himCar.wheelNum : "+himCar.speed);
		System.out.println("himCar.wheelNum : "+herCar.speed);
		

	}

}
