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
        FromComboBoxController from = new FromComboBoxController(view, model);
        ToComboBoxController to = new ToComboBoxController(model, view);
        
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
