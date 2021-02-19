package test1;

public class Q1 {
	double e_weight = 0;
	double m_weight = 0;
	
	public Q1(double e_weight) {
		this.e_weight = e_weight;
		this.m_weight = e_weight*0.17;
	}
	public double getE_weight() {
		return e_weight;
	}
	public void setE_weight(double e_weight) {
		this.e_weight = e_weight;
	}
	public double getM_weight() {
		return m_weight;
	}

}
