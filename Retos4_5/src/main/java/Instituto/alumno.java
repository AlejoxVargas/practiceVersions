package Instituto;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class alumno {

    //Atributos 
    String nombre;
    String apellido;
    LocalDate fechaNacimiento;
    static double[] notas = new double[3];

    //Constructor 
    public alumno(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public alumno() {
    }

    //Metodos
    public static void setNotaIngles(alumno alumnoX, double notaIngles) {
        if (notaIngles < 0 || notaIngles > 10) {
            System.out.println("Calificación incorrecta");
        } else {
            notas[0] = notaIngles;
            //alumnoX.notas[0] = notaIngles;
            System.out.println("Exitosa asignación");
            System.out.println(alumnoX.toString());
        }
    }

    public static void setNotaFrances(alumno alumnoX, double notaFrances) {
        if (notaFrances < 0 || notaFrances > 10) {
            System.out.println("Calificación incorrecta");
        } else {
            notas[1] = notaFrances;
            System.out.println("Exitosa asignación");
            System.out.println(alumnoX.toString());
        }
    }

    public static void setNotaAleman(alumno alumnoX, double notaAleman) {
        if (notaAleman < 0 || notaAleman > 10) {
            System.out.println("Calificación incorrecta");
        } else {
            notas[2] = notaAleman;
            System.out.println("Exitosa asignación");
            System.out.println(alumnoX.toString());
        }
    }

    //Calcular Media
    public static void calcularMedia(alumno alumnoX) {
        DecimalFormat df = new DecimalFormat("##.##");
        double resultado = (alumnoX.notas[0] + alumnoX.notas[1] + alumnoX.notas[2]) / 3;
        System.out.println("\nNombre: " + alumnoX.nombre + "\nApellido: " + alumnoX.apellido + "Nota media:" + df.format(resultado));
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre
                + "\nApellido: " + apellido
                + "\nFecha nacimiento: " + fechaNacimiento
                + "\nIngles: " + notas[0]
                + "\nFrancés: " + notas[1]
                + "\nAlemán: " + notas[2]
                + "\n";
    }
}
