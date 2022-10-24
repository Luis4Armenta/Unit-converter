package model.strategies.temperature;

import model.strategies.IConvertionStrategy;

public class KelvinToFahrenheit implements IConvertionStrategy{

    @Override
    public double convert(double kelvins) {
        return ((9 *(kelvins - 273.15)) / 5) + 32;
    }
}
