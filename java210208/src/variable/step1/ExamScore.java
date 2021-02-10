package variable.step1;

public class ExamScore {
	double tot = 0;
	double avg(double tot, int n) {
		return tot/n;
	}
	
	double tot_sum(double math, double kor, double eng) {
		tot = math+kor+eng;
		
		return tot;
	}
	
	
	public static void main(String[] args) {
		ExamScore es = new ExamScore();
		double math, kor, eng;
		
		math = 60;
		kor = 80;
		eng = 70;
		
		double tot_sum = es.tot_sum(math, kor, eng);
		System.out.println(es.avg(tot_sum,3));
		
		
		
	}

}
