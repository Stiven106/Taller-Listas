package main;

import javax.swing.JOptionPane;

public class ListaSimpleSocios {

    private NodoSimple inicio;
    private NodoSimple fin;

    public ListaSimpleSocios() {
        this.inicio = null;
        this.fin =  null;
    }

    public NodoSimple getInicio() {
        return inicio;
    }

    public void setInicio(NodoSimple inicio) {
        this.inicio = inicio;
    }

    public NodoSimple getFin() {
        return fin;
    }

    public void setFin(NodoSimple fin) {
        this.fin = fin;
    }

    public boolean listaVacia()  {
        return inicio==null;
    }

    
    public NodoSimple buscarCedula(String cedula) {
        NodoSimple aux = null;
        NodoSimple encontrado = null;

        //Miramos que la lista no este vacia:
        if (!listaVacia()) {
            //Comparamos que el socio del inicio no sea el repetido:
            if (inicio.getSocio().getCedula().equals(cedula)) {
                encontrado = inicio;
            } else {
                //Si el socio del inicio no es igual a la cedula repetida, entonces que se ejecute este else
                //Decimos que aux va a ser igual a el siguiente socio de la lista
                if(inicio.getSiguiente() != null) {
                    aux = inicio.getSiguiente();
                    while (aux!=null && aux != inicio ) {
                        if (aux.getSocio().getCedula().equals(cedula)) {
                            encontrado = aux;
                            return encontrado;
                        } else {
                            aux = aux.getSiguiente();
                        }
                }
                }
            }
        }
        return encontrado;
    }


    public void insertarAlInicio(Socios socio) {
        NodoSimple nuevo =  new NodoSimple(socio);
        if(listaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio=nuevo;
        }
    }

    public void insertarAlFinal(Socios socio) {
        NodoSimple nuevo =  new NodoSimple(socio);
        if(listaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(inicio);
            fin=nuevo;
        }
    }

    //Eliminar

    public void eliminarDelInicio() {
        if (!listaVacia()) {
            if(inicio==fin ){
                inicio = fin = null;
            } else {
                inicio = inicio.getSiguiente();
            }
        }
    }
    
    public void eliminarDelFinal() {
        if(!listaVacia()) {
            if(inicio == fin) {
                inicio = fin = null;
            } else { // Si existen mas de 1 dato, entonces:
                NodoSimple aux = inicio;
                while(aux.getSiguiente() != null && aux.getSiguiente().getSocio().getCedula() != fin.getSocio().getCedula())  { 
                    aux=aux.getSiguiente();
                }
                    fin=aux;
                    fin.setSiguiente(null);
                
            }
        }
    }

    public void eliminar (Socios socio) {
        if(!listaVacia()) {
            if(socio.getCedula() == inicio.getSocio().getCedula()) {
                System.out.println("al inicio");
                eliminarDelInicio();
            } else if (socio.getCedula()==fin.getSocio().getCedula()) {
                System.out.println("al final");
                eliminarDelFinal();
            } else {

                System.out.println("al medio");

                NodoSimple aux = inicio;
                while(aux.getSiguiente() != null && aux.getSiguiente().getSocio().getCedula() != socio.getCedula()) {
                    aux=aux.getSiguiente();
                }
                if(aux!=fin) {
                    NodoSimple eliminado = aux.getSiguiente();
                    aux.setSiguiente(eliminado.getSiguiente());
                }
            }
        }
    }

    /*

    //Mostrar el contenido

    public String mostrar() {
        String contenido = "";
        NodoSimple aux=inicio;

        while(aux!=null) {
            contenido += (aux.getDato() + " ---> ");
        }
        contenido+= "null";
        return contenido;
    }

    */
    
}
