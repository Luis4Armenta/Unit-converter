package model.strategies.weight;

import model.strategies.IConvertionStrategy;
        
public class GramToKilogram implements IConvertionStrategy{

    @Override
    public double convert(double feets) {
        return feets / 1000;
    }
}
