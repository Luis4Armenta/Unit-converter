package controllers;

import javax.swing.DefaultComboBoxModel;
import model.UnitConverter;
import views.Vista;

public class IndexController {
    private final UnitConverter model;
    private final Vista view;
    
    public IndexController(Vista view, UnitConverter model) {
        this.model = model;
        this.view = view;
        
        this.setComportamentOfComponents();
        this.setDefaultSettings();
    }
    
    private void setComportamentOfComponents() {
        UnitTypesController unitTypesComboBoxController = new UnitTypesController(this.view, this.model);
        ConvertBtnController convertBtnController = new ConvertBtnController(this.view, this.model);
        ExitBtnController exitbtnController = new ExitBtnController(this.view, this.model);
        
        this.view.unitTypesComboBox.addActionListener(unitTypesComboBoxController);
        this.view.convertBtn.addActionListener(convertBtnController);
        this.view.exitBtn.addActionListener(exitbtnController);
    }
    
    private void setDefaultSettings() {
        //this.model.selectUnitType("Longitud");
        //this.view.unitTypesComboBox.setSelectedItem("Longitud");
        
        String first = this.view.unitTypesComboBox.getSelectedItem().toString();
        this.model.selectUnitType(first);
        
        String[] units = this.model.getUnits();
        
        this.view.fromUnitComboBox.removeAllItems();
        this.view.fromUnitComboBox.setModel(new DefaultComboBoxModel<>(units));
        
        this.view.toUnitComboBox.removeAllItems();
        this.view.toUnitComboBox.setModel(new DefaultComboBoxModel<>(units));
    }
}
