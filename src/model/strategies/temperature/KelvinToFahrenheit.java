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
public class KelvinToFahrenheit implements IConvertionStrategy{

    @Override
    public double convert(double kelvins) {
        return ((9 *(kelvins - 273.15)) / 5) + 32;
    }
}
