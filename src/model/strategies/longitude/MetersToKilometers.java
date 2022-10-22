
package model.strategies.longitude;

import model.strategies.IConvertionStrategy;
        
public class MetersToKilometers implements IConvertionStrategy{

    @Override
    public double convert(double meters) {
        return meters / 1000;
    }
}
