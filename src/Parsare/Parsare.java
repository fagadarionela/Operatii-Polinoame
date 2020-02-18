package Parsare;
import MonomSiPolinom.Monom;
import MonomSiPolinom.Polinom;
public class Parsare{
	public static void gasireMonomCuAceeasiPutere(Monom m, Polinom p) {
		boolean gasit = false;
		for(Monom mon: p.getPoli())
		{
			if (mon.getPutere() == m.getPutere())	
			{
				mon.setCoeficient(m.getCoeficient()+mon.getCoeficient());		//se aduna coeficientii pt monoamele de puteri egale, ca "x+x"
				gasit = true;
			}
		}
		if (gasit == false) p.adaugaMonom(m);									//altfel, se adauga normal
	}
	public static void converteste(Polinom p,String s1){
		s1 = s1.replace("-", "+-");							//se inlocuieste minus cu plusminus
		if (s1.length()>1 && s1.charAt(1) == '-') 			//daca stringul incepea cu "-",inseamna ca dupa etapa precedenta insepe cu "+-"
			s1 = s1.substring(1);							//se taie primul element din sir
		String[] subs = s1.split("\\+");					//se imparte dupa "+"
		String coef = "";
		String putere = "";
		for(int i=0;i<subs.length;i++){
			putere = "";
			coef = "";
			int pozInm = subs[i].indexOf("*");				//se cauta "*"
			if (pozInm != -1) 								//daca se gaseste:
				coef = subs[i].substring(0,pozInm);			//se gaseste,inseamna ca coeficientul reprezinta substringul pana la poz "*"
			else {											//nu se gaseste "*":
				if(subs[i].indexOf("x")==-1){				//se cauta "x"
					putere  = "0";							//nu se gaseste,inseamna ca substringul e doar un coeficient
					coef = subs[i];
					}
				else {										//se gaseste "x":
					if (subs[i].indexOf("x") == 1 && subs[i].indexOf("-") == 0) coef = "-1";		//se verifica daca substringul e "-x"
					else if(subs[i].indexOf("x") == 0) coef = "1";									//altfel stringul e "x"
				}
			}
			int pozPutere = subs[i].indexOf("^");			//se cauta "^"
			if (pozPutere != -1) putere = subs[i].substring(pozPutere+1,subs[i].length());		//daca se gaseste, puterea e de la poz "*"+1 la sfarsit
			else if (!putere.equals("0")) putere = "1";											//daca nu se gaseste, substringul putea fi "2*x" sau "2". Se verifica daca puterea e "0", altfel e "1"	
			Monom m = new Monom(Integer.parseInt(coef),Integer.parseInt(putere));
			gasireMonomCuAceeasiPutere(m,p);				//se trateaza cazul cand introducem "x+x"
		}
	}
}