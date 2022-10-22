
package model.strategies.longitude;

import model.strategies.IConvertionStrategy;
        
public class FeetsToMiles implements IConvertionStrategy{

    @Override
    public double convert(double feets) {
        return feets / 5280;
    }
}
