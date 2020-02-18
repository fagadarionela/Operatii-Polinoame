package ModelSiController;
import GUI.PolinomView;
public class PolinomMVC {								//Model MVC
	 public static void main(String[] args) {
	        PolinomModel      model      = new PolinomModel();
	        PolinomView       view       = new PolinomView(model);
	        PolinomController controller = new PolinomController(model, view);
	        view.setVisible(true);
	 }
}
