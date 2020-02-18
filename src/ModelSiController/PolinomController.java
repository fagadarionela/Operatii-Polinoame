package ModelSiController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.PolinomView;
import MonomSiPolinom.*;
import Parsare.Parsare;
public class PolinomController {
	private PolinomModel m_model;
    private PolinomView  m_view;
    PolinomController(PolinomModel model, PolinomView view) {
        m_model = model;
        m_view  = view;
        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addMulListener(new MulListener());
        view.addDivListener(new DivListener());
        view.addDerivListener1(new DerivListener1());
        view.addIntListener1(new IntListener1());
        view.addDerivListener2(new DerivListener2());
        view.addIntListener2(new IntListener2());
        view.addClearListener(new ClearListener());
    }
    class AddListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String input1s = "";									//initializare Stringuri si polinoame
    		String input2s = "";
    		Polinom p1 = new Polinom();
    		Polinom p2 = new Polinom();
    		try {
    			input1s = m_view.getPolinom1();						//se extrage polinomul1 introdus in primul textbox
    			input2s = m_view.getPolinom2();						//se extrage polinomul2 introdus in al doilea textbox
    			Parsare.converteste(p1,input1s);					//se parseaza p1
    			Parsare.converteste(p2,input2s);					//se parseaza p2
    			m_model.add(p1, p2);								//se aduna polinoamele
    			m_view.setRezultat(m_model.getValue());				//se seteza rezultatul cu valoarea corespunzatoare sumei
    			m_view.setRezultat2("0");							//se pune restul pe 0
    		}
    		catch(NumberFormatException nfex) {
    			m_view.showError("Bad Input");						//daca se introduce un String (polinom) gresit, se intercepteaza o exceptie
    		}
    	}
    }
    class SubListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String input1s = "";
    		String input2s = "";
    		Polinom p1 = new Polinom();
    		Polinom p2 = new Polinom();
    		try {
    			input1s = m_view.getPolinom1();    
    			input2s = m_view.getPolinom2();
    			Parsare.converteste(p1,input1s);
    			Parsare.converteste(p2,input2s);
    			m_model.sub(p1, p2);
    			m_view.setRezultat(m_model.getValue());
    			m_view.setRezultat2("0");
    		}
    		catch(NumberFormatException nfex) {
    			m_view.showError("Bad Input");
    		}
    	}
    }
    class MulListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String input1s = "";
    		String input2s = "";
    		Polinom p1 = new Polinom();
    		Polinom p2 = new Polinom();
    		try {
    			input1s = m_view.getPolinom1();
    			input2s = m_view.getPolinom2();
    			Parsare.converteste(p1,input1s);
    			Parsare.converteste(p2,input2s);
    			m_model.mul(p1, p2);
    			m_view.setRezultat(m_model.getValue());
    			m_view.setRezultat2("0");
    		}
    		catch(NumberFormatException nfex) {
    			m_view.showError("Bad Input");
    		}
    	}
    }
    class DivListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String input1s = "";
    		String input2s = "";
    		Polinom p1 = new Polinom();
    		Polinom p2 = new Polinom();
    		try {
    			input1s = m_view.getPolinom1();
    			input2s = m_view.getPolinom2();
    			Parsare.converteste(p1,input1s);
    			Parsare.converteste(p2,input2s);
    			m_model.div(p1, p2);
    			m_view.setRezultat(m_model.getValue());
    			m_view.setRezultat2(m_model.getValue2());
    		}
    		catch(NumberFormatException nfex) {
    			m_view.showError("Bad Input");
    		}
    		catch (IllegalArgumentException z)
    		{
    			m_view.showError(z.getMessage());
    		}
    	}
    }
    class DerivListener1 implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String input1s = "";
    		Polinom p1 = new Polinom();
    		try {
    			input1s = m_view.getPolinom1();
    			Parsare.converteste(p1,input1s);
    			m_model.deriv(p1);
    			m_view.setRezultat(m_model.getValue());
    			m_view.setRezultat2("0");
    		}
    		catch(NumberFormatException nfex) {
    			m_view.showError("Bad Input");
    		}
    	}
    }
    class IntListener1 implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String input1s = "";
    		Polinom p1 = new Polinom();
    		try {
    			input1s = m_view.getPolinom1();
    			Parsare.converteste(p1,input1s);
    			m_model.integrala(p1);
    			m_view.setRezultat(m_model.getValue());
    			m_view.setRezultat2("0");
    		}
    		catch(NumberFormatException nfex) {
    			m_view.showError("Bad Input");
    		}
    	}
    }
    class DerivListener2 implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String input2s = "";
    		Polinom p2 = new Polinom();
    		try {
    			input2s = m_view.getPolinom2();
    			Parsare.converteste(p2,input2s);
    			m_model.deriv(p2);
    			m_view.setRezultat(m_model.getValue());
    			m_view.setRezultat2("0");
    		}
    		catch(NumberFormatException nfex) {
    			m_view.showError("Bad Input");
    		}
    	}
    }
    class IntListener2 implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String input2s = "";
    		Polinom p2 = new Polinom();
    		try {
    			input2s = m_view.getPolinom2();
    			Parsare.converteste(p2,input2s);
    			m_model.integrala(p2);
    			m_view.setRezultat(m_model.getValue());
    			m_view.setRezultat2("0");
    		}
    		catch(NumberFormatException nfex) {
    			m_view.showError("Bad Input");
    		}
    	}
    }
    class ClearListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		try {												//reset
    			m_view.setRezultat("0");						//se sterge rezultatul
    			m_view.setRezultat2("0");						//se sterge restul
    		}
    		catch(NumberFormatException nfex) {
    			m_view.showError("Bad Input");
    		}
    	}
    }
}