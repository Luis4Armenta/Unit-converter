package convertidordeunidades;

import views.Vista;

public class ConvertidorDeUnidades {
    public static void main(String[] args) {
        String[] options = {"Longitud", "Superficie", "Volumen", "Peso", "Velocidad", "Temperatura"};
        
        Vista view = new Vista();
        
        view.unitTypesComboBox.removeAllItems();

        for (int i = 0; i < options.length; i++) {
            view.unitTypesComboBox.addItem("");
        }
        
        
        view.setVisible(true);
        view.setTitle("CONVERTIDOR DE UNIDADES");
        view.setLocationRelativeTo(null);
    }
    
}
