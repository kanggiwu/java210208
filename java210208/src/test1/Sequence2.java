package test1;

public class Sequence2 {
	
	public int returnSequence (int a, int r) {
		int seq = 0;
		
		for(int i = 0; i<7;i++) {
			if(i==0) {
				seq = a;
				System.out.println(seq);
			}
			else {
				seq *= r;
				System.out.println(seq);
			}
		}
		return seq;
	}
	public void returnSeqArr (int a, int r, int n) {
		int[] seq = new int[n];
		
		for(int i = 0; i<7;i++) {
			if(i==0) {
				seq[i] = a;
				System.out.println(seq[i]);
			}
			else {
				seq[i] = seq[i-1] * r;
				System.out.println(seq[i]);
			}
		}
		
	}
}
