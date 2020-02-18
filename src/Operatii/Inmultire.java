package Operatii;

import java.util.Collections;
import MonomSiPolinom.Monom;
import MonomSiPolinom.Polinom;

public class Inmultire implements Operatie {
	private Polinom m_rezultat;
	public Inmultire(){
		m_rezultat = new Polinom();
	}
	@Override
	public Polinom calculare(Polinom x, Polinom y) {
		m_rezultat.goleste();
    	Polinom produs = new Polinom();
    	double coef = 0d;
    	int putere = 0;
    	for (Monom i : x.poli)		//se inmultesc toti monomii din p1 cu cei din p2
    	{
    		for (Monom j : y.poli)
    		{
    				coef = i.getCoeficient() * j.getCoeficient();
    				putere = i.getPutere() + j.getPutere();
    				produs.adaugaMonom(new Monom(coef,putere));
    		}
    	}
    	Collections.sort(produs.getPoli());		//se sorteaza, ca sa fie mai usor
    	for(Monom m1 : produs.getPoli())		//se verifica daca exista monoame cu puteri egale, si se aduna
    	{
    		coef = m1.getCoeficient();
    		putere = m1.getPutere();
    		for (Monom m2 : produs.getPoli())
    			if (m1 != m2 && m1.getPutere() == m2.getPutere()) 
    				coef += m2.getCoeficient();
    		if (coef != 0) m_rezultat.adaugaMonom(new Monom(coef,putere));		//se adauga polinoame doar daca nu au coef "0" -se evita un rez de forma "0*x"
    	}
    	if (m_rezultat.esteGol()) m_rezultat.adaugaMonom(new Monom());		//daca rez e gol, se introduce polinomul nul
    	else while(m_rezultat.eliminaDuplicate());							//altfel, se elimina duplicatele
        return m_rezultat;
	}
	@Override
	public Polinom calculare(Polinom p) {
		return null;
	}
}