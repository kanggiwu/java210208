package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ViewApp1_2 implements ActionListener{
	//setSize하기 전에 인스턴스화를 하였다.
	JFrame		jf	=	new	JFrame();
	JFrame		jf2	=	null;
	JMenuBar	jmb	=	new JMenuBar();
	JMenu		jm_file	= new	JMenu("file");
	JMenuItem	jbn_insert	=	new JMenuItem("입력");
	JMenuItem	jbn_select	=	new JMenuItem("조회");
	JMenuItem	jbn_delete	=	new JMenuItem("삭제");
	
	
	public void initDisplay() {
		jf2 = new JFrame();
		jmb.add(jm_file);
		jm_file.add(jbn_select);
		jm_file.add(jbn_insert);
		jm_file.add(jbn_delete);

		jf2.setSize(300,200);
		jf2.setVisible(true);
		
	}

	public static void main(String[] args) {
		ViewApp1_2	va = new ViewApp1_2();
		va.initDisplay();//클래스내에 선언된 메소드라도 main에서 사용시 인스턴스화를 해주어야한다.
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
