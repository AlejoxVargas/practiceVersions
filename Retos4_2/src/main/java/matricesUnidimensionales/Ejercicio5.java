package matricesUnidimensionales;

import java.util.Scanner;

/**
 *
 * @author Alejandro Vargas
 */

/*5. Crear un array de números y otro de strings de 5 posiciones. En el array de números se insertarán notas entre 0 y 10 
(habrá que controlar que se inserte una nota correcta), la nota puede tener decimales, en el array de strings se insertarán los 
nombres de los alumnos.

Después, crear un array de strings donde se insertarán los resultados de la notas con palabras.

Si la nota está entre 0 y 4,99 , será un suspenso
Si está entre 5 y 6,99 , será un bien.
Si está entre 7 y 8,99 será un notable.
Si está entre 9 y 10 será un sobresaliente.

Mostrar por pantalla, el alumno, su nota y su resultado en palabras. Crear los métodos que se consideren convenientes.*/
public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double notaAlumnos;
        double[] notaArray = new double[1];
        String[] nombreArray = new String[5];

        for (int index = 0; index < nombreArray.length; index++) {
            System.out.println("Inserte una nota entre 0 y 10: ");
            notaAlumnos = sc.nextDouble();
            sc.nextLine();

            System.out.println("Inserter nombre del estudiante: ");
            nombreArray[index] = sc.nextLine();

            System.out.println("Nombre Alumno: " + nombreArray[index] + "\nNota Palabra: " + notaEnPalabra(notaAlumnos));
            notaEnNumero(notaArray, notaAlumnos);

            System.out.println();
        }
    }

    static void notaEnNumero(double[] notaArreglo, double nota) {

        for (int i = 0; i < notaArreglo.length; i++) {
            notaArreglo[i] = nota;
        }
        for (double notaArray2 : notaArreglo) {
            System.out.println("Nota en número: " + notaArray2);
        }
    }

    static String notaEnPalabra(double nota) {
        String acumulador = "";

        if (nota >= 0 && nota <= 4.99) {
            acumulador = "Suspenso";
        } else if (nota >= 5 && nota <= 6.99) {
            acumulador = "Bien";
        } else if (nota >= 7 && nota <= 8.99) {
            acumulador = "Notable";
        } else if (nota >= 9 && nota <= 10) {
            acumulador = "Sobresaliente";
        }
        return acumulador;
    }
}
