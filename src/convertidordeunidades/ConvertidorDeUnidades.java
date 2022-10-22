package convertidordeunidades;

import controllers.UnitTypesController;
import views.Vista;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import model.UnitConverter;
import controllers.IndexController;
import model.strategies.longitude.KilometersToMeters;

public class ConvertidorDeUnidades {
    public static void main(String[] args) {
        Vista view = new Vista();
        UnitConverter model = new UnitConverter();
        IndexController controller = new IndexController(view, model);
        
        //Contex context = new Contex(new KilometersToMeters(), view);
        
        
        view.setTitle("CONVERTIDOR DE UNIDADES");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
}
