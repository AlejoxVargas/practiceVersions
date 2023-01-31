package Reto2_2_2;

import java.util.Scanner;

/*2.- Desde el programa principal, utilizar la clase String para hacer el siguiente ejercicio:

pedir al usuario dos cadenas de caracteres
concatenarlas y visualizar la longitud de la cadena resultante
recuperar el 3º carácter de las dos
pasar a mayúsculas y luego a minúsculas la cadena resultante

 */
public class RetoString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cadena1, cadena2;
        System.out.println("Escriba primera cadena: ");
        cadena1 = sc.nextLine();
        System.out.println("Escriba segunda cadena: ");
        cadena2 = sc.nextLine();

        System.out.println("Longitud de la cadena: \n" + (cadena1.concat(cadena2).length()));

        System.out.println("3 carácter de las dos:\n" + cadena1.charAt(2) + "\n" + cadena2.charAt(2));

        System.out.println("Cadena resultante en Mayusculas:\n" + cadena1.toUpperCase() + " " + cadena2.toUpperCase());

        System.out.println("Cadena resultante en Minuscula:\n" + cadena1.toLowerCase() + " " + cadena2.toLowerCase());
    }

}
