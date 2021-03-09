package network.step1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JLabel;

//서버는 ip주소를 알지만 클라이언트는 모르기 떄문에  SeverSocket에서 ip주소를 받는다.

public class TimeClient extends Thread {
	
	String timeStr = null;//시간정보를 얻어와야지
	JLabel jlb_time = null;
	
	TimeClient (){}
	public TimeClient(JLabel jlb_time){//패키지가 다르기 때문에 해당 생성자에 public을 써줘야함
		this.jlb_time = jlb_time;
	}
	
	
	@Override
	public void run() {//콜백메소드 -- 사용자가 아니라 시스템레벨에서 자동으로 호출되는 메소드이다.
		Socket socket = null;
		BufferedReader br = null;//한문장 전체를 읽어옴 
		boolean isFlag = false;
		try {
			socket = new Socket("192.168.0.27",3000);//local port: 9234--접속
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//서버에서 받아온 내용을 변수 br에 저장
			//inputStreamReader--서버에서 받아온 바이트스트림에서 문자스트림으로 변경
			//InputStream is = new InputStreamReader(socket.getInputStream());
			//내 소켓에 대한 포트번호 따로 할당
			while(!isFlag) {
				while((timeStr=br.readLine())!=null){
					System.out.println(timeStr);//시간정보가 찍힘
					jlb_time.setText(timeStr);
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("넌 누구..");
					}
				}
			}
			
			//내 소켓에 대한 포트번호 따로 할당---양쪽 소통
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	/*public static void main(String[] args) {	
		TimeClient tc = new TimeClient();
		tc.start();//run메소드 호출
	}*/ //AddressBook2에서 실행

}
