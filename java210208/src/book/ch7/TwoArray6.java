package book.ch7;

public class TwoArray6 {
	void init() {
		int is[][] = {{1,2},{3,4},{5,6}};
		int x = 0;
		while(x<is.length) {
			int y = 0;
			while(y<is[x].length) {
				System.out.println("is["+x+"]"+"["+y+"]=" +is[x][y]);
				y = y + 1;
			}
			x = x+1;
		}
	}

	public static void main(String[] args) {
		//2는 로우
		//3은 칼럼
		int is[][] = new int[2][3];
		for(int i = 0;i<is.length;i++) {
			for(int j = 0;j <is[i].length;j++) {
				System.out.println("is["+i+"]"+"["+j+"]=" +is[i][j]);
			}
		}
	}

}
