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
        if ("Temperatura".equals(this.unitTypeSelected)) {
            switch(this.fromUnit+"-"+this.toUnit) {
                case "Celsius-Celsius": return this.inputValue;
                case "Celsius-Kelvin": return this.inputValue + 273.15;
                case "Celsius-Fahrenheit": return (9 * this.inputValue)/5 + 32;
                case "Kelvin-Celsius": return this.inputValue - 273.15;
                case "Kelvin-Kelvin": return this.inputValue;
                case "Kelvin-Fahrenheit": return ((9 * (this.inputValue - 273.15))/5)  + 32;
                case "Fahrenheit-Fahrenheit": return this.inputValue;
                case "Fahrenheit-Celsius": return 5 * (this.inputValue - 32)/9;
                case "Fahrenheit-Kelvin": return ((5 * (this.inputValue - 32))/9) + 273.15;
            }
        }
        
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
        String[] longitudesOptions = {"Kilometros", "Metros", "Centimetros", "Milimetros", 
                            "Millas", "Yardas", "Pies", "Pulgadas"};
        String[] areaOptions = {"Kilometros cuadrados", "Hectareas", "Metros cuadrados",
            "Millas cuadradas", "Acres", "Pies cuadrados", "Pulgadas cuadradas"};
        String[] weightOptions = {"Toneladas", "Kilogramos", "Gramos", "Toneladas cortas", "Libras", "Onzas"};
        String[] volumenOptions = {"Metros cubicos", "Centimetros cubicos", "Litros", "Mililitros", "Barriles",
            "Galones", "Pintas", "Onzas liquidas"};
        String[] temperatureOptions = {"Celsius", "Kelvin", "Fahrenheit"};
        String[] speedOptions = {"Km/s", "m/s", "Km/hr", "Milla/s", "Milla/hr",
        "Pies/s", "Nudos"};
        
        this.unitTypes.put("Longitud", longitudesOptions);
        this.unitTypes.put("Peso", weightOptions);
        this.unitTypes.put("Temperatura", temperatureOptions);
        this.unitTypes.put("Superficie", areaOptions);
        this.unitTypes.put("Volumen", volumenOptions);
        this.unitTypes.put("velocidad", speedOptions);
    }
    
    private void loadRates() {
        this.conversionRates.put("Kilometros-Kilometros", 1.0);
        this.conversionRates.put("Kilometros-Metros", 1000.0);
        this.conversionRates.put("Kilometros-Centimetros", 1000 * 100 + 0.0);
        this.conversionRates.put("Kilometros-Milimetros", 1e+6);
        this.conversionRates.put("Kilometros-Millas", 1/1.609);
        this.conversionRates.put("Kilometros-Yardas", 1094.0);
        this.conversionRates.put("Kilometros-Pies", 3281.0);
        this.conversionRates.put("Kilometros-Pulgadas", 39370.0);

        this.conversionRates.put("Metros-Kilometros", 0.001);
        this.conversionRates.put("Metros-Metros", 1.0);
        this.conversionRates.put("Metros-Centimetros", 100.0);
        this.conversionRates.put("Metros-Milimetros", 1000.0);
        this.conversionRates.put("Metros-Millas", 1/1609 + 0.0);
        this.conversionRates.put("Metros-Yardas", 1.094);
        this.conversionRates.put("Metros-Pies", 3.281);
        this.conversionRates.put("Metros-Pulgadas", 39.37);

        // Conversion de unidades de superficie

        this.conversionRates.put("Kilometros cuadrados-Kilometros cuadrados", 1.0);
        this.conversionRates.put("Kilometros cuadrados-Hectarias", 100.0);
        this.conversionRates.put("Kilometros cuadrados-Metros cuadrados", 1e+6);
        this.conversionRates.put("Kilometros cuadrados-Millas cuadradas", 1/2.59);
        this.conversionRates.put("Kilometros cuadrados-Acres", 247.1);
        this.conversionRates.put("Kilometros cuadrados-Pies cuadrados", 1.076e+7);
        this.conversionRates.put("Kilometros cuadrados-Pulgadas cuadradas", 1.55e+9);


        this.conversionRates.put("Metros cuadrados-Kilometros cuadrados", 1/1e+6);
        this.conversionRates.put("Metros cuadrados-Hectarias", 0.0001);
        this.conversionRates.put("Metros cuadrados-Metros cuadrados", 1.0);
        this.conversionRates.put("Metros cuadrados-Millas cuadradas", 1/2.59e+6);
        this.conversionRates.put("Metros cuadrados-Acres", 1/4047 + 0.0);
        this.conversionRates.put("Metros cuadrados-Pies cuadrados", 10.764);
        this.conversionRates.put("Metros cuadrados-Pulgadas cuadradas", 1550.0);

        // Conversion desde unidades de masa

        this.conversionRates.put("Toneladas-Toneladas", 1.0);
        this.conversionRates.put("Toneladas-Kilogramos", 1000.0);
        this.conversionRates.put("Toneladas-Gramos", 1e+6);
        this.conversionRates.put("Toneladas-Toneladas cortas", 1.102);
        this.conversionRates.put("Toneladas-Libras", 2205.0);
        this.conversionRates.put("Toneladas-Onazas", 35270.0);

        this.conversionRates.put("Kilogramos-Toneladas", 0.001);
        this.conversionRates.put("Kilogramos-Kilogramos", 1.0);
        this.conversionRates.put("Kilogramos-Gramos", 1000.0);
        this.conversionRates.put("Kilogramos-Toneladas cortas", 1/907.2);
        this.conversionRates.put("Kilogramos-Libras", 2.205);
        this.conversionRates.put("Kilogramos-Onazas", 35.274);

        // Conversion de unidades de volumen
        
        this.conversionRates.put("Metros cubicos-Metros cubicos", 1.0);
        this.conversionRates.put("Metros cubicos-Litros", 1000.0);
        this.conversionRates.put("Metros cubicos-Centimetros cubicos", 1e+6);
        this.conversionRates.put("Metros cubicos-Mililitros", 1e+6);
        this.conversionRates.put("Metros cubicos-Barriles", 6.29);
        this.conversionRates.put("Metros cubicos-Galones", 264.2);
        this.conversionRates.put("Metros cubicos-Pintas", 2113.0);
        this.conversionRates.put("Metros cubicos-Onzas liquidas", 33810.0);
        
        this.conversionRates.put("Litros-Metros cubicos", 0.001);
        this.conversionRates.put("Litros-Litros", 1.0);
        this.conversionRates.put("Litros-Centimetros cubicos", 1000.0);
        this.conversionRates.put("Litros-Mililitros", 1000.0);
        this.conversionRates.put("Litros-Barriles", 158.98);
        this.conversionRates.put("Litros-Galones", 1/3.785);
        this.conversionRates.put("Litros-Pintas", 2.113);
        this.conversionRates.put("Litros-Onzas liquidas", 33.814);

        // Conversion de unidades de velocidad
        
        this.conversionRates.put("Km/s-Km/s", 1.0);
        this.conversionRates.put("Km/s-m/s", 1000.0);
        this.conversionRates.put("Km/s-Km/hr", 3600.0);
        this.conversionRates.put("Km/s-Milla/s", 0.62137119223733);
        this.conversionRates.put("Km/s-Milla/hr", 2236.9362920544);
        this.conversionRates.put("Km/s-Pie/s", 3280.8398950131);
        this.conversionRates.put("Km/s-Nudos", 1943.861717893);
        
        this.conversionRates.put("m/s-Km/s", 0.001);
        this.conversionRates.put("m/s-m/s", 1.0);
        this.conversionRates.put("m/s-Km/hr", 3.6);
        this.conversionRates.put("m/s-Milla/s", 0.00062137119223733);
        this.conversionRates.put("m/s-Milla/hr", 2236.9362920544);
        this.conversionRates.put("m/s-Pie/s", 2.2369362920544);
        this.conversionRates.put("m/s-Nudos", 1.9438461717893);
    }
}
