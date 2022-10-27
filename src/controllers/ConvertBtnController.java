package controllers;

import model.UnitConverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import views.Vista;


public class ConvertBtnController implements ActionListener{
    Vista view;
    UnitConverter model;
    
    public ConvertBtnController(Vista view, UnitConverter model) {
        this.view = view;
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double inputValue = Double.parseDouble(view.inputFieldText.getText());

            this.model.setValueToConvert(inputValue);

            String from = view.fromUnitComboBox.getSelectedItem().toString();
            String to = view.toUnitComboBox.getSelectedItem().toString();

            this.model.selectFromUnit(from);
            this.model.selectToUnit(to);
            
            this.model.setValueToConvert(inputValue);
            
            double result = this.model.getConversion();
           //new DecimalFormat("#.000").format(result)
            view.outputFieldText.setText(String.valueOf(result));
        } catch (Exception error) {
            if (error instanceof NumberFormatException) {
                String messageError = "Por favor, introduce únicamente números...";
                JOptionPane.showMessageDialog(this.view, messageError, "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
}