package model.strategies.weight;

import model.strategies.IConvertionStrategy;
        
public class GramsToPounds implements IConvertionStrategy{

    @Override
    public double convert(double grams) {
        return grams / 453.6;
    }
}

