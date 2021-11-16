package main;

import javax.swing.*;

public class ppl {
    public static void main(String[] args) {

        Club club = new Club();
        int opc;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoja una opcion: \n"
                    + "1. Para registrar un socio al club \n"
                    + "2. Para registar una persona autorizada por un socio\n"
                    + "3. Para registrar un consumo en la cuenta de un socio o persona autorizada\n"
                    + "4. Para pagar un consumo\n"
                    + "5. Para aumentar fondos de la cuenta de un socio\n"
                    + "6. Para eliminar un socio\n"
                    + "7. para ver cantidad de consumos por cedula \n"
                    + "8. presione 10 para salir \n"
                    + "\n \n En caso de dudas, por favor leer el readme, ahi esta la explicacion del funcionamiento de cada metodo."
            ));

            switch (opc) {
                case 1: {
                    club.crearSocio();
                    break;
                }
                case 2: {
                    club.crearPersona();
                    break;
                }
                case 3: {
                    club.crearConsumo();
                    break;
                }
                case 4: {
                    club.eliminarConsumo();
                    break;
                }
                case 5: {
                    String cedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio para ingresar nuevos fondos.");
                    club.ingresoFondos(cedula);
                    break;
                }
                case 6: {
                    String cedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio que quiere eliminar del sistema.");
                    JOptionPane.showMessageDialog(null, "Socio eliminado: " + club.eliminarSocio(cedula) );
                    break;
                }
                case 7: {
                    club.mostrarTodosConsumos();
                        break;
                }
                
            }
        } while (opc != 8);


    }
}
