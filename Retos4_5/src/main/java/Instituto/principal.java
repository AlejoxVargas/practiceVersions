package Instituto;

import java.time.LocalDate;
import java.util.Scanner;

public class principal {

    static Scanner sc = new Scanner(System.in);
    static alumno alumnoAux = new alumno();

    public static void main(String[] args) {

//        alumno grupo[] = new alumno[6];
//        for (int i = 0; i < grupo.length; i++) {
//            grupo[i] = new alumno(crearNombre(), crearApellido(), LocalDate.of(crearAño(), crearMes(), crearDia()));
//        }
        int opcion;
        do {
            opcion = menu();
            if (opcion != 0) {
                //alumnoAux = elegirAlumno();
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
                case 3 -> {
//                    int cantidad = 1;
//                    alumno grupo[] = new alumno[6];
//                    for (int i = 0; i < cantidad; i++) {
//                        grupo[i] = new alumno(crearNombre(), crearApellido(), LocalDate.of(crearAño(), crearMes(), crearDia()));
//                    }
//                    System.out.println("¿Quiere registrar a otro estudiante?");
                }
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

    static alumno elegirAlumno(alumno alumnoX) {
        System.out.println("Elegir estudiante: ");
        switch (sc.nextInt()) {
            case 1 ->
                alumnoAux = alumnoX;
            case 2 ->
                alumnoAux = alumno2;
            case 3 ->
                alumnoAux = alumno3;
            case 4 ->
                alumnoAux = alumno4;
            case 5 ->
                alumnoAux = alumno5;
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
    }
}

