package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Carrera {

    private Integer distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos; //una Lista o Conjunto (Set)

    public Carrera(Integer distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }


    public void darDeAltaAuto(Integer velocidad,Integer aceleracion,Integer anguloDeGiro,String patente){
        Auto unAutoARegistrar = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
        if (hayCupoDisponible()){
            this.listaDeVehiculos.add(unAutoARegistrar);
            System.out.println("Auto dado de alta exitosamente");
        }else{
            System.out.println("No Hay cupo disponible");
        }

    }



    public void darDeAltaMoto(Integer velocidad,Integer aceleracion,Integer anguloDeGiro,String patente){
        Moto unaMotoARegistrar = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
        if (hayCupoDisponible()){
            this.listaDeVehiculos.add(unaMotoARegistrar);
            System.out.println("Moto dado de alta exitosamente");
        }else{
            System.out.println("No Hay cupo disponible");
        }
    }

    /**
     * tengo cupo disponible si la cantidad de elementos en mi lista de vehiculos
     *  no supera la cantidad de vehiculos permitidos
     * @return
     */
    private boolean hayCupoDisponible() {
        return this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos;
    }

}
