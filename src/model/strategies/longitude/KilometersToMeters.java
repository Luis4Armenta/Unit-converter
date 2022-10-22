package model.strategies.longitude;

import model.strategies.IConvertionStrategy;

public class KilometersToMeters implements IConvertionStrategy {

    @Override
    public double convert(double kilometers) {
        return kilometers * 1000;
    }
}
