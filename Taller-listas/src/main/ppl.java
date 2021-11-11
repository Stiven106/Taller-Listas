package main;

import javax.swing.*;

public class ppl {
    public static void main(String[] args) {

        Club socios = new Club();
        int opc;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoja una opcion: \n"
                    + "1. Para afiliar un socio al club \n"
                    + "2. Para registar una persona autorizada por un socio\n"
                    + "3. Para pagar un consumo\n"
                    + "4. Para registrar un consumo en la cuenta de un socio\n"
                    + "5. Para aumentar fondos de la cuenta de un socio\n"
                    + "6. Para eliminar un socio\n"
                    + "7. para ver cantidad de consumos por cedula \n"
                    + "8. presione 10 para salir \n"
            ));

            switch (opc) {
                case 1: {
                    socios.crearSocio();
                    break;
                }
                case 2: {
                    
                    break;
                }
                case 3: {
                    
                    break;
                }

                case 4: {
                    
                    break;
                }
                case 5: {
                    
                    break;
                }
                case 6: {
                        
                    break;
                }
                case 7: {
                    
                        break;
                }
                case 8: {
                    
                    break;
                }
                case 9: {
                    break;
                }
            }
        } while (opc != 10);


    }
}
