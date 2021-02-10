package variable.step1;

public class StaticTest {
	void avg() {
		//사용자 정의 메소드
	}
	
	
	public static void main(String[] args) {
		//if(args[0]==null||args.length>0) {
		if(args.length==0) {
			//아래 문장은 조건에 따라 한 번도 실행기회를 못 가질 수도 있다.
			System.out.println("입력해주시오");
			return;//메인메소드를 탈출
		}
		System.out.println(Integer.parseInt(args[0])+10);//20이 출려되도록 수정, 1010X
		int imsi = Integer.parseInt(args[0]);
		System.out.println(imsi+10);
		System.out.println("===>"+imsi+10);
		//주소번지 없이도 호출할 수 잇는 메소드가 있다. (static)
		//main메소드는 자바가 제공하는 메소드입니다.(O)
		//사용자 정의 메소드도 가능하다.
		//내가 필요한 메소드는 문자열을 집어넣으면 int타입으로 변환하여서 반환해주는 메소드
		//=>parseInt()메소드
		//java.lang에 있는 것은 따로 import문을 쓰지 않아도 된다.
		//javax.swing.JFrame같은 것들은 반드시 import문을 써주어야 한다.
		
	}

}
