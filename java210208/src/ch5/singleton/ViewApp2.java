package ch5.singleton;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewApp2 {
	//setSize하기 전에 인스턴스화를 하였다.
	JFrame		jf	=	new	JFrame();
	JFrame		jf2	=	null;
	JButton 	jbtn =  null;
	
	private void initDisplay() {
		jf2 = new JFrame();
		EventHandler2 eh = new EventHandler2(null);//이벤트 처리는 이벤트 핸들러에서 진행한다.
		jbtn = new JButton("전송");
		jbtn.addActionListener(eh);//이벤트소스와 이벤트처리담담클래스(이벤트헨들러클래스)를 연결
		jf2.add("North",jbtn);
		jf2.setSize(300,200);
		jf2.setVisible(true);
		
	}

	public static void main(String[] args) {
		ViewApp2	va = new ViewApp2();
		va.initDisplay();//클래스내에 선언된 메소드라도 main에서 사용시 인스턴스화를 해주어야한다.
	}


}
