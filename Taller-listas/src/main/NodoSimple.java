package main;

public class NodoSimple {
    
    private Socios socio;
    private Consumos consumo;
    private NodoSimple siguiente;

    public NodoSimple (Socios socio) {
        this.socio = socio;
        this.siguiente = null;
    }

    public NodoSimple (Consumos consumo) {
        this.consumo = consumo;
        this.siguiente = null;
    }

    public Consumos getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumos consumo) {
        this.consumo = consumo;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }
    
    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }

    
}
