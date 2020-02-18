package ModelSiController;
import MonomSiPolinom.*;
import Operatii.Adunare;
import Operatii.Derivare;
import Operatii.Impartire;
import Operatii.Inmultire;
import Operatii.Integrare;
import Operatii.Scadere;
public class PolinomModel {
	static final int INITIAL_VALUE =0;
	private Polinom m_rezultat; 
	private Polinom m_rezultat2;
    public PolinomModel() {
        reset();
    }
    public void reset() {
        m_rezultat = new Polinom();
        m_rezultat2 = new Polinom();
    }
    public Polinom add(Polinom p1,Polinom p2) {
    	reset();
    	Adunare a = new Adunare();
    	m_rezultat =a.calculare(p1,p2);
    	return m_rezultat;
    }
    public Polinom sub(Polinom x,Polinom y) {
    	reset();
    	Scadere s = new Scadere();
    	m_rezultat = s.calculare(x,y);
    	return m_rezultat;
    }
    public Polinom mul(Polinom x, Polinom y) {
    	reset();
    	Inmultire m = new Inmultire();
    	m_rezultat = m.calculare(x,y);
    	return m_rezultat;
	}
	public Polinom div(Polinom x, Polinom y) {
		reset();
    	Impartire d = new Impartire();
    	d.calculare(x,y);
    	m_rezultat = d.getM_rezultat();
    	m_rezultat2 = d.getM_rezultat2();
    	return m_rezultat;
	}
    public Polinom deriv(Polinom x) {
    	reset();
    	Derivare deriv = new Derivare();
    	m_rezultat = deriv.calculare(x);
    	
    	return m_rezultat;
    }
    public Polinom integrala(Polinom x) {
    	reset();
    	Integrare i= new Integrare();
    	m_rezultat = i.calculare(x);
    	return m_rezultat;
    }
    public void setValue(Polinom value) {
        m_rezultat = value;
    }
    public void setValue2(Polinom value) {
        m_rezultat2 = value;
    }
    public static double round(double nr, int zecimale) {
        if (zecimale < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, zecimale);
        nr = nr * factor;
        long aux = Math.round(nr);
        return (double) aux / factor;
    }
    public String monomToString(String s,Monom m) {
    	if(m.getCoeficient() == 1)																//daca coeficientul e 1,nu se afiseaza "1*x"
			if (m.getPutere()>1) s = s+"x^"+m.getPutere();										//x are puterea mai mare ca 1
			else if( m.getPutere() == 1) s = s+"x";												//x are puterea 1
			else  s = s+"1";																	//x e un coeficient
		else if(m.getCoeficient() == -1)														//daca coeficientul e -1, nu se afiseaza "-1*x", ci "-x"
			if (m.getPutere()>1) s = s+"-x^"+m.getPutere();										
			else if( m.getPutere() == 1) s = s+"-x";
			else  s = s+"-1";
		else 																					//daca coeficientul e un numar, se afiseaza "nr*x", cu doua zecimale
			if (m.getPutere()>1) s = s+round(m.getCoeficient(),2)+"*x^"+m.getPutere();
			else if( m.getPutere() == 1) s = s+round(m.getCoeficient(),2)+"*x";
			else  s = s+round(m.getCoeficient(),2);
    	return s;
    }
    public String getValue() {												//formare String pt afisare
    	String s="";
    	int nr=0;
    	for (Monom m: m_rezultat.poli)
    		if (m.getCoeficient()<0 || (m.getCoeficient()>0 && nr==0)) {	//in caz ca coeficientul e negativ,sau e primul termen, sa nu se afiseze si "+"
    			s = monomToString(s,m);
    			nr++;
    		}
    		else
    		{
    			s = s+ "+";
    			s = monomToString(s,m);
    		}
    	if (s.equals("")) s="0";											//daca Stringul e vid, se atribuie valoarea zero
        return s;
    }
    public String getValue2() {
    	String s="";
    	int nr=0;
    	for (Monom m: m_rezultat2.poli)
    		if (m.getCoeficient()<0 || (m.getCoeficient()>0 && nr==0)) {	//in caz ca coeficientul e negativ,sau e primul termen, sa nu se afiseze si "+"
    			s = monomToString(s,m);
    			nr++;
    		}
    		else
    		{
    			s = s+ "+";
    			s = monomToString(s,m);
    		}
    	if (s.equals("")) s="0";											//daca Stringul e vid, se atribuie valoarea zero
        return s;
    }
}
