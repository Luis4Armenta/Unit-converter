package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UnitConverter;
import views.Vista;

public class ExitButtonController implements ActionListener{
    private final Vista view;
    private final UnitConverter model;
    
    public ExitButtonController(Vista view, UnitConverter model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
