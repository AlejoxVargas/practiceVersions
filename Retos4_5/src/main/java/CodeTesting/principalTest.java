package codeTesting;

import Instituto.alumno; //he importado la clase alumno desde el paquete Instituto para que ahora pueda ser manejada desde esta clase principal
import java.time.LocalDate;
import java.util.Scanner;

public class principalTest {

    static Scanner sc = new Scanner(System.in);
    static alumno alumnoAux = new alumno();

    public static void main(String[] args) {

        alumno[] grupo = new alumno[6];
        grupo[0] = new alumno(crearNombre(), crearApellido(), LocalDate.of(1996, 1, 16));
        grupo[1] = new alumno(crearNombre(), crearApellido(), LocalDate.of(1995, 1, 3));
        grupo[2] = new alumno(crearNombre(), crearApellido(), LocalDate.of(1996, 11, 9));
        grupo[3] = new alumno(crearNombre(), crearApellido(), LocalDate.of(1997, 2, 11));
        grupo[4] = new alumno(crearNombre(), crearApellido(), LocalDate.of(1996, 11, 9));

        int opcion;
        do {
            opcion = menu();
            if (opcion != 0) {
                alumnoAux = elegirAlumno(grupo, alumnoAux);
            }
            switch (opcion) {
                case 1 -> {
                    opcion = elegirAsignatura();
                    switch (opcion) {
                        case 1 ->
                            alumno.setNotaIngles(alumnoAux, elegirNota());
                        case 2 ->
                            alumno.setNotaFrances(alumnoAux, elegirNota());
                        case 3 ->
                            alumno.setNotaAleman(alumnoAux, elegirNota());
                    }
                }
                case 2 -> {
                    alumno.calcularMedia(alumnoAux);
                }
                /* TESTING PHASE FOR further implementation 
                case 3 -> {
//                    int cantidad = 1;
//                    alumno grupo[] = new alumno[6];
//                    for (int i = 0; i < cantidad; i++) {
//                        grupo[i] = new alumno(crearNombre(), crearApellido(), LocalDate.of(crearAño(), crearMes(), crearDia()));
//                    }
//                    System.out.println("¿Quiere registrar a otro estudiante?");
                }*/
                default ->
                    System.out.println("Fin");
            }
        } while (opcion
                != 0);
    }

    static int menu() {
        int opcion;
        do {
            System.out.println(
                    "\tMENÚ INSTITUTO"
                    + "\n----------------------------"
                    + "\n 1.-Asignar Nota"
                    + "\n 2.-Calcular Media"
                    + "\n 3.-Registrar Alumno"
                    + "\n 0.-Salir\n");
            System.out.println(" Seleccione opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 2);
        return opcion;
    }

    static alumno elegirAlumno(alumno[] grupoArray, alumno alumnoX) {
        System.out.println("Elegir estudiante: ");
        switch (sc.nextInt()) {
            case 1 ->
                alumnoAux = grupoArray[0];
            case 2 ->
                alumnoAux = grupoArray[1];
            case 3 ->
                alumnoAux = grupoArray[2];
            case 4 ->
                alumnoAux = grupoArray[3];
            case 5 ->
                alumnoAux = grupoArray[4];
        }
        return alumnoAux;
    }

    static int elegirAsignatura() {
        System.out.println("1.-Inglés\n2.-Francés\n3.-Aleman\n");
        System.out.println("Seleccione opción: ");
        int opcion = sc.nextInt();
        return opcion;
    }

    static double elegirNota() {
        System.out.println("Digita número entre 0-10 (con o sin decimales)");
        double opcion = sc.nextDouble();
        return opcion;
    }

    static String crearNombre() {
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        return nombre;
    }

    static String crearApellido() {
        System.out.println("Apellido:");
        String apellido = sc.nextLine();
        return apellido;
    }

    static int crearAño() {

        System.out.println("Año: ");
        int año = sc.nextInt();
        return año;
    }

    static int crearMes() {
        System.out.println("Mes: ");
        int mes = sc.nextInt();
        return mes;
    }

    static int crearDia() {
        System.out.println("Día: ");
        int dia = sc.nextInt();
        return dia;
    }

    /* //testing phase  and future improvements  
    
    static alumno registrarAlumno() {
        boolean llave = true;
        int cantidad = 1;
        alumno grupo[] = new alumno[6];
        do {
            for (int i = 0; i < cantidad; i++) {
                grupo[i] = new alumno(crearNombre(), crearApellido(), LocalDate.of(crearAño(), crearMes(), crearDia()));
            }
            System.out.println(
                    "¿Quiere registrar a otro estudiante?"
                    + "\n1.Si"
                    + "\n2.No");
            int opcion = sc.nextInt();
            if (opcion == 1) {
                llave = true;
                cantidad++;
            }
        } while (llave);
        return alumno;
    
    }*/
}
