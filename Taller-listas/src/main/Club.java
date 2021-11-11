package main;

import javax.swing.JOptionPane;

public class Club {
    
    private ListaSimpleSocios socios;

    public Club() {
        socios = new ListaSimpleSocios();
    }

    public void crearSocio() {

        //Tipo de socio a ingresar
        String tipoSuscripcion = null;
        int opcion;

            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese tipo de socio a ingresar: \n" 
        + "Ingrese '1' para suscripcion VIP \n"
        + "Ingrese '2' para suscripcion Regular."));
        if(opcion == 1 ) {
            tipoSuscripcion = "VIP";   
        } else if (opcion == 2){
            tipoSuscripcion = "Regular";   
        } else {
            JOptionPane.showMessageDialog(null, "Opcion ingresada no valida. Por favor verique nuevamente.");
        }
        
        //Datos del socio

        String nombre =  JOptionPane.showInputDialog("Ingrese el nombre del socio a afiliar.");
        String cedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio a afiliar.");

            //Cedula no repetir
        if (buscarCedula(cedula) == null) {
            Socios socioNuevo = new Socios(nombre, cedula, tipoSuscripcion);
            socios.insertarAlInicio(socioNuevo);
            JOptionPane.showMessageDialog(null, "El socio " + tipoSuscripcion + " ha sido creado con exito!!.");
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al afiliar un socio: La cedula ingresada ya existe en nuestra base de datos. ");
        }
    }

    public Socios buscarCedula(String cedula) {

        Socios encontrado = null;
        NodoSimple nodoEncontrado = socios.buscarCedula(cedula);
        if (nodoEncontrado != null) {
            encontrado = nodoEncontrado.getSocio();
        }             
        return encontrado;
    }


}
