package main;

public class ListaCircularConsumos {
    private NodoSimple entrada;

    public ListaCircularConsumos() {
    }

    public NodoSimple getEntrada() {
        return entrada;
    }

    public void setEntrada(NodoSimple entrada) {
        this.entrada = entrada;
    }

    public boolean listaVacia() {
        return entrada == null;
    }

    public void insertarAlInicio (Consumos consumo) {
        NodoSimple nuevo = new NodoSimple(consumo);
        if(listaVacia()) {
            entrada = nuevo;
            entrada.setSiguiente(entrada);
        } else {
            nuevo.setSiguiente(entrada);
            NodoSimple aux = entrada;
            while (aux.getSiguiente() != entrada) {
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            entrada = nuevo;
        }
    }

    public void eliminarDeEntrada () {
        if(!listaVacia()) {
            if(false) {

            } else {
                NodoSimple aux= entrada;
                while (aux.getSiguiente() != entrada) {
                    aux=aux.getSiguiente();
                }
            }
        }
    }









    
}
