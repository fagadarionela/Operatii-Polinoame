package Operatii;
import java.util.Collections;
import ModelSiController.PolinomModel;
import MonomSiPolinom.Monom;
import MonomSiPolinom.Polinom;
public class Impartire implements Operatie {
	private Polinom m_rezultat;
	private Polinom m_rezultat2;
	public Impartire(){
		m_rezultat = new Polinom();
		m_rezultat2 = new Polinom();
	}
	public void initializare() {
		m_rezultat.goleste();
		m_rezultat2.goleste();
	}
	public boolean gradePolinoameGresite (Polinom x, Polinom y) {	//tratare caz (x+1) / (x^2+2*x+2)
		if (x.grad() < y.grad())
    	{
    		m_rezultat = new Polinom();
        	m_rezultat2 = x;
        	return true;
    	}
		return false;
	}
	public boolean impartireCuZero(Polinom y) {		//verificare caz p1/0 =>se arunca o exceptie
		Polinom zero = new Polinom();
    	zero.adaugaMonom(new Monom(0,0));
    	if( y.equals(zero))
            throw new IllegalArgumentException("Impartire cu zero!");
    	return false;
	}
	
	public boolean polinoameDeGradZero(Polinom x,Polinom y) {		//tratare caz p1/constanta
		if (y.grad() == 0)
		{
			for(Monom m: x.getPoli())
			{
				m_rezultat.adaugaMonom(new Monom(m.getCoeficient()/y.getPoli().get(0).getCoeficient(),m.getPutere()));
				m_rezultat2 = new Polinom();
			}
			return true;
		}
		return false;
	}
	@Override
	public Polinom calculare(Polinom x, Polinom y) {
		initializare();
		if(!impartireCuZero(y) && !gradePolinoameGresite(x,y) && !polinoameDeGradZero(x,y)) { //se face doar daca nu se imparte cu zero, nu sunt polinoame de grad necorespunzator, sau zero
	    	double coef = 0d;
	    	int putere = 0;
	    	Polinom cat = new Polinom();
	    	Polinom rest = new Polinom();
	    	rest.copiaza(x);					//se face o copie a lui x in rest
	    	Polinom aux = new Polinom();	
	    	Polinom parteCat = new Polinom();
	    	Collections.sort(rest.getPoli());		//sortare	
	    	Collections.sort(y.getPoli());			//sortare
	    	while(rest.grad()>=y.grad()){			//algoritmul de impartire propriu-zis
	    		putere = rest.getPoli().get(0).getPutere()-y.getPoli().get(0).getPutere();
	    		coef = rest.getPoli().get(0).getCoeficient()/y.getPoli().get(0).getCoeficient();
	    		Monom m = new Monom(coef,putere);
	    		parteCat.adaugaMonom(m);			//ultimul monom introdus
	    		cat.adaugaMonom(m);
	    		Inmultire mul= new Inmultire();
	    		aux = mul.calculare(parteCat, y);
	    		PolinomModel model = new PolinomModel();
	    		rest.copiaza(model.sub(rest, aux));
	    		parteCat.stergeMonom(m);
	    	}
	    	Collections.sort(cat.getPoli());
	    	Collections.sort(rest.getPoli());
	    	m_rezultat = cat;
	    	m_rezultat2 = rest;
    	}
		return m_rezultat;
	}
	@Override
	public Polinom calculare(Polinom p) {
		return null;
	}
	public Polinom getM_rezultat() {
		return m_rezultat;
	}
	public void setM_rezultat(Polinom m_rezultat) {
		this.m_rezultat = m_rezultat;
	}
	public Polinom getM_rezultat2() {
		return m_rezultat2;
	}
	public void setM_rezultat2(Polinom m_rezultat2) {
		this.m_rezultat2 = m_rezultat2;
	}
}