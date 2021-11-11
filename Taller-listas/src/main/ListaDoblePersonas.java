package main;

import javax.swing.JOptionPane;

public class ListaDoblePersonas {
    private NodoDoble inicio;
    private NodoDoble fin;

    public ListaDoblePersonas() {
        this.inicio = null;
        this.fin=null;
    }

    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getFin() {
        return fin;
    }

    public void setFin(NodoDoble fin) {
        this.fin = fin;
    }
    
    public boolean listaVacia( ){
        return inicio == null;
    }

    public void insertarAlInicio(Persona persona) {
        NodoDoble nuevoPersona = new NodoDoble(persona);
        if (listaVacia()) {
            inicio = fin = nuevoPersona;
        } else {
            nuevoPersona.setSiguiente(inicio);
            inicio.setAnterior(nuevoPersona); 
            inicio=nuevoPersona;
        }
    }

    public void insertarAlFinal(Persona persona) {
        NodoDoble nuevoPersona = new NodoDoble(persona);
        
        if (listaVacia()) {
            inicio = fin = nuevoPersona;
        } else {
            fin.setSiguiente(nuevoPersona);
            nuevoPersona.setAnterior(fin); 
            fin=nuevoPersona;
        }
    }

    public void eliminarDelInicio () {
        if(!listaVacia()) {
            if(inicio == fin) {
                inicio = fin = null;
            } else {
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
            }
            
        }
    }

    public void eliminarDelFinal () {
        if(!listaVacia()) {
            if(inicio == fin) {
                inicio = fin = null;
            } else {
                fin = fin.getAnterior();
                fin.setSiguiente(null);
            }
            
        }
    }

    public void eliminarPersona(Persona persona) {
        if(!listaVacia()) {
            if(inicio.getPersona()==persona) {
                eliminarDelInicio();
            } else if (fin.getPersona()==persona) {
                eliminarDelFinal();
            } else {
                NodoDoble eliminado=null;
                NodoDoble aux=inicio;
                while(aux!=null && eliminado==null) {
                    if(aux.getPersona()==persona) {
                        eliminado=aux;
                    }
                    aux=aux.getSiguiente();
                }
                if(eliminado!=null) {
                    eliminado.getAnterior().setSiguiente(eliminado.getSiguiente());
                    eliminado.getSiguiente().setAnterior(eliminado.getAnterior());
                    JOptionPane.showMessageDialog(null, "Persona eliminada correctamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "Persona a eliminar no encontrada!");
                }
                
            }
        }
    }

    //Buscar personas y personas autorizadas: Este metodo si me va servir, no se si para personas solamente o para socios tambien.
    /*Nota:Esto todavia no esta funcional, por ejemplo, se deberia cambiar todo lo referente a personas por personas.
    Y creo que este mismo metodo de pronto podria funcionar para buscar tanto personas como personas, tal vez eligiendo en vez de unicamente
    personas poner un tipo object y ver como se manejaria, no se si es posible, pero estaria bueno mirar luego... */
    public NodoDoble buscar(Persona persona) {
        NodoDoble eliminado=null;
        NodoDoble aux=inicio;
        while(aux!=null && eliminado==null) {
            if(aux.getPersona()==persona) {
                eliminado=aux;
            }
            aux=aux.getSiguiente();
        }
        return eliminado;
    }

    //Metodo de ordenar de menor a mayor: No se si me sirva para este proyecto, pero por aca lo dejo :v
    public void ordenar() {
        if(!listaVacia()) {
            NodoDoble aux1=inicio;
            while(aux1!=null) {
                NodoDoble aux2 = aux1;
                while (aux2!=null) {
                    if(aux1.getPersona().getCedula().equals(aux2.getPersona().getCedula().equals(aux2))) {
                        Persona temp = aux1.getPersona();
                        aux1.setPersona(aux2.getPersona());
                        aux2.setPersona(temp);
                    }
                }
            }
        }
    }


}
