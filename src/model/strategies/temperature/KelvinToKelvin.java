package model.strategies.temperature;

import model.strategies.IConvertionStrategy;

public class KelvinToKelvin implements IConvertionStrategy{

    @Override
    public double convert(double kelvins) {
        return kelvins;
    }
    
}
