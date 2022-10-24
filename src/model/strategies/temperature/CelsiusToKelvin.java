package model.strategies.temperature;

import model.strategies.IConvertionStrategy;

public class CelsiusToKelvin implements IConvertionStrategy{
    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }
}
