package convertidordeunidades;

import views.View;
import model.UnitConverter;
import controllers.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.Front;

public class ConvertidorDeUnidades {
    public static void main(String[] args) {
        Front titlePage = new Front();
        
        titlePage.setVisible(true);

        View view = new View();
        UnitConverter model = new UnitConverter();
        Controller controller = new Controller(view, model);
        
        titlePage.continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titlePage.setVisible(false);
                view.setVisible(true);
            }
        });
    }
    
}
