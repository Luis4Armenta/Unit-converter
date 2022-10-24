package model.strategies.temperature;

import model.strategies.IConvertionStrategy;

public class KelvinToCelsius implements IConvertionStrategy{

    @Override
    public double convert(double kelvins) {
        return kelvins - 273.15;
    }
    
}
