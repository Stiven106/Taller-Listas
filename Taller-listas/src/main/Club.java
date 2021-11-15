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

        if (tipoSuscripcion == "VIP") {
            fondos = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese fondos *obligatorio* \n Recuerde: \n"+
            "Como socio VIP debe ingresar un monto no inferior a 100.000 y no mayor a 5.000.000."));
        } else if (tipoSuscripcion == "Regular") {
            fondos = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese fondos *obligatorio* \n Recuerde: \n"+
            "Como socio regular debe ingresar un monto no inferior a 50.000 y no mayor a 1.000.000."));
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al ingresar los fondos, verifique por favor que el monto sea el correcto y vuelva a intentarlo. \n No se logro la afiliacion");
            return;
        }

        //Cedula no repetir
        if (buscarCedula(cedula) == null && buscarCedulaPersona(cedula) == null) {
            Socios socioNuevo = new Socios(nombre, cedula, tipoSuscripcion, fondos);
            socios.insertarAlInicio(socioNuevo);
            JOptionPane.showMessageDialog(null, "El socio " + tipoSuscripcion + " ha sido creado con exito!!.");
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al afiliar un socio: La cedula ingresada ya existe en nuestra base de datos. ");
        }
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

    public void ingresoFondos() {
        String cedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio para ingresar nuevos fondos.");
        double ingresoValor =  Double.parseDouble(JOptionPane.showInputDialog("Digite el monto a ingresar a la cuenta."));
        
        //Variables nulas para trabajar
        Socios socio = null;

        if (buscarCedula(cedula) != null) {
            socio = buscarCedula(cedula);
            if(socio.getTipoSuscripcion() == "VIP") {
                if(ingresoValor+socio.getFondos() < 5000000) {
                    buscarCedula(cedula).setFondos(socio.getFondos()+ingresoValor);
                    JOptionPane.showMessageDialog(null, "El consumo del afiliado con nombre:  '" + socio.getNombre() 
                    + "' ha sido realizado con exito!!."
                    + "\nFondos actuales:" + socio.getFondos());
                }
            } else if ( socio.getTipoSuscripcion() == "Regular") {
                if (ingresoValor+socio.getFondos() < 1000000) {
                    buscarCedula(cedula).setFondos(socio.getFondos()+ingresoValor);
                    JOptionPane.showMessageDialog(null, "El consumo del afiliado con nombre:  '" + socio.getNombre() 
                    + "'' ha sido realizado con exito!!."
                    + "\nFondos actuales:" + socio.getFondos());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al ingresar fondos. \nVerique no sobrepasar el limite: \n" 
                + "5.000.000 Para socios VIP \n1.000.000 Para socios regulares.");
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

    public String mostrarTodosConsumos () {
        String cedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio/persona que quiere consultar por facturas pendientes.");
        int numFacturasPendientes = consumos.buscarConsumos(cedula);
        if (numFacturasPendientes >= 1 ) {
            JOptionPane.showMessageDialog(null, "El total de facturas pendientes es: " + numFacturasPendientes);
        } else {
            JOptionPane.showMessageDialog(null, "El socio al cual realizo la busqueda no cuenta con consumos realizados.");
        }
        return cedula;
    }

    public void eliminarSocio () {
        Socios socio = null;
        String cedula =  JOptionPane.showInputDialog("Ingrese la cedula del socio que quiere eliminar del sistema.");
        if (buscarCedula(cedula) != null) {
            socio = buscarCedula(cedula);
            if(socio.getTipoSuscripcion() == "VIP") {
                JOptionPane.showMessageDialog(null, "El socio que esta intentando eliminar es VIP, por tanto esta eliminacion no es posible.");
            } else if ( socio.getTipoSuscripcion() == "Regular") {
                if(consumos.listaVacia()) {
                    socios.eliminar(socio);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el socio que desea eliminar. Por favor verique que la cedula ingresada sea la correcta.");
            }
        } 
    }

    public void eliminarConsumo () {
        //Mostrar consumos por cedula
        String cedula = mostrarTodosConsumos();
        consumos.buscarConsumos(cedula);

        //Empezamos a construir el metodo para eliminar consumo
        String concepto =JOptionPane.showInputDialog("Ingrese el concepto de la factura que desee eliminar.");
       consumos.eliminar(cedula, concepto);
    }

}
