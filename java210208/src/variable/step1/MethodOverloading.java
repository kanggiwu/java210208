package variable.step1;
import com.vo.DeptVO;

public class MethodOverloading {
	/*
	 * pdvo -조건절에서 사용될 상수값을 담음	- where들어갈 조건갑으로 사용
	 * 오라클에서 조회된 결과를 담음 			-화면 출력용으로사용
	 */
	 DeptVO go(DeptVO pdvo) {
		System.out.println(pdvo.getDeptno()+", "+pdvo.getDname()+", "+pdvo.getLoc());
		DeptVO rdvo = null;
		return rdvo;
	}
	//메소드 오버로딩
	void go() {
		System.out.println("파라미터X");
	}
	void go(int i) {
		System.out.println("파라미터==>int");
		
	}
	void go(String name) {
		System.out.println("파라미터==>String");
	}
		
	public static void main(String[] args) {
		MethodOverloading mol = new MethodOverloading();
		mol.go();
		mol.go(10);
		mol.go("smith");
		DeptVO pdvo = new DeptVO();
		/*
		pdvo.setDeptno(50);
		pdvo.setDname("개발1팀");
		pdvo.setLoc("제주도");
		mol.go(pdvo);//주소번지를 넘겼다. 참조에 의한 호출이다. 
		*/
	}

}
