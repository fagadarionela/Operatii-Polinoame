package MonomSiPolinom;
public class Monom implements Comparable{
	private double coeficient;
	private int putere;
	public Monom(){
		this.coeficient=0;
		this.putere=0;
	}
	public Monom(double coef,int putere)
	{
		this.coeficient = coef;
		this.putere = putere;
	}
	public double getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(double d) {
		this.coeficient = d;
	}
	public int getPutere() {
		return putere;
	}
	public void setPutere(int putere) {
		this.putere = putere;
	}
	@Override
	public int compareTo(Object o) {
		return -(Integer.compare(this.getPutere(), ((Monom)o).getPutere()));
	}
}