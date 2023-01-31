package Retos2_3_4;

import java.time.LocalDate;

/*4.- Clase LocalDate del paquete java.Time. Mirar en la API de Java esta clase y:

Construir un objeto de la clase LocalDate con la fecha de hoy
Visualizar la información del objeto
Añadir un día a esa fecha
Visualizar la información del objeto

 */
public class claseLocalDate {

    public static void main(String[] args) {
        LocalDate fechahoy = LocalDate.now();
        System.out.println("Fecha de hoy: " + fechahoy);
        fechahoy = fechahoy.plusDays(1);
        System.out.println("Fecha de hoy más un día: " + fechahoy);
    }

}
