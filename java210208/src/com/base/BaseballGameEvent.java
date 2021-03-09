package com.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BaseballGameEvent implements ActionListener{
	//ActionLidstener인 나는 버튼을 눌렀을 떄 일어나는 일에 대해서 알 수 없다  => 구현체 클래스가 있어야한다. 
	//인터페이스는 반드시 구현체 클래스가 필요하다.
	//그래야 actionPerformed라는 추상메소드를 구현할 수 있으니까.
	//ActionListener al = new BaseballGameEvent();
	//ActionLidstenr al = new ActionListenr();
	BaseballGameView bbgView = null;
	BaseballGameLogic bbgLogic = null;
	
	public BaseballGameEvent() {}
	
	public BaseballGameEvent(BaseballGameView bbgView) {//원본을 불러와서 해당 객체에서 이벤트가 발생하는 경우를 처리한다!
		this.bbgView = bbgView;//view계층의 주소를 불러오기
	}	
	public BaseballGameEvent(BaseballGameView bbgView, BaseballGameLogic bbgLogic) {//원본을 불러와서 해당 객체에서 이벤트가 발생하는 경우를 처리한다!
		this.bbgView = bbgView;//view계층의 주소를 불러오기
		this.bbgLogic = bbgLogic;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 감지된 소스의 주소번지를 얻기
		Object obj = e.getSource();
		// 라벨값으로 처리하고 싶으면
		String label = e.getActionCommand(); //새게임,지우기
		System.out.println("event label:"+label);
		if(obj == bbgView.jtf_input){//bbgView가 null이 아니기 위해서는 event의 생성자를 경유해야한다.
			String input =  bbgView.jtf_input.getText().trim();//텍스트필드 값에서 값을 받아온다.
			
			//만일 숫자가 아닌 값이 있을 때도 고려해야 한다.
			try {
				Integer.parseInt(input);//356	//인풋이 만약 숫자가 아니라면 숫자로 바꾸어준다.		
			} catch (NumberFormatException nfe) {
				 bbgView.jop.showMessageDialog( bbgView.jf, "숫자만 입력하세요", "Error", JOptionPane.ERROR_MESSAGE);//입력한 값이 숫자형태가 아닌 경우 창을 띄운다.
				 bbgView.jtf_input.setText("");//텍스트필드에 입력한 값 초기화
				 bbgView.jtf_input.requestFocus();//텍스트필드에 포커스
				return ;
			}
			
			if(input.length()!=3){//새자리 수가 아니면 끝내기
				return;
			}
			else{//순번. 입력한값: 입력한 값을 가지고 스트라이크, 볼을 알아내는 call함수
				 bbgView.jta_display.append(bbgView.bbgLogic.getCnt()+". "+ bbgView.jtf_input.getText()+": "+bbgView.bbgLogic.call(input)+"\n");
				 bbgView.jtf_input.setText("");
			}
		}
		else if("지우기".equals(label)){
			 bbgView.jta_display.setText("");
			 bbgView.jtf_input.requestFocus();
		}
		else if("종료".equals(label)){
			System.exit(0);// 자바 가상머신과의 연결고리를 끊는다.
		}
		else if(obj ==  bbgView.jmi_dap){
			int[] com = bbgView.bbgLogic.getCom();//유지보수: 코드를 최대한 손대지 않는다.::::재사용성으로는 좋다,,,,제 3자가 신경써야하는 경우는 메소드가 아니라 하나씩 받아오는 경우가 더 좋다::::호불호 문제 
			 bbgView.jta_display.append("정답은 "+ com[0]+ com[1]+ com[2]+"\n");
			 bbgView.bbgLogic.nanSu();
		}
		else if(obj ==  bbgView.jbtns[1]){//정답
			int[] com = bbgView.bbgLogic.getCom();
			 bbgView.jta_display.append("정답은 "+ com[0]+ com[1]+ com[2]+"\n");
			 bbgView.bbgLogic.nanSu();
		}
		//새게임
		else if(obj ==  bbgView.jbtns[0]){
			bbgView.bbgLogic.cnt = 0;
			bbgView.bbgLogic.nanSu();
			bbgView.jta_display.setText("");
			bbgView.jtf_input.setText("");
			bbgView.jtf_input.requestFocus();
		}
	}
}
