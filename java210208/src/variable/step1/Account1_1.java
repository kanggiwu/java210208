package variable.step1;



public class Account1_1 {
	double kor = 0;
	double math = 0;
	double eng = 0;
	double tot = 0;
	double avg = 0;
	/*
	 * 총점을 구하는 메소드
	 * @param kor2 학생의 국어 점수
	 * @param math2 학생의 수학 점수
	 * @param eng2 학생의 영어 점수
	 * @return tot 한 학생의 세 과목의 총점을 구하여 담는 변수의 값을 반환
	 */
	
	protected void setVar(double kor, double math, double eng) {
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	protected void setTot(){
		tot = kor + math + eng; 
	}
	protected double hap(double kor2, double math2, double eng2) {
		double tot = kor2+math2+eng2;
		return tot;
	}
	
	/*
	 * 평균을 구하는 메소드 구현
	 * @param tot hap메소드를 호출하여 tot를 받아온다.
	 * @return 
	 */
	double avg(double tot) {
		return tot/3;
	}
	
	private double avg(double tot, int n) {
		return tot/n;
	}
	
	private double avg1(double tot) {
		this.tot = tot;
		this.avg = this.tot/3;
		return this.avg;
	}

	/* 값에 의한 호출
	 * tot 총합을 계산한 값
	 * subjectNum 과목수
	 */
	private double es_avg(double tot, int subjectNum) {
		ExamScore es = new ExamScore();
		
		System.out.println("tot==>"+tot+",과목수==>" + subjectNum);
		
		return es.avg(tot, subjectNum);
	}
	
	
	
	
	
	public static void main(String[] args) {
		Account1_1 ac = new Account1_1();
		ExamScore es = new ExamScore();
		
		ac.kor = 70;
		ac.math = 80;
		ac.eng = 90;
		double tot = ac.hap(ac.kor,ac.math,ac.eng);
		double estot = es.tot_sum(ac.math, ac.kor, ac.eng);//ExamScore클래스의 합을 구하는 함수를 사용
		
		double test_avg = ac.avg(tot);
		double test_avg2 = ac.avg(tot,3);	
		double test_avg3 = ac.es_avg(tot, 3);//ExamScore의 평균을 구하는 메소드를 이용한 메소드를 사용
	}


}
