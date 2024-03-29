package controllers;

import model.UnitConverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import views.View;


public class ConvertButtonController implements ActionListener{
    private final View view;
    private final UnitConverter model;
    
    public ConvertButtonController(View view, UnitConverter model) {
        this.view = view;
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double inputValue = Double.parseDouble(view.inputFieldText.getText());

            String unitTypeSelected = this.view.unitTypesComboBox.getSelectedItem().toString();
            
            if (inputValue < 0 && !unitTypeSelected.equals("Temperatura")) {
                JOptionPane.showMessageDialog(
                        this.view,
                        "Estimado usuario, algunas unidades no pueden ser negativas...",
                        "Input invalido",
                        JOptionPane.WARNING_MESSAGE
                );
             
                return;
            }
            
            this.model.setInput(inputValue);
            double result = this.model.getOutput();
            
            view.outputFieldText.setText(String.format("%.4f", result));
        } catch (NumberFormatException error) {
            System.err.println(error);
            String messageError = "Por favor, introduce únicamente números...";
            JOptionPane.showMessageDialog(this.view, messageError, "Error", JOptionPane.WARNING_MESSAGE);
        } catch (Exception error) {
            System.err.println(error);
            JOptionPane.showMessageDialog(this.view, error, "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}