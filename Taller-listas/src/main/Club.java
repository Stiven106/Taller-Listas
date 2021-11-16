package main;

import javax.swing.JOptionPane;

public class Club {
    
    private ListaSimpleSocios socios;
    private ListaDoblePersonas personas;
    private ListaCircularConsumos consumos;

    public Club() {
        socios = new ListaSimpleSocios();
        personas = new ListaDoblePersonas();
        consumos = new ListaCircularConsumos();
    }

    public void crearConsumo ( ) {

        //Datos basicos del consumo
        String cedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio o persona para realizar el consumo.");
        String concepto =  JOptionPane.showInputDialog("Por favor ingrese el concepto del consumo.");
        double factura =  Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el valor del consumo a realizar."));

        //Variables nulas para trabajar
        String cedulaEncontrada = null;
        String nombreEncontrado = null;
        double fondosEncontrados = 0.0;

        //Ingresar datos dependiendo si es persona o socio el que realiza el consumo
        if (buscarCedula(cedula) != null) {
            cedulaEncontrada = buscarCedula(cedula).getCedula();
            nombreEncontrado = buscarCedula(cedula).getNombre();
            fondosEncontrados = buscarCedula(cedula).getFondos();
        } else if (buscarCedulaPersona(cedula) != null){
            cedulaEncontrada = buscarCedulaPersona(cedula).getCedulaSocioAfiliado();
            nombreEncontrado = buscarCedulaPersona(cedula).getNombre();
            fondosEncontrados = buscarCedula(cedulaEncontrada).getFondos();
        } 

        //Validar que hayan fondos para hacer el consumo.
        if (factura <= fondosEncontrados) {
            Consumos consumo = new Consumos(concepto, factura, cedulaEncontrada, nombreEncontrado);
            consumos.insertarAlInicio(consumo);
            JOptionPane.showMessageDialog(null, "El consumo del afiliado con nombre:  '" + nombreEncontrado + "'' ha sido realizado con exito!!.");
        } else {
            JOptionPane.showMessageDialog(null, "Fondos insuficientes, por favor ingrese nuevos fondos en la cuenta del socio.");

        }
        
    }
    
    public void crearSocio() {

        //Datos del socio
        String nombre =  JOptionPane.showInputDialog("Ingrese el nombre del socio a afiliar.");
        String cedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio a afiliar.");

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
            JOptionPane.showMessageDialog(null, "Opcion ingresada no valida. Por favor verique y vuelva a intentarlo nuevamente. \n No se logro la afiliacion");
            return;
        }

        //Ingreso de fondos segun la opcion elegida (vip o regular)
        double fondos = 0.0;

        //Cedula no repetir
        if (buscarCedula(cedula) == null && buscarCedulaPersona(cedula) == null) {
            Socios socioNuevo = new Socios(nombre, cedula, tipoSuscripcion, fondos);
            socios.insertarAlInicio(socioNuevo);
            JOptionPane.showMessageDialog(null, "El socio " + tipoSuscripcion + " ha sido creado con exito!!.");
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al afiliar un socio: La cedula ingresada ya existe en nuestra base de datos. ");
            return;
        }

        ingresoFondos(cedula);

    }

    public void crearPersona () {

        //Ingreso datos de persona

        String nombre =  JOptionPane.showInputDialog("Ingrese el nombre de la persona.");
        String cedula =  JOptionPane.showInputDialog("Ingrese la cedula de la persona.");
        String socioCedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio al cual se va a afiliar.");

        //Validar que la cedula no se repita, tanto con los socios, como con las demas personasAutorizadas.
            if (buscarCedula(cedula) == null && buscarCedulaPersona(cedula) == null) {
                Persona persona = new Persona(cedula, nombre, socioCedula);
                personas.insertarAlInicio(persona);
                JOptionPane.showMessageDialog(null, "El afiliado " + nombre + " ha sido creado con exito!!.");
            } else {
                JOptionPane.showMessageDialog(null, "Fallo al afiliar un socio: La cedula ingresada ya existe en nuestra base de datos. ");
            }
    }

    public void ingresoFondos(String cedula) {
        
        //Variables nulas para trabajar
        Socios socio = null;
        boolean ingresado = false;

        while (ingresado == false) {
            System.out.println("se ejecuta esto");
            double ingresoValor =  Double.parseDouble(JOptionPane.showInputDialog("Digite el monto a ingresar a la cuenta."));
            if (buscarCedula(cedula) != null) {
                socio = buscarCedula(cedula);
                if(socio.getTipoSuscripcion().equals("VIP") && ingresoValor+socio.getFondos() >= 100000 && ingresoValor+socio.getFondos() <= 5000000) {
                        buscarCedula(cedula).setFondos(socio.getFondos()+ingresoValor);
                        JOptionPane.showMessageDialog(null, "El consumo del afiliado con nombre:  '" + socio.getNombre() 
                        + "' ha sido realizado con exito!!."
                        + "\nFondos actuales:" + socio.getFondos());
                        ingresado = true;
                } else if ( socio.getTipoSuscripcion().equals("Regular") && ingresoValor+socio.getFondos() >= 50000 && ingresoValor+socio.getFondos() <= 1000000) {
                        buscarCedula(cedula).setFondos(socio.getFondos()+ingresoValor);
                        JOptionPane.showMessageDialog(null, "El consumo del afiliado con nombre:  '" + socio.getNombre() 
                        + "'' ha sido realizado con exito!!."
                        + "\nFondos actuales:" + socio.getFondos());
                        ingresado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error al ingresar fondos. \nVerique no sobrepasar los limites: \n" 
                    + "No mayor a: 5.000.000 Para socios VIP \n1.000.000 Para socios regulares."
                    + "No menor a: 100.000 Para VIP \n50.000 Para socios regulares");
                    ingresado = false;
                }
            }
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

    public Persona buscarCedulaPersona(String cedula) {
        Persona encontrado = null;
        NodoDoble nodoEncontrado = personas.buscarCedulaPersona(cedula);
        if (nodoEncontrado != null) {
            encontrado = nodoEncontrado.getPersona();
        }             
        return encontrado;
    }

    

    public boolean eliminarSocio (String cedula) {
        boolean eliminado = false;
        Socios socio = null;
        if (buscarCedula(cedula) != null) {
            socio = buscarCedula(cedula);
            if(socio.getTipoSuscripcion() == "VIP") {
                JOptionPane.showMessageDialog(null, "El socio que esta intentando eliminar es VIP, por tanto esta eliminacion no es posible.");
            } else if ( socio.getTipoSuscripcion() == "Regular") {
                if(consumos.listaVacia()) {
                    socios.eliminar(socio);
                    eliminado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Socio tiene pagos pendientes, por tanto no se pudo eliminar.\n Pague los consumos primero y vuelva a intentar.");
                }
            } 
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el socio que desea eliminar. Por favor verique que la cedula ingresada sea la correcta.");
        }

        return eliminado;
    }

    public void eliminarConsumo () {
        //Mostrar consumos por cedula
        String cedula = mostrarTodosConsumos();
        double descontar = 0.0;
        String concepto = JOptionPane.showInputDialog("Ingrese el concepto de la factura que desee eliminar.");

        if (buscarCedula(cedula) != null) {
            Socios socio = buscarCedula(cedula);
            Consumos consumo = consumos.buscarConsumo(cedula, concepto);
            if (socio.getFondos() >= consumo.getValor()) {
                socio.setFondos(socio.getFondos() - consumo.getValor());
                consumos.eliminar(cedula, concepto);
            }
            socio.setFondos(socio.getFondos()-descontar);

        }

    }

    public String mostrarTodosConsumos () {
        //Este metodo solo imprime las facturas o consumos con sus respectivos datos
        // y devuelve la cedula del socio para poder utilizarse en eliminarConsumo().
        String cedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio que quiere consultar por facturas pendientes.");
        int numFacturasPendientes = consumos.imprimirConsumos(cedula);
        if (numFacturasPendientes >= 1 ) {
            JOptionPane.showMessageDialog(null, "El total de facturas pendientes es: " + numFacturasPendientes);
        } else {
            JOptionPane.showMessageDialog(null, "El socio al cual realizo la busqueda no cuenta con consumos realizados.");
        }
        return cedula;
    }
}

