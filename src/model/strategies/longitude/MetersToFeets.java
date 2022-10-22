/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.strategies.longitude;

import model.strategies.IConvertionStrategy;

/**
 *
 * @author luigi
 */
public class MetersToFeets implements IConvertionStrategy {

    @Override
    public double convert(double meters) {
        return meters * 3.281;
    }
}
