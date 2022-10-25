package model;

import java.util.HashMap;
import java.util.*;

public class UnitConverter {
    private HashMap<String, String[]> unitTypes = new HashMap<>();
    HashMap<String, Double> conversionRates = new HashMap<>();
    
    private String unitTypeSelected;
    
    private double inputValue;
    private double conversion;
    
    private String fromUnit;
    private String toUnit;

    public UnitConverter() {
        this.init();
    }
    
    private void init() {
        this.setUnitTypes();
        this.loadRates();
    }
    
    public void selectUnitType(String unitTypeToChange) {
        this.unitTypeSelected = unitTypeToChange;
    }
    
    public void selectFromUnit(String fromUnitSelected) {
        this.fromUnit = fromUnitSelected;
    }
    
    public void selectToUnit(String toUnitSelected) {
        this.toUnit = toUnitSelected;
    }
    
    public void setValueToConvert(double value) {
        this.inputValue = value;
    }
    
    public double getConversion() {
        this.conversion = this.convert();
        
        return conversion;
    }
    
    public double convert() {
        double rate = this.conversionRates.get(this.fromUnit + "-" + this.toUnit);
        return this.inputValue * rate;
    }
    
    public String[] getUnitTypes() {
        Set<String> keys = this.unitTypes.keySet();
        String[] arr =keys.toArray(new String[keys.size()]);
        
        return arr;
    }
    
    public String[] getUnits() {
        return this.unitTypes.get((this.unitTypeSelected));
    }
    
    private void setUnitTypes() {
        String[] longitudesOptions = {"Kilometro", "Metros", "Centimetros", "Milimeters", 
                            "Miles", "Yards", "Feets", "inches"};
        String[] weightOptions = {"Tons", "Kilograms", "Grams", "Pounds"};
        String[] temperatureOptions = {"Celsius", "Kelvin", "Fahrenheit"};
        
        this.unitTypes.put("Longitud", longitudesOptions);
        this.unitTypes.put("Peso", weightOptions);
        this.unitTypes.put("Temperatura", temperatureOptions);
    }
    
    private void loadRates() {
        this.conversionRates.put("Kilometros-Metros", new Double(1000));
        this.conversionRates.put("Kilometros-centimetros", new Double(1000 * 100));
    }
}
