package Instituto;

import java.time.LocalDate;
import java.util.Scanner;

public class principal {
    static Scanner sc = new Scanner(System.in);
    static alumno alumnoAux = new alumno();
    static alumno[] grupo = new alumno[2];

    public static void main(String[] args) {
        int llave;
        do {
            llave = menu();
            switch (llave) {
                case 1 -> {
                    //elegirAlumno(grupo, alumnoAux);
                    switch (elegirAsignatura()) {
                        case 1 -> alumno.setNotaIngles(elegirAlumno(grupo, alumnoAux), elegirNota());
                        case 2 -> alumno.setNotaFrances(elegirAlumno(grupo, alumnoAux), elegirNota());
                        case 3 -> alumno.setNotaAleman(elegirAlumno(grupo, alumnoAux), elegirNota());
                    }
                }
                case 2 -> alumno.calcularMedia(alumnoAux);

                case 3 -> registrarAlumno(grupo);
                default -> System.out.println("Fin");

            }
        } while (llave != 0);
    }

    static int menu() {
        int opcion;
        do {
            System.out.println(
                    """
                            \tMENÚ INSTITUTO
                            ----------------------------
                             1.-Asignar Nota
                             2.-Calcular Media
                             3.-Registrar Alumno
                             0.-Salir
                            """);
            System.out.println(" Seleccione opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    static alumno[] registrarAlumno(alumno[] grupo) {
        String nombre;
        String apellido;
        int year, month, day;

        for (int i = 0; i < grupo.length; i++) {
            sc.nextLine();
            System.out.println("Nombre: " + (i + 1));
            nombre = sc.nextLine();
            System.out.println("Apellido: " + (i + 1));
            apellido = sc.nextLine();
            System.out.println("Fecha de nacimiento year/month/day: " + (i + 1));
            year = sc.nextInt();
            month = sc.nextInt();
            day = sc.nextInt();
            grupo[i] = new alumno(nombre, apellido, LocalDate.of(year, month, day));
            System.out.println(grupo[i]);
        }
        return grupo;
    }

    static alumno elegirAlumno(alumno[] alumno, alumno alumnoX) {
        boolean llave = false;
        int elegirEstudiante;

        for (alumno value : alumno) {
            if (value != null) {
                llave = false;
                break;
            } else {
                llave = true;
            }
        }
        if (llave) {
            System.out.println("Parece que no has registrado ningún estudiante");
        } else {
            System.out.println("Elegir estudiante: ");
            elegirEstudiante = sc.nextInt();
            for (int i = 0; i < alumno.length; i++) {
                if (i == elegirEstudiante) {
                    alumnoX = alumno[i];
                }
            }
        }
        return alumnoX;
    }

    static int elegirAsignatura() {
        int asignatura;
        do {
            System.out.println("1.-Inglés\n2.-Francés\n3.-Aleman");
            asignatura = sc.nextInt();
        } while (asignatura < 1 || asignatura > 3);
        return asignatura;
    }

    static double elegirNota() {
        double numeroNota;
        do {
            System.out.println("Digita número entre 0-10 (con o sin decimales)");
            numeroNota = sc.nextDouble();
        } while (numeroNota < 0 || numeroNota > 10);
        return numeroNota;
    }

}

