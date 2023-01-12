package MatricesUnidimensionales;

import java.util.Scanner;

/*Ejercicio 2

Escribir un programa que lea un entero por teclado y diga si se encuentra en el array números indicando las posiciones en las que se encuentra.*/

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] getArray = {12, 15, 13, 10, 8, 9, 13, 14};
        System.out.println("Enter a number in the array: ");
        int integer = sc.nextInt();
        boolean llave = false;

        for (int i = 0; i < getArray.length; i++) {
            if (getArray[i] == integer) {
                llave = true;
                System.out.println("La posición de " + integer + " es: " + i);
            }
        }
        if (llave == false) {
            System.out.println("No se encontró el número");
        }
    }

}
