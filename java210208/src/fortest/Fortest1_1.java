package fortest;

public class Fortest1_1 {

	public static void main(String[] args) {
		
		/*
		int sum = 0;
		for(int i=1; i<=10;i++) {
			if(i%2==0) {
				sum=sum+i;
			}
		}
		System.out.println("sum===>"+sum);
	
		int j=1;
		int sum2 = 0;
		while(j<=10) {
			
			
			if(j%2==0) {
				sum2 = sum2 + j;
			}
			j++;
		}
		System.out.println("sum2===>"+sum2);
		*/
		int i=0;
		int evenSum = 0;//짝수합
		int oddSum = 0;//홀수합
		for(i = 1; i <=10; i = i + 1) {
			if(i%2==0) {
				evenSum +=i;
			}
			else {
				oddSum +=i;
			}
		}System.out.println("짝수의 합:" +evenSum + ", 홀수의 합: "+oddSum);
	
	}
	
		
}
