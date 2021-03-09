package com.quiz0225;

public class Q54 {
	
	public Boolean testIfB(String str) {
		return Boolean.valueOf(str);
	}
	public void testIfA() {
		if(testIfB("True")) {
			System.out.println("True");
		} else {
			System.out.println("Not true");
		}
	}
	
	
	public static void main(String [] args) {
		Q54 q54 = new Q54();
		q54.testIfA();
	}
}


