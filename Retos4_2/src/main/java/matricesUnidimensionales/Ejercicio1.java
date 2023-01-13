package matricesUnidimensionales;

import java.util.Scanner;

/*1. Construir un array de caracteres que contenga las letras de la ‘A’ a la ‘Z’ (solo las mayúsculas sin tener en cuenta las letras 'Ñ', 'LL'...). 
Posteriormente se pedirán posiciones del array por teclado y, si la posición es correcta, se añadirá el carácter correspondiente 
a una cadena que se imprimirá al final, se dejará de insertar cuando se introduzca un número negativo.

Por ejemplo, si se introducen los siguientes números:
0 // Se añade la ‘A’
6 // Se añade la ‘G’
25 // Se añade la ‘Z’
50 // Insertar números entre 0 y 25
-3 // Fin

Cadena final: AGZ*/
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int posicion;
        boolean llave = false;
        String acumulador = "";
        do {
            System.out.println("Enter the array position: ");
            posicion = sc.nextInt();

            if (posicion > charArray.length) {
                System.out.println("Insertar números entre 0 y 25");
            } else if (posicion < 0) {
                llave = true;
            } else {
                System.out.println("Se añade la: " + "\'" + charArray[posicion] + "\'");
                acumulador += charArray[posicion];
            }
            
        } while (!llave);
        System.out.println("Fin de la ejecución");
        System.out.println("Cadena final: " + acumulador);
    }
}
