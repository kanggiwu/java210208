package test1;

public class Q3_1 {

	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		if((++i>j--)|(++i>j)) {//두 조건을 모두 확인한다
			//|인 경우, 뒤의 값이 참이기 때문에 이부분 호출
			//i=3,j=1
			System.out.println("해당 조건 중 하나 이상이 참입니다.");
		}else {
			//&인 경우, 이 부분 실행
			System.out.println("둘다 거짓입니다.");
		}
		//변수 초기화가 있을 때와 없을 떄가 차이가 있다.
		i = 1;
		j = 2;
		
		if((++i>j--)||(++i>j)) {//앞의 조건이 false이기 때문에 뒤에 조건은 확인하지 않는다.
			//||인 경우, 뒤의 부분이 i=3,j=1로 참이 되기 때문에 이 부분을 실행한다.
			System.out.println("해당 조건 중 하나 이상이 참입니다.");
		}else {
			//&&인 경우, 이 부분 실행
			System.out.println("둘다 거짓입니다.");
		}
		
	}

}
