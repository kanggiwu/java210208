package com.base;

public class BaseballGameLogic {//아무것도 상속받지 않고 업무만 순수하게 처리하는 부분
	//컴퓨터가 난수발생으로 얻어낸 값 저장
	//컴퓨터가 채번한 값 - 채번하는 메소드가 필요:::메소드 중심의 코딩 전개하기:::재사용성:::==>새 게임|정답을 눌렀을 떄 재사용이 된다. 정답을 누른 경우 이미 알았으니까 다른 값을 받아서 게임을 해야지!
	int[] com = new int[3];	// 0 0 0
	//사용자가 입력한 값은 로컬에서 온다.
	int[] my = new int[3];	//
	//JTexaArea에 순번 출력하기
	int cnt = 0;
	//만든이들 다이얼로그 닫기 버튼추가
	BaseballGameView  bbgView = null;
	
	//전광판에 출력될 메시지를 작성하는 메소드 선언
	/****************************************
	 * @param input jp_center속지 - 남쪽: JTextField를 붙였다. 숫자를 입력해도 문자가 되도록!
	 * @return 1스 0볼, 2스 1볼('스'숫자도 같고 위치도 같을 때, '볼'숫자는 있지만 위치가 다르다.) 등등
	 * 1회: 256 - 1스 0볼
	 * 2회: 356 - 1스 1볼
	 * 전역변수: 회차를 말하는 cnt(static 고려 대상 -- 바뀌는 값이기 때문이기 때문에 staticX)
	 * 지역변수: 스트라이크와 볼(static 고려 대상x)
 	 */
	public String call(String input){//스트라이트와 볼의 개수를 알려주는 함수
		//스트라이크를 카운트할 변수
		int strike = 0;
		//볼을 카운트할 변수
		int ball = 0;		
		int temp = 0;
		//반드시 세자리 숫자 이어야 한다.
		if(input.length()!=3){
			return "세자리 숫자만 입력하세요!!!";
		}
		temp = Integer.parseInt(input);//사용자가 입력한 값을 정수로 바꿔서 변수에 대입
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
	
		public BaseballGameLogic() {}

		public BaseballGameLogic(BaseballGameView bbgView) {
			this.bbgView = bbgView;
		}
		public int[] getCom() {
			return com;
		}
		public int getCnt () {
			return ++cnt;
		}
		public void setCnt (int cnt) {
			this.cnt = cnt;
		}
		//
		public void nanSu(){//난수를 처리하는 메소드(중복되는 값이 나오지 않도록 while문에 조건을 달아둔다.)
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
		
}
