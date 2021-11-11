package main;

import javax.swing.*;

public class Persona {
    
    private String nombre;
    private String cedula;
    private ListaCircularConsumos facturas;

    public Persona() {
    }

    public Persona(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.facturas = new ListaCircularConsumos();
    }

    public ListaCircularConsumos getFacturas() {
        return facturas;
    }

    public void setFacturas(ListaCircularConsumos facturas) {
        this.facturas = facturas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // public double total(){
    //     return facturas.total();
    // }
    

}
