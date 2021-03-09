package ch5.singleton;

public class Testing {

	public static void main(String[] args) {
		Singleton1_1 s1 = new Singleton1_1();
		System.out.println("s1:"+s1);
		s1 = null;//Candidate상태로 빠진다. 
		s1 = new Singleton1_1();
		System.out.println("s1:"+s1);
		s1 = null;//Candidate상태로 빠진다. 
		s1 = new Singleton1_1();
		System.out.println("s1:"+s1);
		Singleton1_1 uniqueInstance = Singleton1_1.getInstance();
		System.out.println("uniqueInstance:"+uniqueInstance);
		Singleton1_1 uniqueInstance2 = Singleton1_1.getInstance();
		System.out.println("uniqueInstance:"+uniqueInstance);
		Singleton1_1 uniqueInstance3 = Singleton1_1.getInstance();
		System.out.println("uniqueInstance:"+uniqueInstance);
		//s1의 경우는 새로운 객체를 계속 받아오지만
		//uniqueInstance의 경우는 한 객체의 주소가 바뀌지 않는다. (getInstance()에서 객체가 하나 생성된 경우는 새로운 객체를 받지 않기 때문이다.
		
	}

}
