package variable.step1;

public class Quiz1 {
	//메소드는 2가지 종류가 있다.
	//JMV에서 제공되는 메소드 & 사용자 정의 메소드
	//메소드 선언 순서: 리던타입 메소드명 (파라미터) { 실행문; }
	//메소드 선언-> 리턴타입과 파라미터타입을 결정할 수 있다.
		
	//methodA의 호출이 선언 앞에 오더라도 에러가 아님
	//자바는 절차지향의 프로그래밍 언어X, 객체지향 언어=>호출 순서 상관X
	int x = 2;
	public static void main(String[] args) {
		Quiz1 q = new Quiz1();
		q.methodA();
		q.methodA(1);
		q.methodA(3.14);
				
	}
	private void methodA() {//private으로 하면 해당 클래스 내에서만 사용
		Quiz1 q = new Quiz1();
		System.out.println("methodA호출 성공 "+q.x);
	}
	//파라미터 x에는 누가 값을 결정?
	//언제 결정되는 건가?
	private void methodA(int x) {
		System.out.println("methodA(int x)호출 성공 "+x);
	}
	private int methodA(double x) {
		System.out.println("methodA(double x)호출 성공 "+x);
		return 0;
	} 
	//이클립스에서 컴파일이 일어나는 시기 -> ctrl+s를 눌렀을 떄(저장 시)
	//A.java에서 A.class로 바뀌는 순간 이클립스에서 소스는 src에 저장되고 컴파일된 소스는 bin 폴더에 저장
	//엄체에서 이행할 때는 .java는 배포하지 않는다. 이유: 주석과 소스를 보지 못하니까, .class는 기계어
}

