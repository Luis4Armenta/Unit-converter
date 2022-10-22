package controllers;

import convertidordeunidades.ConvertidorDeUnidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UnitConverter;
import views.Vista;

public class ExitBtnController implements ActionListener{
    private Vista view;
    private UnitConverter model;
    
    public ExitBtnController(Vista view, UnitConverter model) {
        this.view = view;
        this.model = model;
        
        this.view.exitBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
