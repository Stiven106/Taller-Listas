package main;

import javax.swing.JOptionPane;

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
            if(entrada.getSiguiente()==entrada) {
                entrada = null;
            } else {
                NodoSimple aux = entrada;
                while (aux.getSiguiente() != entrada) {
                    aux=aux.getSiguiente();
                }
                aux.setSiguiente(entrada.getSiguiente());
                entrada = entrada.getSiguiente();
            }
        }
    }

    public double eliminar(String cedula, String concepto) {
        double valor = 0.0;
        if(!listaVacia()) {
            if(entrada.getConsumo().getCedula().equals(cedula) && entrada.getConsumo().getConcepto().equals(concepto)) {
                valor = entrada.getConsumo().getValor();
                eliminarDeEntrada();
                JOptionPane.showMessageDialog(null, "Factura pagada con exito. ");
            } else {
                NodoSimple aux = entrada;
                while (aux.getSiguiente().getConsumo().getCedula() != cedula 
                && aux.getSiguiente().getConsumo().getConcepto() != concepto  && aux != entrada) {
                    aux = aux.getSiguiente();
                }
                if(aux!=entrada){
                    valor = entrada.getConsumo().getValor();
                    NodoSimple eliminado = aux.getSiguiente();
                    aux.setSiguiente(eliminado.getSiguiente());
                    JOptionPane.showMessageDialog(null, "Factura pagada con exito. ");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el consumo que desea eliminar. "
                    + "\nPor favor verique que la cedula o concepto ingresada sea la correcta.");
                }
                
            }
        }

        return valor;
    }

    public Consumos buscarConsumo (String cedula, String concepto) {
        NodoSimple aux = null;
        Consumos encontrado = null;

        if (!listaVacia()) {
            if (entrada.getConsumo().getCedula().equals(cedula) && entrada.getConsumo().getConcepto().equals(concepto)) {
                encontrado = entrada.getConsumo();
            } else if (entrada.getSiguiente() != null) {
                    aux = entrada.getSiguiente();
                    while (aux!=null && aux != entrada) {
                        if (aux.getConsumo().getCedula().equals(cedula) && aux.getConsumo().getConcepto().equals(concepto)) {
                            encontrado = aux.getConsumo();
                            aux = aux.getSiguiente();
                        } else {
                            aux = aux.getSiguiente();
                        }
                    }
            }
        }

        return encontrado;
    }

    public int imprimirConsumos(String cedula) {
        NodoSimple aux = null;
        Consumos encontrado = null;
        int contador = 0;
        
        if (!listaVacia()) {
            if (entrada.getConsumo().getCedula().equals(cedula)) {
                encontrado = entrada.getConsumo();
                JOptionPane.showMessageDialog(null, 
                "Nombre del que realizo el consumo: " + encontrado.getNombre()+ 
                "\nConcepto de la factura: " + encontrado.getConcepto() + 
                "\nValor de la factura: " + encontrado.getValor());
                contador = (contador + 1);
            } else if (entrada.getSiguiente() != null) {
                    aux = entrada.getSiguiente();
                    while (aux!=null && aux != entrada) {
                        if (aux.getConsumo().getCedula().equals(cedula)) {
                            encontrado = aux.getConsumo();
                            JOptionPane.showMessageDialog(null, 
                            "Nombre del que realizo el consumo: " + encontrado.getNombre()+ 
                            "Concepto de la factura: " + encontrado.getConcepto() + 
                            "Valor de la factura: " + encontrado.getValor());
                            contador = (contador + 1);
                            aux = aux.getSiguiente();
                        } else {
                            aux = aux.getSiguiente();
                        }
                    }
            }
        }
        return contador;
    }

}
