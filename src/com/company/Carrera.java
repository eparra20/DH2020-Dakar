package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Carrera {

    private Integer distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos; //una Lista o Conjunto (Set)

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Integer distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, SocorristaMoto socorristaMoto,
        SocorristaAuto socorristaAuto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
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

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        Auto unAutoARegistrar = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        if (hayCupoDisponible()) {
            this.listaDeVehiculos.add(unAutoARegistrar);
            System.out.println("Auto dado de alta exitosamente");
        } else {
            System.out.println("No Hay cupo disponible");
        }

    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        Moto unaMotoARegistrar = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        if (hayCupoDisponible()) {
            this.listaDeVehiculos.add(unaMotoARegistrar);
            System.out.println("Moto dado de alta exitosamente");
        } else {
            System.out.println("No Hay cupo disponible");
        }
    }

    public void eliminarVehiculo(Vehiculo unVehiculo) {
        this.listaDeVehiculos.remove(unVehiculo);
    }

    /**
     * 1 ) Encontrar el vehiculo a eliminar dentro de mi lista de vehiculos.
     * 2 ) Luego cuando las patentes sean iguales elimino el vehiculo de mi lista de vehiculos
     *
     * @param patenteAEliminar
     */
    public void eliminarVehiculo(String patenteAEliminar) {
        //foreach funciona para to do lo que sea iterable
        Vehiculo vehiculoAEliminar = null;

        for (Vehiculo vehiculo : this.listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patenteAEliminar)) {
                vehiculoAEliminar = vehiculo;
                break;
            }
        }
        eliminarVehiculo(vehiculoAEliminar);
    }

    /**
     * Metodo para buscar un vehiculo por una patente.
     *
     * @param patente
     * @return
     */
    private Vehiculo buscarVehiculo(String patente) {
        Vehiculo vehiculoABuscar = null;

        for (Vehiculo vehiculo : this.listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculoABuscar = vehiculo;
                break;
            }
        }

        return vehiculoABuscar;
    }

    /**
     * Quien tenga el mayor puntaje. ¿ ?
     * Sera el vehiculo ganador.
     */
    public void definirGanador() {
        //todo
        Vehiculo vehiculoGanador = null;
        Double puntajeMaximoTemporal = 0.0; //100

        for (Vehiculo vehiculo : listaDeVehiculos) {
            Double puntajeDeVehiculo = vehiculo.getPeso() * vehiculo.getAceleracion();
            if (puntajeDeVehiculo > puntajeMaximoTemporal) {
                vehiculoGanador = vehiculo;
                puntajeMaximoTemporal = puntajeDeVehiculo;
            }
        }

        System.out.println("El ganador es: " + vehiculoGanador.getPatente() + " con un puntaje de " + puntajeMaximoTemporal);
    }

    public void socorrerAuto(String patente) {
        Vehiculo vehiculo = buscarVehiculo(patente);

        if (vehiculo instanceof Auto) {
            Auto unAuto = (Auto) vehiculo;
            socorristaAuto.socorrer(unAuto);
        } else {
            System.out.println("La patente que ingresaste no pertenece a un auto.");
        }
    }

    public void socorrerMoto(String patente) {
        Vehiculo vehiculo = buscarVehiculo(patente);

        if (vehiculo instanceof Moto) {
            Moto unaMoto = (Moto) vehiculo;
            socorristaMoto.socorrer(unaMoto);
        } else {
            System.out.println("No eres motorizado");
        }
    }


    /**
     * tengo cupo disponible si la cantidad de elementos en mi lista de vehiculos
     * no supera la cantidad de vehiculos permitidos
     *
     * @return
     */
    private boolean hayCupoDisponible() {
        return this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos;
    }

}
