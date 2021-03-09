package com.design;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class BaseballGame extends JFrame implements ActionListener{
	////////////   메뉴바 추가하기 ///////////////
	JMenuBar jmb        = new JMenuBar();
	JMenu    jm_game    = new JMenu("게임(G)");
	JMenuItem  jmi_new  = new JMenuItem("게임시작");
	JMenuItem  jmi_dap  = new JMenuItem("정답");
	JSeparator js_game = new JSeparator();
	JMenuItem  jmi_exit = new JMenuItem("나가기");
	JMenu    jm_about   = new JMenu("도움말(H)");
	JMenuItem jmi_info  = new JMenuItem("야구숫자게임이란?");
	JMenuItem jmi_maker = new JMenuItem("만든사람들");
	///////////   메뉴바 추가하기 ///////////////
	JOptionPane jop   = new JOptionPane();
	JFrame jf         = new JFrame();
	JPanel jp_center  = new JPanel();//동서남북중앙
	JPanel jp_east    = new JPanel();//버튼4개 GridLayout(4,1)
	JTextArea jta_display = new JTextArea();
	JScrollPane jsp_display = new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField jtf_input = new JTextField();
	String[] jbtns_label = {"새게임","정답","지우기","종료"};
	JButton[] jbtns = new JButton[4];
	//JTexaArea에 순번 출력하기
	int cnt = 0;
	//만든이들 다이얼로그 닫기 버튼추가
	JButton jbtn_close = null;	
	//컴퓨터가 난수발생으로 얻어낸 값 저장
	int[] com = new int[3];	
	int[] my = new int[3];	
	public void nanSu(){
		com[0] = (int)(Math.random()*10);
		do{
			com[1] = (int)(Math.random()*10);
		}while(com[0]==com[1]);
		do{
			com[2] = (int)(Math.random()*10);
		}while((com[0]==com[2])||(com[1]==com[2]));
		System.out.println(com[0]+""+com[1]+""+com[2]);
	}	
	//전광판에 출력될 메시지를 작성하는 메소드 선언
	public String call(String input){
		//스트라이크를 카운트할 변수
		int strike = 0;
		//볼을 카운트할 변수
		int ball = 0;		
		int temp = 0;
		//반드시 세자리 숫자 이어야 한다.
		if(input.length()!=3){
			return "세자리 숫자만 입력하세요!!!";
		}
		temp = Integer.parseInt(input);
		my[0] = temp/100;//백자리를 받는다.
		my[1] = (temp%100)/10;//십자리를 받는다.
		my[2] = temp%10;
		for(int i=0;i<com.length;i++){
			for(int j=0;j<my.length;j++){
				//같은 숫자가 존재하는 경우(볼확보)
				//컴퓨터가 채번한 숫자가 있는지 비교
				if(com[i] == my[j]){
					//자리수까지도 일치하는 경우(스트라이크확보)
					//그 숫자가 존재하는 배열의 인덱스값을 비교
					if(i==j){
						strike++;
					}else{
						ball++;
					}
				}//  end of if          ////////////////
			}//////  end of inner for   ////////////////
		}//////////  end of outter for  ////////////////
		if(strike == 3) return "정답입니다.";
		return strike+"스트라이크" +ball+"볼";
	}/////////////  end of call ////////////////////////	
	//화면처리하기
	
	public static void main(String[] args) {
		new BaseBallGame();
	}
	
}