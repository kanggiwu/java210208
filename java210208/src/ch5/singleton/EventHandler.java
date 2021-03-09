package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
	ViewApp viewApp = null;
	public EventHandler(ViewApp viewApp) {
		this.viewApp = viewApp;//전송버튼을 어디에서 눌렀는지 알기 위해서는 해당 버튼이 있는 주소가 필요하다.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==viewApp.jbtn) {//NullPointerException 이유: viewApp가 인스턴스화가 안된 null상태
			System.err.println("전송 버튼 호출 성공");
		}
	}

	public static void main(String[] args) {
	}

}
