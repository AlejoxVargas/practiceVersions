package MatricesUnidimensionales;

import java.util.Scanner;

/*Ejercicio 2:
Escribir un programa que lea un entero por teclado y diga si se encuentra en el array números indicando las posiciones en las que se encuentra.*/
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] getArray = {12, 15, 13, 10, 8, 9, 13, 14};

        int posicion = -1;
        System.out.println("Enter a number in the array: ");
        int integer = sc.nextInt();

        for (int i = 0; i < getArray.length; i++) {
            if (getArray[i] == integer) {
                posicion = i; //me falta arreglar que me pueda imprimir que 13 esta dos veces 
            }
        }
        if (posicion == -1) {
            System.out.println("No se encontró el número");
        } else {
            System.out.println("La posición de " + integer + " es: " + posicion);
        }
    }

}
