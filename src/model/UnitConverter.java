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
        String[] longitudesOptions = {"Kilometros", "Metros", "Centimetros", "Milimetros", 
                            "Millas", "Yardas", "Pies", "Pulgadas"};
        String[] areaOptions = {"Kilometros cuadrados", "Hectareas", "Metros cuadrados",
            "Millas cuadradas", "Acres", "Pies cuadrados", "Pulgadas cuadradas"};
        String[] weightOptions = {"Toneladas", "Kilogramos", "Gramos", "Toneladas cortas", "Libras", "Onzas"};
        String[] temperatureOptions = {"Celsius", "Kelvin", "Fahrenheit"};
        
        this.unitTypes.put("Longitud", longitudesOptions);
        this.unitTypes.put("Peso", weightOptions);
        this.unitTypes.put("Temperatura", temperatureOptions);
        this.unitTypes.put("Superficie", areaOptions);
    }
    
    private void loadRates() {
                this.conversionRates.put("Kilometros-Kilometros", new Double(1));
        this.conversionRates.put("Kilometros-Metros", new Double(1000));
        this.conversionRates.put("Kilometros-Centimetros", new Double(1000 * 100));
        this.conversionRates.put("Kilometros-Milimetros", 1e+6);
        this.conversionRates.put("Kilometros-Millas", new Double(1/1.609));
        this.conversionRates.put("Kilometros-Yardas", new Double(1094));
        this.conversionRates.put("Kilometros-Pies", new Double(3281));
        this.conversionRates.put("Kilometros-Pulgadas", new Double(39370));

        this.conversionRates.put("Metros-Kilometros", new Double(1/1000));
        this.conversionRates.put("Metros-Metros", new Double(1));
        this.conversionRates.put("Metros-Centimetros", new Double(100));
        this.conversionRates.put("Metros-Milimetros", new Double(1000));
        this.conversionRates.put("Metros-Millas", new Double(1/1609));
        this.conversionRates.put("Metros-Yardas", new Double(1.094));
        this.conversionRates.put("Metros-Pies", new Double(3.281));
        this.conversionRates.put("Metros-Pulgadas", new Double(39.37));

        // Conversion de unidades de superficie

        this.conversionRates.put("Kilometros cuadrados-Kilometros cuadrados", new Double(1));
        this.conversionRates.put("Kilometros cuadrados-Hectarias", new Double(100));
        this.conversionRates.put("Kilometros cuadrados-Metros cuadrados", 1e+6);
        this.conversionRates.put("Kilometros cuadrados-Millas cuadradas", new Double(1/2.59));
        this.conversionRates.put("Kilometros cuadrados-Acres", new Double(247.1));
        this.conversionRates.put("Kilometros cuadrados-Pies cuadrados", 1.076e+7);
        this.conversionRates.put("Kilometros cuadrados-Pulgadas cuadradas", 1.55e+9);


        this.conversionRates.put("Metros cuadrados-Kilometros cuadrados", 1/1e+6);
        this.conversionRates.put("Metros cuadrados-Hectarias", new Double(1/10000));
        this.conversionRates.put("Metros cuadrados-Metros cuadrados", new Double(1));
        this.conversionRates.put("Metros cuadrados-Millas cuadradas", new Double(1/2.59e+6));
        this.conversionRates.put("Metros cuadrados-Acres", new Double(1/4047));
        this.conversionRates.put("Metros cuadrados-Pies cuadrados", new Double(10.764));
        this.conversionRates.put("Metros cuadrados-Pulgadas cuadradas", new Double(1550));

        // Conversion desde unidades de masa

        this.conversionRates.put("Toneladas-Toneladas", new Double(1));
        this.conversionRates.put("Toneladas-Kilogramos", new Double(1000));
        this.conversionRates.put("Toneladas-Gramos", 1e+6);
        this.conversionRates.put("Toneladas-Toneladas cortas", 1.102);
        this.conversionRates.put("Toneladas-Libras", new Double(2205));
        this.conversionRates.put("Toneladas-Onazas", new Double(35270));

        this.conversionRates.put("Kilogramos-Toneladas", new Double(1/1000));
        this.conversionRates.put("Kilogramos-Kilogramos", new Double(1));
        this.conversionRates.put("Kilogramos-Gramos", new Double(1000));
        this.conversionRates.put("Kilogramos-Toneladas cortas", new Double(1/907.2));
        this.conversionRates.put("Kilogramos-Libras", new Double(2.205));
        this.conversionRates.put("Kilogramos-Onazas", new Double(35.274));

    }
}
