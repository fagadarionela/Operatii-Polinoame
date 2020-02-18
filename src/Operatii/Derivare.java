package Operatii;
import java.util.Collections;
import MonomSiPolinom.Monom;
import MonomSiPolinom.Polinom;
public class Derivare implements Operatie {
	private Polinom m_rezultat;
	public Derivare(){
		m_rezultat = new Polinom();
	}
	@Override
	public Polinom calculare(Polinom x) {
		m_rezultat.goleste();
		Collections.sort(x.getPoli());	
    	for (Monom i : x.poli)
    		if(i.getPutere() != 0) m_rezultat.adaugaMonom(new Monom(i.getCoeficient()*i.getPutere(),i.getPutere()-1));
    	if (m_rezultat.esteGol()) m_rezultat.adaugaMonom(new Monom());
        return m_rezultat;
	}
	@Override
	public Polinom calculare(Polinom x, Polinom y) {
		return null;
	}
}