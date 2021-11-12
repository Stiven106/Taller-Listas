package main;

public class Consumos {
    private String concepto;
    private String cedula;
    private String nombre;
    private double valor;

    public Consumos(String concepto, double valor, String cedula, String nombre) {
        this.concepto = concepto;
        this.valor = valor;
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
