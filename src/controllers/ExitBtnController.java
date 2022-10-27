package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UnitConverter;
import views.Vista;

public class ExitBtnController implements ActionListener{
    private final Vista view;
    private final UnitConverter model;
    
    public ExitBtnController(Vista view, UnitConverter model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
