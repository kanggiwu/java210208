package book.ch7;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
//배열을 사용한 이유: 코드를 반복할 필요가 없다.
public class ObjectArray {

	public static void main(String[] args) {
		//JFrame은 윈도우 운영체제에서 창을 띄울때 사용하는 클래스입니다.
		JFrame jf = new JFrame();
		//화면에 버튼을 배치하기 우해 Layout에 대한 설정이 필요
		//똑같은 크기의 방이 10개가 필요: 행렬
		GridLayout gl = new GridLayout(1,10);
		jf.setLayout(gl);
		//jf.setLayout(new GridLayout(1,10));//칸을 10개로 분할해준다. (row, column)
		//버튼의 개수가 10개이므로 객체 배열의 크기를 10으로 하였다.
		JButton jbtns[] = new JButton[10];
		//버튼의 숫자값을 출력해야 하는데 배열을 사용하면 반복되는 코드를 줄일 수 있으므로 사용
		//버튼에 들어갈 숫자문자열을 일일이 써주어야하나요
		JButton jbtn = null;
		String jbtn_label[] = {"0","1","2","3","4","5","6","7","8","9"};
		for(int i = 0; i < jbtns.length;i++) {
			jbtn = new JButton(jbtn_label[i]);
			jbtns[i]=jbtn;
			jf.add(jbtn);
			System.out.println(jbtns[i]+", "+jbtns[i].getText());
		}
		jf.setTitle("객체 배열 실습");
		jf.setSize(600,500);
		jf.setVisible(true);
	}
}
