package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UnitConverter;
import views.Vista;

public class FromComboBoxController implements ActionListener {
    private Vista view;
    private UnitConverter model;
    
    public FromComboBoxController(Vista view, UnitConverter model) {
        this.model = model;
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String selection = this.view.fromUnitComboBox.getSelectedItem().toString();
        
        this.model.selectFromUnit(selection);
    }
    
}
