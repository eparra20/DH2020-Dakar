package com.company;

public class Moto extends Vehiculo {

    public static final Double PESO_MOTO = 300.0;
    public static final Integer CANTIDAD_RUEDAS_MOTO = 2;

    public Moto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente,PESO_MOTO,CANTIDAD_RUEDAS_MOTO);
    }
}
