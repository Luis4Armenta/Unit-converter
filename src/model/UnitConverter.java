package model;


import java.util.HashMap;
import java.util.*;
import model.strategies.IConvertionStrategy;
import model.strategies.longitude.FeetsToMiles;
import model.strategies.longitude.KilometersToKilometers;
import model.strategies.longitude.KilometersToMeters;
import model.strategies.longitude.MetersToFeets;
import model.strategies.longitude.MetersToKilometers;
import model.strategies.weight.GramToKilogram;
import model.strategies.weight.GramsToPounds;
import model.strategies.weight.KilogramToGram;


public class UnitConverter {
    private HashMap<String, String[]> unitTypes = new HashMap<>();
    
    private HashMap<String, HashMap<String, IConvertionStrategy>> handlers = new HashMap<>();

    
    //private String[] unitTypes = {"Longitud", "Superficie", "Volumen", "Peso", "Velocidad", "Temperatura"};
    private String unitTypeSelected;
    
    private String[] units;
    
    private double value;
    private double conversion;
    
    private String fromUnit;
    private String toUnit;
    
    private IConvertionStrategy strategy;

    public UnitConverter() {
        this.unitTypeSelected = "Longitud";
        this.init();
        this.strategy = new KilometersToKilometers();
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
        this.value = value;
    }
    
    public double getConversion() {
        this.conversion = this.convert();
        
        return conversion;
    }
    
    public double convert() {
        String conversionKey = this.fromUnit + " to " + this.toUnit;
        System.out.println("key " + conversionKey);
        this.strategy = this.handlers.get(this.unitTypeSelected).get(conversionKey);
       
        return this.strategy.convert(this.value);
    }
    
    public String[] getUnitTypes() {
        Set<String> keys = this.unitTypes.keySet();
        String[] arr =keys.toArray(new String[keys.size()]);
        
        return arr;
    }
    
    public String[] getUnitsFor(String unitType) {
        return this.unitTypes.get((unitType));
    }
    
    private void init() {
        this.setUnitTypes();
        this.setHandlers();
    }
    
    private void setUnitTypes() {
        String[] longitudesOptions = {"Kilometers", "Meters", "Centimeters", "Milimeters", 
                            "Miles", "Yards", "Feets", "inches"};
        String[] weightOptions = {"Tons", "Kilograms", "Grams", "Pounds"};
        String[] temperatureOptions = {"Celsius", "Kelvin", "Fahrenheit"};
        
        this.unitTypes.put("Longitud", longitudesOptions);
        this.unitTypes.put("Peso", weightOptions);
        this.unitTypes.put("Temperatura", temperatureOptions);
    }
    
    private void setHandlers() {
        HashMap<String, IConvertionStrategy> longitudes = new HashMap<>();
        longitudes.put("Fetts to Miles", new FeetsToMiles());
        longitudes.put("Kilometers to Meters", new KilometersToMeters());
        longitudes.put("Meters to Feets", new MetersToFeets());
        longitudes.put("Meters to Kilometers", new MetersToKilometers());
        
        HashMap<String, IConvertionStrategy> weights = new HashMap<>();
        longitudes.put("Grams to Kilogram", new GramToKilogram());
        longitudes.put("Grams to Pounds", new GramsToPounds());
        longitudes.put("Kilograms to Grams", new KilogramToGram());
        
        this.handlers.put("Longitud", longitudes);
        this.handlers.put("Peso", weights);
    }
    
}
