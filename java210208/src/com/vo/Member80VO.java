package com.vo;

public class Member80VO {
	private	String    mem_id = null; //아이디 담기
	private	String    mem_pw = null;//비번 담기
	private	boolean   gender = false;//성별 담기
	/*
	 * 생성자는 반환타입이 없다.-> 반환타입 작성시 메소드가 된다.
	 * 클래스 이름과 동일해야한다.
	 * 전역변수 초기화를 담당한다.
	 * static블럭에서 하는 일을 맡겨도 괜찮다.
	 * 만일, 소켓 통신을 통해서 서버사이트와 클라이언트 사이트를 구현(구축) 시 초기화 부분들은 중요
	 * 
	 * 메소드 오버로딩
	 * 전제조건 - 모두 같은 이름이다. 다른이름이라면 해당 없다.
	 * 접근제한자의 유무, 리턴타입 유무(생성자해당X)는 메소드 오버로딩에 해당X
	 * 예외를 던지고 그렇지 않고는 영향이 없다.
	 * void go() throws Exception, SQLException{}//오라클의 경우 다음과 같이 여러개의 예외를 던질 수 있다.
	 */
	public Member80VO() {}//디폴트 생성자
	public Member80VO(String mem_id){
		this.mem_id = mem_id;
	}//파라미터가 있는 생성자
	public Member80VO(String mem_id, String mem_pw){
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
	}//파라미터가 있는 생성자
	public Member80VO(String mem_id, String mem_pw, boolean gender){
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.gender = gender;
	}//파라미터가 있는 생성자
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public boolean isGender() {//boolean앞에는 get이 아니라 is가 온다. 
		return gender;
	}
	public boolean getGender() {//boolean: getGender로 사용해도 된다. 
		return gender;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
}
