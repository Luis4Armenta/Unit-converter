package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UnitConverter;
import views.View;

public class FromUnitComboBoxController implements ActionListener {
    private final View view;
    private final UnitConverter model;
    
    public FromUnitComboBoxController(View view, UnitConverter model) {
        this.model = model;
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String selection = this.view.fromUnitComboBox.getSelectedItem().toString();
        
        this.model.selectFromUnit(selection);
    }
    
}
