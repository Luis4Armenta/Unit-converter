/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.ConvertBtnController;
import controllers.ExitBtnController;
import controllers.UnitTypesController;
import model.UnitConverter;
import views.Vista;

public class IndexController {
    private UnitConverter model;
    private Vista view;
    
    public IndexController(Vista view, UnitConverter model) {
        this.model = model;
        this.view = view;
        
        this.setComportamentOfComponents();
    }
    
    private void setComportamentOfComponents() {
        UnitTypesController unitTypesComboBoxController = new UnitTypesController(this.view, this.model);
        ConvertBtnController convertBtnController = new ConvertBtnController(this.view, this.model);
        ExitBtnController exitbtnController = new ExitBtnController(this.view, this.model);
        
        this.view.unitTypesComboBox.addActionListener(unitTypesComboBoxController);
        this.view.convertBtn.addActionListener(convertBtnController);
        this.view.exitBtn.addActionListener(exitbtnController);
    }
}
