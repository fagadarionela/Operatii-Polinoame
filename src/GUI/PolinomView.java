package GUI;
import java.awt.*;
import javax.swing.*;
import ModelSiController.PolinomModel;
import java.awt.event.*;
public class PolinomView extends JFrame {
    private JTextField m_polinom1 = new JTextField(20);
    private JTextField m_polinom2 = new JTextField(20);
    private JTextField m_rezultat     = new JTextField(30);
    private JTextField m_rezultat2     = new JTextField(20);
    private JButton    m_mulBtn = new JButton("*");
    private JButton    m_addBtn = new JButton("+");
    private JButton	   m_subBtn = new JButton("-");
    private JButton    m_divBtn = new JButton("/");
    private JButton    m_derivBtn1 = new JButton("'");
    private JButton    m_intBtn1 = new JButton("|");
    private JButton    m_derivBtn2 = new JButton("'");
    private JButton    m_intBtn2 = new JButton("|");
    private JButton    m_clearBtn    = new JButton("Clear");
    private PolinomModel m_model;
    public PolinomView(PolinomModel model) {
        m_model = model;
        m_rezultat.setText(m_model.getValue());			//se initializeaza valoarea rezultatului
        m_rezultat.setEditable(false);					//nu se poate edita
        m_rezultat2.setText(m_model.getValue2());		//se initilizeaza valoarea restului
        m_rezultat2.setEditable(false);    				//nu se poate edita
        JPanel content = new JPanel();					
        content.setLayout(new FlowLayout());			
        content.add(m_intBtn1);							//inserare butoane, etichete
        content.add(new JLabel("Polinom1:"));
        content.add(m_polinom1);
        content.add(m_derivBtn1);
        content.add(m_addBtn);
        content.add(m_subBtn);
        content.add(m_mulBtn);
        content.add(m_divBtn);
        content.add(m_intBtn2);
        content.add(new JLabel("Polinom2:"));
        content.add(m_polinom2);
        content.add(m_derivBtn2);
        content.add(new JLabel("Rezultat"));
        content.add(m_rezultat);
        content.add(new JLabel("Rest"));
        content.add(m_rezultat2);
        content.add(m_clearBtn);
        this.setContentPane(content);
        this.pack();
        this.setTitle("Calculator polinoame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void reset() {
        m_rezultat.setText("0");
        m_rezultat2.setText("0");
    }
    public String getPolinom1() {
        return m_polinom1.getText();
    }
    public String getPolinom2() {
        return m_polinom2.getText();
    }
    public void setRezultat(String newRezultat) {
    	m_rezultat.setText(newRezultat);
    }
    public void setRezultat2(String newRezultat) {
    	m_rezultat2.setText(newRezultat);
    }
    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    public void addMulListener(ActionListener mal) {
        m_mulBtn.addActionListener(mal);
    }
    public void addAddListener(ActionListener add) {
        m_addBtn.addActionListener(add);
    }
    public void addSubListener(ActionListener sub) {
    	m_subBtn.addActionListener(sub);
    }
    public void addDivListener(ActionListener div) {
    	m_divBtn.addActionListener(div);
    }
    public void addDerivListener1(ActionListener deriv) {
    	m_derivBtn1.addActionListener(deriv);
    }
    public void addIntListener1(ActionListener integ) {
    	m_intBtn1.addActionListener(integ);
    }
    public void addDerivListener2(ActionListener deriv) {
    	m_derivBtn2.addActionListener(deriv);
    }
    public void addIntListener2(ActionListener integ) {
    	m_intBtn2.addActionListener(integ);
    }
    public void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}
