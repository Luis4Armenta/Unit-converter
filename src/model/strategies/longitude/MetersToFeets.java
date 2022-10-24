package model.strategies.longitude;

import model.strategies.IConvertionStrategy;

public class MetersToFeets implements IConvertionStrategy {

    @Override
    public double convert(double meters) {
        return meters * 3.281;
    }
}
