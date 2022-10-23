package controllers;

import model.UnitConverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
        double inputValue = Double.parseDouble(view.inputFieldText.getText());
        
        this.model.setValueToConvert(inputValue);
        
        String from = view.fromUnitComboBox.getSelectedItem().toString();
        String to = view.toUnitComboBox.getSelectedItem().toString();
        
        this.model.selectFromUnit(from);
        this.model.selectToUnit(to);
        
        double result = this.model.getConversion();

        view.outputFieldText.setText(String.valueOf(new DecimalFormat("#.000").format(result)));
    }
    
}