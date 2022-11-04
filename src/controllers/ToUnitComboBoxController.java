package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UnitConverter;
import views.View;

public class ToUnitComboBoxController implements ActionListener {
    private final View view;
    private final UnitConverter model;
    
    public ToUnitComboBoxController(UnitConverter model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selection = this.view.toUnitComboBox.getSelectedItem().toString();
        
        this.model.selectToUnit(selection);
    }
}
