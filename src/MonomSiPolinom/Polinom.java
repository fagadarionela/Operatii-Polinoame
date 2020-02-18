package MonomSiPolinom;
import java.util.*;
public class Polinom extends Monom {
	public ArrayList<Monom> poli = new ArrayList<Monom>();
	public Polinom(){
		super();
	}
	Polinom(int coef, int putere) {
		super(coef, putere);
		poli.add(new Monom(coef,putere));
	}
	public int grad() {							//se cauta gradul, adica cea mai mare putere din polinom
		int grad = 0;
		for (Monom m :this.poli) {
			if (grad < m.getPutere()) grad = m.getPutere();
		}
		return grad;
	}
	public boolean esteGol() {					//verificare daca e gol
		if(poli.isEmpty()) return true;
		else return false;
	};
	public ArrayList<Monom> getPoli() {
		return poli;
		}
	public void setPoli(ArrayList<Monom> poli) {
		this.poli = poli;
	}
	public void adaugaMonom(Monom m) {
		poli.add(m);
	}
	public void stergeMonom(Monom m) {
		poli.remove(m);
	}
	public boolean contineMonom(Monom m) {
		for (Monom i: poli)
		{
			if (i.getPutere() == m.getPutere()) return true;
		}
		return false;
	}
	public void goleste() {
		poli.clear();
	}
	public boolean eliminaDuplicate() {				//se elimina monoamele ce au aceeasi putere
		boolean elimina = false;
		for(int i=0;i<poli.size();i++)
			for(int j=i+1;j<poli.size()-1;j++)
			{
				if (this.poli.get(i).getPutere() == this.poli.get(j).getPutere())
				{
					this.poli.remove(j);
					elimina = true;
				}
			}
		return elimina;
	}
	public void copiaza(Polinom p) {
		this.goleste();
		for(Monom m:p.getPoli())
			this.adaugaMonom(m);
	}
	public boolean equals(Polinom p) {
		if (this.getPoli().size()!=p.getPoli().size())
			return false;
		for(int i = 0 ;i<this.getPoli().size() ;i++)
			if (this.getPoli().get(i).getCoeficient() != p.getPoli().get(i).getCoeficient() || this.getPoli().get(i).getPutere() != p.getPoli().get(i).getPutere())
				return false;
		return true;
	}
}