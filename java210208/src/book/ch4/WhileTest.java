package book.ch4;

public class WhileTest {

	public static void main(String[] args) {
		//for(;;i++) 조건식과 증감연산자가 들어오기 때문에 while문보다 조금 더 안전해 보일 있다.
		//조건을 수렴했을 떄는 break;를 할 수 있도록 주의(무한루프 방지)
		//continue; => 아래 문장은 진행X, 다음 반복으로 넘어간다.
		while(true) {//무한루프에 빠진다. true같은 상수 사용X
			break;
		}
		boolean isStop = false;
		while(!isStop) {
			
		}//while문 조건절에는 boolean 변수를 선언해서 사용하는 것이 좋다. 
		
		while(true) {
			
		}
		//int i = 5;//위에 무한루프가 걸려있기 때문에 영원히 실행 기회를 얻을 수 없어서 오류가 뜬다.
	}

}
