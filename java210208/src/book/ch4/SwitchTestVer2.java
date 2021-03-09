package book.ch4;

import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwitchTestVer2 extends JFrame {

   public static void main(String[] args) {
      SwitchTestVer2 stv = new SwitchTestVer2();
      int    protocol    = 0; // 로그인
      String    nickName    = "tomato"; // id값 정하기
      String    inputValue    = "오늘 스터디할까?"; // 전달할 메세지
      String    msg       = 200+"#"+nickName+"#"+inputValue;
      // #은 위의 msg를 #기준으로 자른다는 이야기이다. StringTokenizer은 하나씩 가져오는 것이다.
      StringTokenizer st    = new StringTokenizer(msg,"#");
      protocol = Integer.parseInt(st.nextToken());
      
      // 메세지를 전달할 때는 서버를 통해서 전달되어야 한다.
      String s_nickName = st.nextToken();
      String s_inputValue = st.nextToken();
      
      switch(protocol) {//원시형 타입 + String 타입으로 작성됨
      case 100:
         // 실행문
         System.out.println("0입니다.");
         break;
      case 200:
         // 실행문
         System.out.println("100입니다.");
         break;
      case 300:
         // 실행문
         System.out.println("["+s_nickName+"]"+s_inputValue);
         break;
      default:
         JOptionPane.showMessageDialog(stv, "잘못된 메세지입니다.");
         break;
      }///////////////////end of switch
      System.out.println("여기");
   }