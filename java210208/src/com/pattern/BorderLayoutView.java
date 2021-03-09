package com.pattern;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutView {

	public static void main(String[] args) {
		//버튼 객체를 5개 선언 및 초기화하기 - 메모리에 로딩이 일어난다.
		JButton jbtn_east = new JButton("동쪽");
		JButton jbtn_west = new JButton("서쪽");
		JButton jbtn_south = new JButton("남쪽");
		JButton jbtn_north = new JButton("북쪽");
		JButton jbtn_center = new JButton("중앙");
		//윈도우에서 독릭된 창을 띄울 때 사용
		JFrame jf = new JFrame();
		//JFrame의 배치 레이아웃을 정함
		jf.setLayout(new BorderLayout());//BorderLayout:크기가 줄고 늘고는 중앙의 크기가!
		//@param1:위치정보, @param2:주소번지
		jf.add("East",jbtn_east);
		jf.add("West",jbtn_west);
		jf.add("South",jbtn_south);
		jf.add("North",jbtn_north);
		jf.add("Center",jbtn_center);
		jf.setSize(500,300);
		jf.setVisible(true);
	}

}
