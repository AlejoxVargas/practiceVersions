package MatricesUnidimensionales;

import java.util.Scanner;

public class Ejercicio1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*Versión 1: Escribir un programa que lea un entero por teclado y diga si se encuentra en el array números.*/

        int[] getArray = {12, 15, 13, 10, 8, 9, 13, 14};
        System.out.println("Enter a number in the array: ");
        int n = sc.nextInt();

        boolean llave = false;
        for (int i = 0; i < getArray.length; i++) {
            if (getArray[i] == n) {
                llave = true;
            }
        }
        if (llave == true) {
            System.out.println("The number was found.");
        } else {
            System.out.println("The number wasn't found.");
        }
    }
}
