package test1;

public class ThreeMul_2 {

	public int threeMulNum(int firstNum, int secondNum) {
		int count = 0;
		if(firstNum<=secondNum) {
			for(int i = firstNum; i<=secondNum;i++) {
				if(i%3==0) count++;
			}
		}else {
			for(int i = firstNum; i>=secondNum;i--) {
				if(i%3==0) count++;
			}
		}
		
		return count;
	}

}
