package matricesUnidimensionales;

import java.util.Scanner;

/*2. Mejorar el programa anterior de forma que el array de caracteres con las letras de la ‘A’ a la ‘Z’ se rellene de forma automática teniendo en cuenta 
que en la tabla ASCII la letra 'A' corresponde al número 65 y la letra 'Z' corresponde al número 90.*/
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner("System.in");
        char[] charArray = new char[25];
        int posicion;
        boolean llave = false;
        int ascii = 65;
        String acumulador = "";
        do {
            System.out.println("Enter the array position: ");
            posicion = sc.nextInt();

            if (posicion > charArray.length) {
                System.out.println("Insertar números entre 0 y 25");
            } else if (posicion < 0) {
                llave = true;
            } else {
                for (int i = 0; i < charArray.length; i++) {
                    System.out.println(ascii);
                    ascii+=1;
                }
                System.out.println("Se añade la: " + "\'" + charArray[posicion] + "\'");
                acumulador += charArray[posicion];
            }

        } while (!llave);
        System.out.println("Fin de la ejecución");
        System.out.println("Cadena final: " + acumulador);

    }
}
