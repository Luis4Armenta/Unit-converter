package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import views.Vista;
import model.UnitConverter;

public class UnitTypesController implements ActionListener{
    Vista view;
    UnitConverter model;
    
    public UnitTypesController(Vista view, UnitConverter model) {
        this.view = view;
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       String unitTypeSelected = this.view.unitTypesComboBox.getSelectedItem().toString();
       
       this.model.selectUnitType(unitTypeSelected);
       
       String[] units = this.model.getUnits();
       
       this.view.fromUnitComboBox.setModel(new DefaultComboBoxModel<>(units));
       this.view.toUnitComboBox.setModel(new DefaultComboBoxModel<>(units));
       
       this.model.selectFromUnit(units[0]);
       this.model.selectToUnit(units[0]);
    }
    
}
