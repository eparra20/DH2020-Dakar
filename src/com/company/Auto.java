package com.company;

public class Auto extends Vehiculo{

    public static final Double PESO_AUTO = 1000.0;
    public static final Integer CANTIDAD_RUEDAS_AUTO = 4;

    public Auto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_AUTO, CANTIDAD_RUEDAS_AUTO);
    }
}
