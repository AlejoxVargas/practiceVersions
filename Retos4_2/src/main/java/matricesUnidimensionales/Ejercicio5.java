package matricesUnidimensionales;

import java.util.Scanner;

/**
 *
 * @author Alejandro Vargas
 */
public class Ejercicio5 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //nombreEstudiante();
        notaEstudiante();
    }

    static void notaEstudiante() {
        double nota = 0;
        double[] notaArray = new double[9];
        for (int i = 0; i < notaArray.length; i++) {
            do {
                System.out.println("Inserte una nota entre 0 y 10: ");
                nota = sc.nextDouble();
            } while (nota <= 0 || nota >= 10);
            notaArray[i] = sc.nextDouble();
        }
        for (double notaArray2 : notaArray) {
            System.out.println("la nota es: " + notaArray2);
        }   
    }

    static void nombreEstudiante() {
        String[] nombreArray = new String[5];

        for (int i = 0; i < nombreArray.length; i++) {
            System.out.println("Inserter nombre del estudiante: ");
            nombreArray[i] = sc.nextLine();
        }
        for (String nombreArray2 : nombreArray) {
            System.out.println("Nombre del estudiante: " + nombreArray2);
        }
    }
}
