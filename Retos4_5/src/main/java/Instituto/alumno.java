package Instituto;

import java.time.LocalDate;
import java.util.Scanner;

public class alumno {

    static Scanner sc = new Scanner(System.in);

    //Atriu¡butos 
    String nombre;
    String apellido;
    LocalDate fechaNacimiento;
    double[] notas = new double[3];

    //Constructor 
    public alumno(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public alumno() {
    }

    //Metodos
    static void setNotaIngles(alumno alumnoX) {
        System.out.println("Nota Inglés: ");
        int notaIngles = sc.nextInt();
        
        if (notaIngles < 0 || notaIngles > 10) {
            System.out.println("Calificación incorrecta");
        } else {
            alumnoX.notaIngles = notaIngles;
            System.out.println("Exitosa asignación");
            System.out.println(alumnoX.toString());
        }
    }

    static void setNotaFrances(alumno alumnoX) {
        System.out.println("Nota francés: ");
        int notaFrances = sc.nextInt();

        if (notaFrances < 0 || notaFrances > 10) {
            System.out.println("Calificación incorrecta");
        } else {
            alumnoX.notaFrances = notaFrances;
            System.out.println("Exitosa asignación");
            System.out.println(alumnoX.toString());
        }
    }

    static void setNotaAleman(alumno alumnoX) {
        System.out.println("Nota Alemán: ");
        int notaAleman = sc.nextInt();
        
        if (notaAleman < 0 || notaAleman > 10) {
            System.out.println("Calificación incorrecta");
        } else {
            alumnoX.notaAleman = notaAleman;
            System.out.println("Exitosa asignación");
            System.out.println(alumnoX.toString());
        }
    }

    //Calcular Media
    static void calcularMedia(alumno alumX) {
        double resultado = (alumX.notaIngles + alumX.notaFrances + alumX.notaAleman) / 3;
        System.out.println("Nota media: " + resultado);
    }

    //ToString 
    @Override
    public String toString() {
        return "\tResumen del estudiante"
                + "\nNombre del estudiante: " + nombre
                + "\nIngles:" + notaIngles
                + "\nFrancés:" + notaFrances
                + "\nAlemán:" + notaAleman;

    }
}
