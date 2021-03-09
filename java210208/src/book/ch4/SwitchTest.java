package book.ch4;

public class SwitchTest {

   public static void main(String[] args) {
      int protocol = 100; // 로그인
      protocol = 200; // 입장하기
      protocol = 300; // 다자간 대화
      protocol = 301; // 귓속말 (1:1채팅)
      String id = "토마토"; // id값 정하기
      String input = "오늘 스터디할까?"; // 전달할 메세지
      String msg = protocol+"#"+id+"#"+input;
      // 제어문의 역할은 업무 순서에 대한 흐름을 바꾼다.
      // 순서에 대한 정보를 바탕으로 어떠한 의사를 결정할 수 있는 것은 높은 직급을 가진 선택자이다.
      // 선택자들의 선택(비즈니스 로직계층, 즉 Model계층)에 따라
      // break의 용도 : for, while 등에서 사용될 때 무한루프를 방지하는 역할 (break의 반댓말은 continue)
      // if문에서의 break : 메소드를 탈출하는 역할(return)
      // switch문에서의 break : switch문을 빠져나가는 역할
      switch(protocol) {//원시형 타입 + String 타입으로 작성됨
      case 0: // 0일 때의 실행문
         System.out.println("0입니다.");
         break;
      case 100: // 100일 때의 실행문
         System.out.println("100입니다.");
         break;
      case 200: // 200일 때의 실행문
         System.out.println("200입니다.");
         break;
      case 300: // 301일 때의 실행문
         System.out.println("301입니다.");
         break;
      default:
         System.out.println("여기는 default입니다.");
         break;
      }///////////////////end of switch
      System.out.println("여기");
   }

}