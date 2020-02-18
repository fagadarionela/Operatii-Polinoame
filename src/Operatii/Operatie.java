package Operatii;
import MonomSiPolinom.Polinom;
public interface Operatie {
	Polinom calculare(Polinom p1, Polinom p2);
	Polinom calculare(Polinom p);
}