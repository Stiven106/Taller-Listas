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
        System.out.println("entro en ListaSimpleSocios");
        NodoSimple aux = null;
        NodoSimple encontrado = null;

        //Miramos que la lista no este vacia:
        if (!listaVacia()) {
            System.out.println("entro en ListaSimpleSocios: !listaVacia");
            //Comparamos que el socio del inicio no sea el repetido:
            if (inicio.getSocio().getCedula().equals(cedula)) {
                System.out.println("entro en ListaSimpleSocios: !listaVacia:if(encontrado=inicio)");
                encontrado = inicio;
            } else {
            System.out.println("entro en ListaSimpleSocios: else");
                //Si el socio del inicio no es igual a la cedula repetida, entonces que se ejecute este else
                //Decimos que aux va a ser igual a el siguiente socio de la lista
                if(inicio.getSiguiente() != null) {
                    aux = inicio.getSiguiente();
                    while (aux != inicio ) {
                        System.out.println("entro en ListaSimpleSocios: while");

                        if (aux.getSocio().getCedula().equals(cedula)) {
                            System.out.println("entro en ListaSimpleSocios: if (encontrado)");
                            encontrado = aux;
                            break;
                        }
                        aux = aux.getSiguiente();
                }
                }
                 //Mientras que aux sea diferente del inicio, lo cual es true, entonces va ir recorriendo todos los socios hasta encontrar el repetido o finalizar.
                    
            }
        }
        System.out.println("Saliendo de ListaSimpleSocios");
        return encontrado;
    }

    public void insertarAlInicio(Socios socio) {
        NodoSimple nuevo =  new NodoSimple(socio);
        if(listaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            System.out.println("ingresando 2do dato");
            nuevo.setSiguiente(inicio);
            inicio=nuevo;
            System.out.println("2do dato ingresado, saliendo de metodo insertarAlInicio ");
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








    /*
    // Video profe

    

    //Insertar

    

    

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

    //Eliminar

    public void eliminarDelInicio() {
        if (!listaVacia()) {
            if(inicio==fin) {
                inicio = fin = null;
            }
            inicio=inicio.getSiguiente();
        }
    }
    
    public void eliminarDelFinal() {
        if(!listaVacia()) {
            //Si solo existe un dato, entonces:
            if(inicio == fin) {
                inicio = fin = null;
            } else { // Si existen mas de 1 dato, entonces:
                NodoSimple aux = inicio;
                while(aux.getSiguiente() != fin)  { // Mientras el siguiente del "aux" sea distinto de fin, entonces ir avanzando de posicion.
                    aux=aux.getSiguiente();
                }
                    fin=aux;
                    fin.setSiguiente(null);
                ;
            }
        }
    }

    public void eliminar (int dato) {
        if(!listaVacia()) {
            if(dato == inicio.getDato()) {
                eliminarDelInicio();
            } else if (dato==fin.getDato()) {
                eliminarDelFinal();
            } else {
                NodoSimple aux = inicio;

                while(aux.getSiguiente() != null && aux.getSiguiente().getDato()!=dato) {
                    aux=aux.getSiguiente();
                }
                if(aux!=fin) {
                    NodoSimple eliminado = aux.getSiguiente();
                    aux.setSiguiente(eliminado.getSiguiente());
                }
                NodoSimple eliminado = aux.getSiguiente();
                aux.setSiguiente(eliminado.getSiguiente());
            }
        }
    }

    */

    
}