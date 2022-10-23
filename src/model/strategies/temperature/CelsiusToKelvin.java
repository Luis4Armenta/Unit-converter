/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.strategies.temperature;

import model.strategies.IConvertionStrategy;

/**
 *
 * @author luigi
 */
public class CelsiusToKelvin implements IConvertionStrategy{
    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }
}
