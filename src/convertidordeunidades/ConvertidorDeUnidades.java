package convertidordeunidades;

import views.Vista;
import model.UnitConverter;
import controllers.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.Front;

public class ConvertidorDeUnidades {
    public static void main(String[] args) {
        Front titlePage = new Front();
        
        titlePage.setVisible(true);
        titlePage.setTitle("Portada / Convertidor de unidades / Equipo 3");
        titlePage.setLocationRelativeTo(null);
        
        Vista view = new Vista();
        UnitConverter model = new UnitConverter();
        Controller controller = new Controller(view, model);
        
        view.setTitle("CONVERTIDOR DE UNIDADES");
        view.setLocationRelativeTo(null);
        
        titlePage.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titlePage.setVisible(false);
                view.setVisible(true);
            }
        });
    }
    
}
