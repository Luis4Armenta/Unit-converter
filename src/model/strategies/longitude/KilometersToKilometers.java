package model.strategies.longitude;

import model.strategies.IConvertionStrategy;

public class KilometersToKilometers implements IConvertionStrategy{
    @Override
    public double convert(double kilometers) {
        return kilometers;
    }
}
