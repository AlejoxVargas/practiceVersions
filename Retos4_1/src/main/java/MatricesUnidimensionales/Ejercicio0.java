package MatricesUnidimensionales;

import java.util.Scanner;

/*Escribir un programa que lea 6 enteros por teclado y los almacene en un array. Visualizar su contenido.

Idem con 6 cadenas de caracteres.

Idem con 6 caracteres*/
public class Ejercicio0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*----------------Enteros-------------------*/
        int vectorEnteros[] = new int[6];

        for (int i = 0; i < vectorEnteros.length; i++) {
            System.out.println("Introducir valores enteros: ");
            vectorEnteros[i] = sc.nextInt();
        }

        for (int i = 0; i < vectorEnteros.length; i++) {
            System.out.println("Contenido de índice " + i + " es: " + vectorEnteros[i]);
        }
        System.out.println();

        /*----------Cadena de caracteres----------*/
        String vectorString[] = new String[6];
        sc.nextLine();
        for (int i = 0; i < vectorString.length; i++) {
            System.out.println("Introducir valores de cadena de caracteres: ");
            vectorString[i] = sc.nextLine();
        }

        for (String vectorString1 : vectorString) {
            System.out.println("Contenido : " + vectorString1);
        }
        System.out.println();

        /*------------6 caracteres---------------*/
        char vectorChar[] = new char[6];

        for (int i = 0; i < vectorChar.length; i++) {
            System.out.println("Introducir valores de caracteres: ");
            vectorChar[i] = (char) sc.next().charAt(0);
        }

        for (int i = 0; i < vectorChar.length; i++) {
            System.out.println("Contenido de índice: " + i + " es: " + vectorChar[i]);
        }
    }
}
