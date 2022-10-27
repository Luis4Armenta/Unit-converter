package convertidordeunidades;

import views.Vista;
import model.UnitConverter;
import controllers.Controller;

public class ConvertidorDeUnidades {
    public static void main(String[] args) {
        Vista view = new Vista();
        UnitConverter model = new UnitConverter();
        Controller controller = new Controller(view, model);
        
        view.setTitle("CONVERTIDOR DE UNIDADES");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
}
