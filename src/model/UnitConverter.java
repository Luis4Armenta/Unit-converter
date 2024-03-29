package model;

import java.util.HashMap;
import java.util.*;

public class UnitConverter {
    private final HashMap<String, String[]> unitTypes = new HashMap<>();
    private final HashMap<String, Double> conversionRates = new HashMap<>();
    
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
    
    public void setInput(double value) {
        if (this.unitTypeSelected.equals("Temperatura")) {
            this.inputValue = value;
        } else {
            if (value < 0) {
                this.inputValue = 0;
            } else {
                this.inputValue = value;
            }
        }
        
    }
    
    public double getOutput() {
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
    
    // Relleno de las opciones de los menus
    private void setUnitTypes() {
        String[] longitudesOptions = {"Kilometros", "Metros", "Centimetros",
            "Milimetros", "Millas", "Yardas", "Pies", "Pulgadas"};
        String[] areaOptions = {"Kilometros cuadrados", "Hectareas", "Metros cuadrados",
            "Millas cuadradas", "Acres", "Pies cuadrados", "Pulgadas cuadradas"};
        String[] weightOptions = {"Toneladas", "Kilogramos", "Gramos", "Toneladas cortas",
            "Libras", "Onzas"};
        String[] volumenOptions = {"Metros cubicos", "Centimetros cubicos", "Litros",
            "Mililitros", "Barriles",
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
        
        this.conversionRates.put("Centimetros-Centimetros", 1.0);
        this.conversionRates.put("Centimetros-Millas", 6.2137e-6);
        this.conversionRates.put("Centimetros-Yardas", 0.0109361);
        this.conversionRates.put("Centimetros-Pies", 0.0328084);
        this.conversionRates.put("Centimetros-Pulgadas", 0.393701);
        this.conversionRates.put("Centimetros-Kilometros", 1e-5);
        this.conversionRates.put("Centimetros-Metros", 0.01);
        this.conversionRates.put("Centimetros-Milimetros", 10.0);

        this.conversionRates.put("Milimetros-Milimetros", 1.0 );
        this.conversionRates.put("Milimetros-Kilometros",  1e-6);
        this.conversionRates.put("Milimetros-Metros", 0.001);
        this.conversionRates.put("Milimetros-Centimetros", 0.1);
        this.conversionRates.put("Milimetros-Millas", 6.2137e-7);
        this.conversionRates.put("Milimetros-Yardas", 0.00109361);   
        this.conversionRates.put("Milimetros-Pies",  0.00328084);
        this.conversionRates.put("Milimetros-Pulgadas",  0.0393701);

        this.conversionRates.put("Millas-Millas", 1.0 );
        this.conversionRates.put("Millas-Kilometros",  1.60934);
        this.conversionRates.put("Millas-Metros", 1609.34);
        this.conversionRates.put("Millas-Centimetros", 160934.0);
        this.conversionRates.put("Millas-Milimetros", 1.609e+6);
        this.conversionRates.put("Millas-Yardas", 1760.0);   
        this.conversionRates.put("Millas-Pies",  5280.0);
        this.conversionRates.put("Millas-Pulgadas",  63360.0);

        this.conversionRates.put("Yardas-Yardas", 1.0 );
        this.conversionRates.put("Yardas-Kilometros",  0.0009144);
        this.conversionRates.put("Yardas-Metros", 0.9144);
        this.conversionRates.put("Yardas-Centimetros", 91.44);
        this.conversionRates.put("Yardas-Milimetros", 914.4);
        this.conversionRates.put("Yardas-Millas", 0.000568182);   
        this.conversionRates.put("Yardas-Pies",  3.0);
        this.conversionRates.put("Yardas-Pulgadas",  36.0);

        this.conversionRates.put("Pies-Pies", 1.0 );
        this.conversionRates.put("Pies-Kilometros",  0.0003048);
        this.conversionRates.put("Pies-Metros", 0.3048);
        this.conversionRates.put("Pies-Centimetros", 30.48);
        this.conversionRates.put("Pies-Milimetros", 304.8);
        this.conversionRates.put("Pies-Millas", 0.000189394);   
        this.conversionRates.put("Pies-Yardas",  0.333333);
        this.conversionRates.put("Pies-Pulgadas",  12.0);

        this.conversionRates.put("Pulgadas-Pulgadas", 1.0 );
        this.conversionRates.put("Pulgadas-Kilometros",  2.54e-5);
        this.conversionRates.put("Pulgadas-Metros", 0.0254);
        this.conversionRates.put("Pulgadas-Centimetros", 2.54);
        this.conversionRates.put("Pulgadas-Milimetros", 25.4);
        this.conversionRates.put("Pulgadas-Millas", 1.5783e-5);   
        this.conversionRates.put("Pulgadas-Yardas",  0.0277778);
        this.conversionRates.put("Pulgadas-Pies",  0.0833333);

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
        
        this.conversionRates.put("Hectareas-Metros cuadrados", 10000.0);
        this.conversionRates.put("Hectareas-Kilometros cuadrados", 0.01);
        this.conversionRates.put("Hectareas-Hectareas", 1.0);
        this.conversionRates.put("Hectareas-Millas cuadradas", 0.003861);
        this.conversionRates.put("Hectareas-Acres", 2.471);
        this.conversionRates.put("Hectareas-Pies cuadrados", 107639.104);
        this.conversionRates.put("Hectareas-Pulgadas cuadradas", 15500031.0);

        this.conversionRates.put("Millas cuadradas-Metros cuadrados", 2590002.59000259000259);
        this.conversionRates.put("Millas cuadradas-Kilometros cuadrados", 2.59000259000259000259);
        this.conversionRates.put("Millas cuadradas-Hectareas", 259.000259000259000259);
        this.conversionRates.put("Millas cuadradas-Millas cuadradas", 1.0);
        this.conversionRates.put("Millas cuadradas-Acres", 639.989639989639989639989);
        this.conversionRates.put("Millas cuadradas-Pies cuadrados", 27878555.814555814);
        this.conversionRates.put("Millas cuadradas-Pulgadas cuadradas", 4014512043.5120435120);

        this.conversionRates.put("Acres-Metros cuadrados", 4046.9445568595);
        this.conversionRates.put("Acres-Kilometros cuadrados", 0.004046944556);
        this.conversionRates.put("Acres-Hectareas", 0.404694455685);
        this.conversionRates.put("Acres-Millas cuadradas", 0.00156252529340);
        this.conversionRates.put("Acres-Acres", 1.0);
        this.conversionRates.put("Acres-Pies cuadrados", 43560.9486038041);
        this.conversionRates.put("Acres-Pulgadas cuadradas", 6272776.6086604613);

        this.conversionRates.put("Pies cuadrados-Metros cuadrados", 0.092903040144221);
        this.conversionRates.put("Pies cuadrados-Kilometros cuadrados", 0.000000092903);
        this.conversionRates.put("Pies cuadrados-Hectareas", 0.0000092903);
        this.conversionRates.put("Pies cuadrados-Millas cuadradas", 0.00000003587004881916);
        this.conversionRates.put("Pies cuadrados-Acres", 0.000022957);
        this.conversionRates.put("Pies cuadrados-Pies cuadrados", 1.0);
        this.conversionRates.put("Pies cuadrados-Pulgadas cuadradas", 43560.0);

        this.conversionRates.put("Pulgadas cuadradas-Metros cuadrados", 0.00064516);
        this.conversionRates.put("Pulgadas cuadradas-Kilometros cuadrados", 0.00000000064516);
        this.conversionRates.put("Pulgadas cuadradas-Hectareas", 0.000000064516);
        this.conversionRates.put("Pulgadas cuadradas-Millas cuadradas", 0.0000000002491);
        this.conversionRates.put("Pulgadas cuadradas-Acres", 0.00000015942400648);
        this.conversionRates.put("Pulgadas cuadradas-Pies cuadrados", 0.00694450972226881829);
        this.conversionRates.put("Pulgadas cuadradas-Pulgadas cuadradas", 1.0);

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

        this.conversionRates.put("Gramos-Gramos", 1.0);
        this.conversionRates.put("Gramos-Kilogramos", 1/1000.0);
        this.conversionRates.put("Gramos-Toneladas", 0.000001);
        this.conversionRates.put("Gramos-Toneladas cortas", 0.0000011023);
        this.conversionRates.put("Gramos-Libras", 0.0022046226);
        this.conversionRates.put("Gramos-Onzas", 0.0352739619);

        this.conversionRates.put("Toneladas cortas-Toneladas cortas", 1.0 );
        this.conversionRates.put("Toneladas cortas-Gramos",  907194.048807039826);
        this.conversionRates.put("Toneladas cortas-Kilogramos", 907.194048807039826);
        this.conversionRates.put("Toneladas cortas-Toneladas", 0.907194048807039826);
        this.conversionRates.put("Toneladas cortas-Libras", 2000.0205025855030394996676);
        this.conversionRates.put("Toneladas cortas-Onzas", 32000.3283135262632741066294);   

        this.conversionRates.put("Libras-Libras", 1.0);   
        this.conversionRates.put("Libras-Gramos", 453.592374495299);   
        this.conversionRates.put("Libras-Kilogramos", 0.453592374495299);   
        this.conversionRates.put("Libras-Toneladas", 0.000453592374495299);   
        this.conversionRates.put("Libras-Toneladas cortas", 0.0004999948744061680877);   
        this.conversionRates.put("Libras-Onzas", 16.0000001360777086551081);   

        this.conversionRates.put("Onzas-Onzas", 1.0);   
        this.conversionRates.put("Onzas-Gramos", 28.349523164848);   
        this.conversionRates.put("Onzas-Kilogramos", 0.028349523164848);   
        this.conversionRates.put("Onzas-Toneladas", 0.000028349523164848);   
        this.conversionRates.put("Onzas-Toneladas cortas", 0.0000312496793846119504);   
        this.conversionRates.put("Onzas-Libras", 0.0624999994684474263648);
        
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

        this.conversionRates.put("Centimetros cubicos-Metros cubicos", 0.000001);
        this.conversionRates.put("Centimetros cubicos-Litros", 0.001);
        this.conversionRates.put("Centimetros cubicos-Centimetros cubicos", 1.0);
        this.conversionRates.put("Centimetros cubicos-Mililitros", 1.0);
        this.conversionRates.put("Centimetros cubicos-Barriles",  0.0000062898107704321);
        this.conversionRates.put("Centimetros cubicos-Galones", 0.0002641720524);
        this.conversionRates.put("Centimetros cubicos-Pintas", 0.0021133764188652);
        this.conversionRates.put("Centimetros cubicos-Onzas liquidas", 0.0341646737274);

        this.conversionRates.put("Mililitros-Metros cubicos", 0.000001);
        this.conversionRates.put("Mililitros-Litros", 0.001);
        this.conversionRates.put("Mililitros-Centimetros cubicos", 1.0);
        this.conversionRates.put("Mililitros-Mililitros", 1.0);
        this.conversionRates.put("Mililitros-Barriles", 0.0000062898107704321);
        this.conversionRates.put("Mililitros-Galones", 0.0002641720524);
        this.conversionRates.put("Mililitros-Pintas", 0.0021133764188652);
        this.conversionRates.put("Mililitros-Onzas liquidas", 0.0341646737274);

        this.conversionRates.put("Barriles-Metros cubicos", 0.158987294928);
        this.conversionRates.put("Barriles-Litros", 158.987294928);
        this.conversionRates.put("Barriles-Centimetros cubicos", 158987.294928);
        this.conversionRates.put("Barriles-Mililitros", 158987.294928);
        this.conversionRates.put("Barriles-Barriles", 1.0);
        this.conversionRates.put("Barriles-Galones", 42.0);
        this.conversionRates.put("Barriles-Pintas", 336.0);
        this.conversionRates.put("Barriles-Onzas liquidas", 5376.0);

        this.conversionRates.put("Galones-Metros cubicos", 0.00378542117834);
        this.conversionRates.put("Galones-Litros", 3.7854117834);
        this.conversionRates.put("Galones-Centimetros cubicos", 3785.4117834);
        this.conversionRates.put("Galones-Mililitros", 3785.4117834);
        this.conversionRates.put("Galones-Barriles", 0.023809523809524);
        this.conversionRates.put("Galones-Galones", 1.0);
        this.conversionRates.put("Galones-Pintas", 8.0);
        this.conversionRates.put("Galones-Onzas liquidas", 129.32735850371635944516);

        this.conversionRates.put("Pintas-Metros cubicos", 0.000473176473);
        this.conversionRates.put("Pintas-Litros", 0.473176473);
        this.conversionRates.put("Pintas-Centimetros cubicos", 473.176473);
        this.conversionRates.put("Pintas-Mililitros", 473.176473);
        this.conversionRates.put("Pintas-Barriles", 0.0029761904761905);
        this.conversionRates.put("Pintas-Galones",   0.125);
        this.conversionRates.put("Pintas-Pintas", 1.0);
        this.conversionRates.put("Pintas-Onzas liquidas", 16.0);

        this.conversionRates.put("Onzas liquidas-Metros cubicos", 0.00002927);
        this.conversionRates.put("Onzas liquidas-Litros", 0.02927);
        this.conversionRates.put("Onzas liquidas-Centimetros cubicos", 29.27);
        this.conversionRates.put("Onzas liquidas-Mililitros", 29.27);
        this.conversionRates.put("Onzas liquidas-Barriles", 0.0001860119047619);
        this.conversionRates.put("Onzas liquidas-Galones", 0.007732315973748);
        this.conversionRates.put("Onzas liquidas-Pintas", 0.0625);
        this.conversionRates.put("Onzas liquidas-Onzas liquidas", 1.0);
        
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
        
        this.conversionRates.put("Km/hr-Km/hr", 1.0);
        this.conversionRates.put("Km/hr-Km/s", 0.000277777777777778);
        this.conversionRates.put("Km/hr-m/s", 0.277777777777778);
        this.conversionRates.put("Km/hr-Milla/s", 0.000173);
        this.conversionRates.put("Km/hr-Milla/hr", 0.621371111111111608208);
        this.conversionRates.put("Km/hr-Pie/s", 0.911344);
        this.conversionRates.put("Km/hr-Nudos", 0.539957);

        this.conversionRates.put("Millas/s-Millas/s", 1.0);
        this.conversionRates.put("Millas/s-m/s", 1609.34);
        this.conversionRates.put("Millas/s-Km/s", 1.61);
        this.conversionRates.put("Millas/s-Km/hr", 5793.64);
        this.conversionRates.put("Millas/s-Millas/hr", 3600.0);
        this.conversionRates.put("Millas/s-Pie/s", 5280.0);
        this.conversionRates.put("Millas/s-Nudos", 3128.31);

        this.conversionRates.put("Millas/hr-Millas/hr", 1.0);
        this.conversionRates.put("Millas/hr-m/s", 0.45);
        this.conversionRates.put("Millas/hr-Km/s", 0.00045);
        this.conversionRates.put("Millas/hr-Km/hr", 1.60934);
        this.conversionRates.put("Millas/hr-Millas/s", 27800.0);
        this.conversionRates.put("Millas/hr-Pie/s", 1.46667);
        this.conversionRates.put("Millas/hr-Nudos", 0.868976);

        this.conversionRates.put("Pie/s-Pies/s", 1.0);
        this.conversionRates.put("Pie/s-m/s", 0.3);
        this.conversionRates.put("Pie/s-Km/s", 0.000305);
        this.conversionRates.put("Pie/s-Km/hr", 1.1);
        this.conversionRates.put("Pie/s-Millas/s", 18900.0);
        this.conversionRates.put("Pie/s-Millas/hr", 0.68);
        this.conversionRates.put("Pie/s-Nudos", 0.592484);

        this.conversionRates.put("Nudos-Nudos", 1.0);
        this.conversionRates.put("Nudos-m/s", 0.51);
        this.conversionRates.put("Nudos-Km/s", 0.000514444);
        this.conversionRates.put("Nudos-Km/hr", 1.8519984);
        this.conversionRates.put("Nudos-Millas/s",  0.00031966068161934);
        this.conversionRates.put("Nudos-Pie/s", 1.6878083989501);
        this.conversionRates.put("Nudos-Millas/hr", 1.15);
    }
}
