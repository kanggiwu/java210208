package com.quiz0222;
import com.google.gson.Gson;
import com.vo.Member80VO;
public class MemberList {

	public static void main(String[] args) {
		Member80VO mvo = new Member80VO();
		mvo.setMem_id("apple");
		mvo.setMem_pw("123");
		mvo.setGender(true);
		mvo = new Member80VO("tomato", "123", true);
		Gson gson = new Gson();//웹에서 사용하는 자료구조의 형태를 띄는 포맷의 형식을 지원(자료구조는 아니다)
		String imsi = gson.toJson(mvo);
		System.out.println(imsi);
	}
}
