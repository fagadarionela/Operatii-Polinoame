package Operatii;
import java.util.Collections;
import MonomSiPolinom.Monom;
import MonomSiPolinom.Polinom;
public class Scadere implements Operatie {
	private Polinom m_rezultat;
	public Scadere(){
		m_rezultat = new Polinom();
	}
	@Override
	public Polinom calculare(Polinom x, Polinom y) {
	    	m_rezultat.goleste();
	    	Polinom diferenta = new Polinom();
	    	double coef = 0d;
	    	int putere = 0;
	    	for (Monom i : x.poli)
	    	{
	    		coef = i.getCoeficient();
		    	putere = i.getPutere();
	    		for (Monom j : y.poli)
	    		{
	    			
	    			if (i.getPutere() == j.getPutere())
	    				coef = i.getCoeficient()-j.getCoeficient();
	    		}
	    		diferenta.adaugaMonom(new Monom(coef,putere));
	    	}
	    	for (Monom j : y.poli)
	    		if (!diferenta.contineMonom(j)) 
	    			diferenta.adaugaMonom(new Monom(-j.getCoeficient(),j.getPutere()));
	    	Collections.sort(diferenta.getPoli());
	    	for(Monom m : diferenta.getPoli())
	    		if (m.getCoeficient()!=0) m_rezultat.adaugaMonom(m);
	    	if (m_rezultat.esteGol()) m_rezultat.adaugaMonom(new Monom());
	        return m_rezultat;
	    };
	@Override
	public Polinom calculare(Polinom p) {
		return null;
	}
}