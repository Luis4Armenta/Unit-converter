package model.strategies.weight;

import model.strategies.IConvertionStrategy;
        
public class KilogramToGram implements IConvertionStrategy{

    @Override
    public double convert(double kilograms) {
        return kilograms * 1000;
    }
}
