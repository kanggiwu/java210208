package book.ch7;

import com.vo.DeptVO;

public class MethodOverloading {
	void go() {}
	public void go() {}//접근제한자는 영향이 없다.
	public void go(int[] a) {}//메소드 오버로딩
	public void go(int[] b) {}//메소드 오버로딩이 아님(파라미터이름은 영향X)
	public void getDeptList(DeptVO dvo) {//메소드 오버로딩을 만족한다.
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
