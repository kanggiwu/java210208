package network.step1;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

 /*********
 *
 *	소켓-- 무전기에 장착된 하드웨어
 *	네트워크에서 정보가 나가고 들어가고 나가는 지점에 대한 유일한 식별자
 *	32비트의 숫자로 구성되며 짝수번 소켓은 정보를 받아들이는 용도로
 *	홀수번 소켓은 정보를 보내는 용도로 사용된다.

 *	FIFO속성을 가지고 있다. 큐, 스택(백팩:FILO)
 *	동시에 두가지를 할 수 없다.(읽으면서 쓰기, 쓰면서 읽기 X)
 *	네트워크망이 구성되어있어야 함.
 *	
 *	채팅은 읽기와 쓰기가 모두 다 되어야한다.---홀수/짝수 나뉘는 이유

 *	TCP포트번호: 물리적인 장치를 꽂는 장소는 아니다. 용도에 따라 쓰는 숫자 값.
 *	서버에서 돌아가는 특정 프로그램을 나타내는 16비트 숫자
 *	웹서버 - 80
 *	텔넷서버 - 23
 *	FTP서버 - 20
 *	SMTP서버 - 25

 *	같은 포트에서 여러 프로그램이 돌아갈 수 있나요?
 *	BindException이 발생

 *	nestat -an | findstr 3000 //포트번호 상태 정보 검색 
 *	taskkill /pid 42356 /f //포트 삭제를 해줘야 같은 번호로 재사용할 수 있다.

 *********/
public class TimeServer extends Thread{
	Socket socket = null;
	public TimeServer() {}
	public TimeServer(Socket socket) {
		this.socket = socket;
	}
	/*************************************
	스레드 기동시 호출되는 메소드
	************************************/
	@Override
	public void run(){
		boolean isFlag = false;
		try{
			//socket에 대한 객체 주입은 인스턴스화를 통해서 생성자가 호출되었을 때 객체 주입이 이뤄짐.
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);//소켓사용
			while(!isFlag){
				if(out!=null){
					out.println(getTimer());
				}
				//1초동안 기다려..그리고 진행.. 1초 기다려.. 진행
				try{
					sleep(1000);//밀리세크 단위로 설정 지연 - 스레드, 경합 -스레드, 순서-스레드 순서를 정한다 - 스레드
				} catch(InterruptedException ie){//제어건을 뺏기게 된 경우
					System.out.println("넌 누구...");
				}
			}
		}catch(Exception e){
		
		}
		System.out.println("run call...");
	}
	public String getTimer(){
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		//return "10:24:15";
	
		return (hour < 10 ? "0"+hour:""+hour)+":"
				+(min <10?"0"+min:""+min)+":"
						+(sec<10?"0"+sec:""+sec);
	}
	//main메소드도 스레드이다.(default thread) entry point가장먼저 시작하는 부분 main보다 먼저 시작하는 부분은 static block{}--한번이니까...
	public static void main(String[] args) {
		int port = 3000;//포트번호지정
		boolean isFlag = false;//서버를 탈출시킬 수 있는 수단
		ServerSocket server = null;//클라이언트가 접속될떄까지 기다림 클라이언트에서 new Socket(ip,port)시 넘어옴
		Socket client = null;//클라이언트의 정보를 받아옴
		try{
			server = new ServerSocket(port);
		}catch(Exception e) {
				
		}
		System.out.println("TimeServer Started successfully...");
		//while(true)--위험하다. 무한루프에 빠질 수 있다.
		while(!isFlag){
			try{	
				//System.out.println("New Client connected..."+client.toString()+"\n");
				//TimeServer ts = new TimeServer(client);//socket에 null값이 들어가기 때문에....NullpointException발생
				//기다림....손님 올떄까지...
				client = server.accept();//클라이언트 소켓을 받아온다.
				//initDisplay();여기에 있으면 영원히 사용되지 않을 수도...위의 클라우드 소켓을 받지 않을 수도 있으니까!--
				System.out.println("New Client connected..."+client.toString()+"\n");
				TimeServer ts = new TimeServer(client);//클라이언트를 받는 객체를 생성
				ts.start();	//run()호출 
			} catch (Exception e){
		
			}
		}
	}
}	
//netstat _ano | findstr 3000(port)
//네트워크	옵션		찾고자하는 포트번호
//상태 정보
//taskkill /pid ?/f ----바인딩된 포트를 강제로 죽임
//	프로세스아이디