package Operatii;

import java.util.Collections;
import MonomSiPolinom.Monom;
import MonomSiPolinom.Polinom;
public class Adunare implements Operatie {
	private Polinom m_rezultat;

	public Adunare(){
		m_rezultat = new Polinom();
	}
	@Override
	public Polinom calculare(Polinom p1, Polinom p2) {
	    	Polinom rezultat = new Polinom();
	    	Polinom suma = new Polinom();
	    	double coef = 0d;
	    	int putere = 0;
	    	for (Monom i : p1.poli)
	    	{
	    		coef = i.getCoeficient();
	    		putere = i.getPutere();
	    		for (Monom j : p2.poli)
	    		{
	    			if (i.getPutere() == j.getPutere())
	    				coef = i.getCoeficient()+j.getCoeficient();
	    		}
	    		suma.adaugaMonom(new Monom(coef,putere));
	    	}
	    	for (Monom j : p2.poli)
	    		if (!suma.contineMonom(j)) suma.adaugaMonom(new Monom(j.getCoeficient(),j.getPutere()));
	    	Collections.sort(suma.getPoli());
	    	for(Monom m : suma.getPoli())
	    		if (m.getCoeficient()!=0) rezultat.adaugaMonom(m);
	    	if (rezultat.esteGol()) suma.adaugaMonom(new Monom());
	        return rezultat;
		};
	@Override
	public Polinom calculare(Polinom p) {
		return null;
	}
}