package com.pattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RandomGameViewAns extends JFrame implements ActionListener {
	//선언부
	//동쪽에 붙일 속지 선언 및 생성
	JPanel jp_east = new JPanel();//Fragment - 안드로이드에서 사용하는 클래스
	//중아에 그려질 속지 선언 및 생성
	//JPanel jp_center = new JPanel();
	JTextArea jta_display = new JTextArea(7,20);
	JScrollPane jsp_display = new JScrollPane(jta_display
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//남쪽에 그려질 속지 선언 및 생성 - 여기에는 버튼 10개
	JPanel jp_south = new JPanel();
	JButton jbtns[] = new JButton[10];//방만 만들어진 상태
	JButton jbtn = null;
	JButton jbtn_new =  new JButton("새게임");
	JButton jbtn_clear = new JButton("지우기");
	JButton jbtn_dap = new JButton("정담");
	JButton jbtn_exit = new JButton("종료");
	//문자열을 담을 수 있는 방 10개를 만들고 숫자를 0~9까지 초기화
	String nums_label[] = {"0","1","2","3","4","5","6","7","8","9"};
	
	
	//생성자
	
	//화면처리
	public void initDisplay() {
		jbtn_exit.addActionListener(this);
		JFrame jf = new JFrame();
		//jp_center.setBackground(Color.green);
		jp_south.setLayout(new GridLayout(1,10,3,3));
		jp_east.setLayout(new GridLayout(4,1,2,2));
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_exit);
		
		for(int i = 0; i < jbtns.length;i++) {
			jbtn = new JButton(nums_label[i]);
			jp_south.add(jbtn);
			jbtns[i]=jbtn;
			jbtn.addActionListener(this);
		}
		jp_east.setBackground(Color.blue);
		jp_south.setBackground(Color.red);
		jf.setLayout(new BorderLayout());
		jf.add("Center",jta_display);
		jf.add("East",jp_east);
		jf.add("South",jp_south);
		jf.setSize(500,400);
		jf.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		RandomGameViewAns rgView = new RandomGameViewAns();
		rgView.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command+","+e.getSource());
		if(e.getSource()==jbtn_exit)
			System.exit(0);//JVM과의 연결고리가 끊어져서 종료됨.
		else if(e.getSource()==jbtns[5]) //("5".equals(command)) 문자열 비교
			jta_display.append(command);
	}

}
