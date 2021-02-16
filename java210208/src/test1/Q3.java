package test1;

public class Q3 {

	public static void main(String[] args) {
		int x = 5;
		boolean b1 = true;
		boolean b2 = false;
		
		if((x==4) && !b2) //5==4(F) && b2==True
		 System.out.println("1");
		 System.out.println("2");//중괄호가 없다. if문은 위에서 끝난다.{출력}
		
		if((b2=true)&&b1) 
				System.out.println("3");//{출력}		
	}

}