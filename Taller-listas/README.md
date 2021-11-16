## Club social implementando estructuras tipo lista

El proposito de este documento es facilitar el ingreso de datos, resolver dudas, explicar de cierta forma el funcionamiento de este proyecto.

Para ello procederemos a explicar uno a uno, cada opcion proporcionada dentro del archivo "ppl".

## Opcion 1: Crear un socio

- Fondos socio: En este caso los fondos se ingresan sin puntos. 

Ejemplo: 125000 = Correcto
Ejemplo: 125.000 = Incorrecto

Ademas, si se ingresan mal los datos tomando en cuenta los limites, el ingreso de los fondos queda en bucle hasta que se ingrese correctamente. 

## Opcion 2: Ingresar personas 

- No hay nada a destacar.

## Opcion 3: Ingresar consumos 

- Los consumos de una persona autorizada en automatico se ingresan al socio al cual esta afiliado, por tanto si luego se va a consultar/pagar por estos, ya no se utiliza la CC de la persona, si no del socio en cuestion.

## Opcion 4: Consultar facturas pendientes
- Segun lo mencionado en la documentacion de la opcion 3, las personas autorizadas no cuentan con una lista de consumos. Todos los consumos realizados se cargan a la cuenta del socio. Por tanto si se ingresa la cedula de una persona autorizada, no va a encontrar nada.

- Para saber que consumos realizo una persona, simplemente ingrese la cedula del socio al que este afiliado esa persona, y se le detallara una lista. En esta lista podra ver los nombres los cuales seran de la persona que en realidad realizo el consumo, tratese de un socio, o la persona afiliada.


## Opcion 5: Ingresar fondos


- Segun nosotros no era necesario poder ingresar fondos a la cuenta de una persona autorizada, por tanto esta opcion no esta habilitada. Solo se pueden ingresar fondos a la "cuenta" de un socio.


## Opcion 6: Eliminar socio

- No hay nada a destacar.

## Opcion 7: Buscar consumo por cedula

- No hay nada a destacar.
