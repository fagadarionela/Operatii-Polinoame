package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import MonomSiPolinom.*;
import Operatii.*;
import Parsare.Parsare;

public class TestPolinom {
	
	@Test
	public void PolinomTest() {
		String s = "x^4+2*x^2-5*x+1";
		Polinom rezultat= new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(1,4));
		test.adaugaMonom(new Monom(2,2));
		test.adaugaMonom(new Monom(-5,1));
		test.adaugaMonom(new Monom(1,0));
		Parsare.converteste(rezultat, s);
		assertTrue(test.equals(rezultat));
	}
	@Test(expected= Exception.class)
	public void PolinomTestFail() {
		String s = "dx^4+2*x^2-5*x+1";
		Polinom pol = new Polinom();
		Parsare.converteste(pol, s);
	}
	@Test
	public void addPolinomTest() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(1,4));
		test.adaugaMonom(new Monom(1,2));
		test.adaugaMonom(new Monom(-4,1));
		Polinom rezultat = new Polinom();
		Parsare.converteste(p1, s1);
		Parsare.converteste(p2, s2);
		Adunare a = new Adunare();
		rezultat = a.calculare(p1, p2);
		assertTrue(test.equals(rezultat));
	}
	@Test
	public void addPolinomTestFail() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(-1,4));
		test.adaugaMonom(new Monom(-1,2));
		test.adaugaMonom(new Monom(4,1));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p1, s1);
			Parsare.converteste(p2, s2);
		Adunare a = new Adunare();
		rezultat = a.calculare(p1, p2);
		assertFalse(test.equals(rezultat));
	}
	
	@Test
	public void subPolinomTest() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(1,4));
		test.adaugaMonom(new Monom(3,2));
		test.adaugaMonom(new Monom(-6,1));
		test.adaugaMonom(new Monom(2,0));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p1, s1);
			Parsare.converteste(p2, s2);
		Scadere s = new Scadere();
		rezultat = s.calculare(p1, p2);
		assertTrue(test.equals(rezultat));
	}
	@Test
	public void subPolinomTestFail() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(1,5));
		test.adaugaMonom(new Monom(3,2));
		test.adaugaMonom(new Monom(-6,1));
		test.adaugaMonom(new Monom(2,0));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p1, s1);
			Parsare.converteste(p2, s2);
		Scadere s = new Scadere();
		rezultat = s.calculare(p1, p2);
		assertFalse(test.equals(rezultat));
	}
	@Test
	public void mulPolinomTest() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(-1,6));
		test.adaugaMonom(new Monom(1,5));
		test.adaugaMonom(new Monom(-3,4));
		test.adaugaMonom(new Monom(7,3));
		test.adaugaMonom(new Monom(-8,2));
		test.adaugaMonom(new Monom(6,1));
		test.adaugaMonom(new Monom(-1,0));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p1, s1);
			Parsare.converteste(p2, s2);
		Inmultire i= new Inmultire();
		rezultat = i.calculare(p1, p2);
		assertTrue(test.equals(rezultat));
	}
	@Test
	public void mulPolinomTestFail() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(-1,7));
		test.adaugaMonom(new Monom(1,5));
		test.adaugaMonom(new Monom(-3,4));
		test.adaugaMonom(new Monom(7,3));
		test.adaugaMonom(new Monom(-8,2));
		test.adaugaMonom(new Monom(6,1));
		test.adaugaMonom(new Monom(-1,0));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p1, s1);
			Parsare.converteste(p2, s2);
		Inmultire i= new Inmultire();
		rezultat = i.calculare(p1, p2);
		assertFalse(test.equals(rezultat));
	}
	@Test
	public void divPolinomTest() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom testCat = new Polinom();
		Polinom testRest = new Polinom();
		testCat.adaugaMonom(new Monom(-1,2));
		testCat.adaugaMonom(new Monom(-1,1));
		testCat.adaugaMonom(new Monom(-2,0));
		testRest.adaugaMonom(new Monom(-4,1));
		testRest.adaugaMonom(new Monom(-1,0));
		Polinom rezultatCat = new Polinom();
		Polinom rezultatRest = new Polinom();
			Parsare.converteste(p1, s1);
			Parsare.converteste(p2, s2);
		Impartire d= new Impartire();
		d.calculare(p1, p2);
		rezultatCat = d.getM_rezultat();
    	rezultatRest = d.getM_rezultat2();
		assertTrue(testCat.equals(rezultatCat));
		assertTrue(testRest.equals(rezultatRest));
	}
	@Test
	public void divPolinomTestFail() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom testCat = new Polinom();
		Polinom testRest = new Polinom();
		testCat.adaugaMonom(new Monom(-1,1));
		testCat.adaugaMonom(new Monom(-2,0));
		Polinom rezultatCat = new Polinom();
		Polinom rezultatRest = new Polinom();
			Parsare.converteste(p1, s1);
			Parsare.converteste(p2, s2);
		Impartire d= new Impartire();
		d.calculare(p1, p2);
		rezultatCat = d.getM_rezultat();
    	rezultatRest = d.getM_rezultat2();
		assertFalse(testCat.equals(rezultatCat));
		assertFalse(testRest.equals(rezultatRest));
	}
	
	@Test
	public void intPolinomTest1() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(0.2d,5));
		test.adaugaMonom(new Monom(0.6666666666666666d,3));
		test.adaugaMonom(new Monom(-2.5d,2));
		test.adaugaMonom(new Monom(1,1));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p1, s1);
		Integrare i= new Integrare();
		rezultat = i.calculare(p1);
		assertTrue(test.equals(rezultat));
	}
	
	@Test
	public void intPolinomTest1Fail() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(0.2d,4));
		test.adaugaMonom(new Monom(0.6666666666666666d,3));
		test.adaugaMonom(new Monom(-2.5d,2));
		test.adaugaMonom(new Monom(1,1));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p1, s1);
		Integrare i= new Integrare();
		rezultat = i.calculare(p1);
		assertFalse(test.equals(rezultat));
	}
	@Test
	public void intPolinomTest2() {
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(-0.3333333333333333d,3));
		test.adaugaMonom(new Monom(0.5d,2));
		test.adaugaMonom(new Monom(-1d,1));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p2, s2);
		Integrare i= new Integrare();
		rezultat = i.calculare(p2);
		assertTrue(test.equals(rezultat));
	}
	
	@Test
	public void intPolinomTest2Fail() {
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(-0.3333333333333333d,4));
		test.adaugaMonom(new Monom(0.5d,2));
		test.adaugaMonom(new Monom(-1d,1));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p2, s2);
		Integrare i= new Integrare();
		rezultat = i.calculare(p2);
		assertFalse(test.equals(rezultat));
	}
	
	@Test
	public void derivPolinomTest1() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(4,3));
		test.adaugaMonom(new Monom(4,1));
		test.adaugaMonom(new Monom(-5,0));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p1, s1);
		Derivare d= new Derivare();
		rezultat = d.calculare(p1);
		assertTrue(test.equals(rezultat));
	}
	
	@Test
	public void derivPolinomTest1Fail() {
		String s1 = "x^4+2*x^2-5*x+1";
		Polinom p1 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(4,4));
		test.adaugaMonom(new Monom(4,1));
		test.adaugaMonom(new Monom(-5,0));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p1, s1);
		Derivare d= new Derivare();
		rezultat = d.calculare(p1);
		assertFalse(test.equals(rezultat));
	}
	
	@Test
	public void derivPolinomTest2() {
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(-2,1));
		test.adaugaMonom(new Monom(1,0));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p2, s2);
		Derivare d= new Derivare();
		rezultat = d.calculare(p2);
		assertTrue(test.equals(rezultat));
	}
	
	@Test
	public void derivPolinomTest2Fail() {
		String s2 = "-x^2+x-1";
		Polinom p2 = new Polinom();
		Polinom test = new Polinom();
		test.adaugaMonom(new Monom(4,4));
		test.adaugaMonom(new Monom(4,1));
		test.adaugaMonom(new Monom(-5,0));
		Polinom rezultat = new Polinom();
			Parsare.converteste(p2, s2);
		Derivare d= new Derivare();
		rezultat = d.calculare(p2);
		assertFalse(test.equals(rezultat));
	}
}
