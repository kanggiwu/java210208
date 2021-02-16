package variable.step1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginView extends Object implements ActionListener{//결합도를 낮추는 코드 작성 때 필요, 클래스 설계시 필요(요즘은 웹 기반으로 하기 때문에 복습x)
	JFrame jf = new JFrame();//java.lang에 있는 패키지가 아니므로 별도로 import해야한다.
	JButton jbtn_login = new JButton("로그인");
	//화면 그리기 구현
	public void initDisplay() {
		//내 자신이 이벤트 처리를 담당하는 핸들러 클래스이다 라는 의미로 this를 사용
		jbtn_login.addActionListener(this);//이벤트 소스와 이벤트 처리를 담당하는 클래스 연결
		jf.add("North",jbtn_login);
		jf.setSize(500, 400);
		jf.setVisible(true);//화면에 보여줌
	}
	
	//내 안에 있는 메소드 이지만 static영역 안에서 non-static을 접근할 수 없으므로 인스턴스화를 해서 해결할 수 있다.
	public static void main(String[] args) {
		LoginView view = new LoginView();
		view.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(jbtn_login==e.getSource()) {//이벤트 감지는 pc가 하고 버튼의 주소번지는 내가 정의,,주소번지가 같은가?
			System.out.println("이순신 님 환영합니다.");
		}
	}
	
}
