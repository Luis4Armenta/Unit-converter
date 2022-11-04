package controllers;

import javax.swing.DefaultComboBoxModel;
import model.UnitConverter;
import views.View;

public class Controller {
    private final UnitConverter model;
    private final View view;
    
    public Controller(View view, UnitConverter model) {
        this.model = model;
        this.view = view;
        
        
        this.setComportamentOfComponents();
        this.setDefaultSettings();
    }
    
    private void setComportamentOfComponents() {
        UnitTypesComboBoxController unitTypesComboBoxController = new UnitTypesComboBoxController(this.view, this.model);
        ConvertButtonController convertBtnController = new ConvertButtonController(this.view, this.model);
        ExitButtonController exitbtnController = new ExitButtonController(this.view, this.model);
        FromUnitComboBoxController from = new FromUnitComboBoxController(view, model);
        ToUnitComboBoxController to = new ToUnitComboBoxController(model, view);
        
        this.view.unitTypesComboBox.addActionListener(unitTypesComboBoxController);
        this.view.convertBtn.addActionListener(convertBtnController);
        this.view.exitBtn.addActionListener(exitbtnController);
        this.view.fromUnitComboBox.addActionListener(from);
        this.view.toUnitComboBox.addActionListener(to);
    }
    
    private void setDefaultSettings() {
        String[] unitTypes = this.model.getUnitTypes();
        this.view.unitTypesComboBox.setModel(new DefaultComboBoxModel<>(unitTypes));
        
        this.view.unitTypesComboBox.setSelectedItem(this.view.unitTypesComboBox.getSelectedItem());
    }
}
