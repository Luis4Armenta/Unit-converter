package model;


import java.util.HashMap;
import java.util.*;
import model.strategies.IConvertionStrategy;
import model.strategies.longitude.FeetsToMiles;
import model.strategies.longitude.KilometersToKilometers;
import model.strategies.longitude.KilometersToMeters;
import model.strategies.longitude.MetersToFeets;
import model.strategies.longitude.MetersToKilometers;
import model.strategies.temperature.CelsiusToKelvin;
import model.strategies.temperature.KelvinToCelsius;
import model.strategies.temperature.KelvinToFahrenheit;
import model.strategies.temperature.KelvinToKelvin;
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
        this.init();
        this.unitTypeSelected = "Longitud";
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
    
    public String[] getUnits() {
        return this.unitTypes.get((this.unitTypeSelected));
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
        
        HashMap<String, IConvertionStrategy> weight = new HashMap<>();
        weight.put("Grams to Kilogram", new GramToKilogram());
        weight.put("Grams to Pounds", new GramsToPounds());
        weight.put("Kilograms to Grams", new KilogramToGram());
        
        HashMap<String, IConvertionStrategy> temperature = new HashMap<>();
        temperature.put("Celsius to Kelvin", new CelsiusToKelvin());
        temperature.put("Kelvin to Celsius", new KelvinToCelsius());
        temperature.put("Kelvin to Fahrenheit", new KelvinToFahrenheit());
        temperature.put("Kelvin to Kelvin", new KelvinToKelvin());
        
        this.handlers.put("Longitud", longitudes);
        this.handlers.put("Peso", weight);
        this.handlers.put("Temperatura", temperature);
    }
    
}
