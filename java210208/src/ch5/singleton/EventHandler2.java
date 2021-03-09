package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler2 implements ActionListener {
	ViewApp2 viewApp2 = null;

	public EventHandler2(ViewApp2 viewApp22) {
		this.viewApp2 = viewApp2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==viewApp2.jbtn) {//NullPointerException 이유: viewApp가 인스턴스화가 안된 null상태
			System.err.println("전송 버튼 호출 성공");
		}
	}

	public static void main(String[] args) {
	}

}
