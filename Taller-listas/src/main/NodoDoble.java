package main;

public class NodoDoble {

    private Persona persona;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    
    
    public NodoDoble(Persona persona) {
        this.persona = persona;
        this.siguiente = null;
        this.anterior = null;
    }



    public Persona getPersona() {
        return persona;
    }



    public void setPersona(Persona persona) {
        this.persona = persona;
    }



    public NodoDoble getSiguiente() {
        return siguiente;
    }



    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }



    public NodoDoble getAnterior() {
        return anterior;
    }



    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    
    
}
