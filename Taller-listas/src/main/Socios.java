package main;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class Socios {
    private String nombre;
    private String cedula;
    private double fondos;
    private String tipoSuscripcion;    
    private ListaDoblePersonas personaAutorizadas;
    private ListaCircularConsumos facturas;

    public Socios(String nombre, String cedula, String tipoSuscripcion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipoSuscripcion = tipoSuscripcion;
        
        this.facturas = new ListaCircularConsumos();
        this.personaAutorizadas = new ListaDoblePersonas();     

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getFondos() {
        return fondos;
    }

    public void setFondos(double fondos) {
        this.fondos = fondos;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public ListaDoblePersonas getPersonaAutorizadas() {
        return personaAutorizadas;
    }

    public void setPersonaAutorizadas(ListaDoblePersonas personaAutorizadas) {
        this.personaAutorizadas = personaAutorizadas;
    }

    public ListaCircularConsumos getFacturas() {
        return facturas;
    }

    public void setFacturas(ListaCircularConsumos facturas) {
        this.facturas = facturas;
    }

    
}
