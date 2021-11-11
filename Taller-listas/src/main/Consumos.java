package main;

public class Consumos {
    private String concepto;
    private String nombre;
    private double valor;

    public Consumos(String concepto, double valor, String cliente) {
        this.concepto = concepto;
        this.valor = valor;
        this.nombre = cliente;
    }

    public String getCliente() {
        return nombre;
    }

    public void setCliente(String cliente) {
        this.nombre = cliente;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
