package Instituto;

import java.time.LocalDate;
import java.util.Scanner;

public class principal {

    static Scanner sc = new Scanner(System.in);
    
    static alumno[] grupo = new alumno[6];
    static alumno alumno1 = new alumno("Jennie", "Kim", LocalDate.of(1996, 1, 16));
    static alumno alumno2 = new alumno("Ji-soo", "Kim", LocalDate.of(1995, 1, 3));
    static alumno alumno3 = new alumno("Lalisa", "Manobal", LocalDate.of(1997, 3, 27));
    static alumno alumno4 = new alumno("Roseanne", "Park", LocalDate.of(1997, 2, 11));
    static alumno alumno5 = new alumno("Momo", "Hirai", LocalDate.of(1996, 11, 9));
    static alumno alumnoAux = new alumno();

    public static void main(String[] args) {

        int opcion;
        do {
            opcion = menu();
            if (opcion != 0) {
                alumnoAux = elegirAlumno();
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
                default ->
                    System.out.println("Fin");
            }
        } while (opcion != 0);

    }

    static int menu() {
        int opcion;
        do {
            System.out.println(
                    "\tMENÚ INSTITUTO"
                    + "\n----------------------------"
                    + "\n 1.-Asignar Nota"
                    + "\n 2.-Calcular Media"
                    + "\n 0.-Salir\n");
            System.out.println(" Seleccione opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 2);
        return opcion;
    }

    static alumno elegirAlumno() {
        System.out.println("Elegir estudiante: ");
        switch (sc.nextInt()) {
            case 1 ->
                alumnoAux = alumno1;
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
}
