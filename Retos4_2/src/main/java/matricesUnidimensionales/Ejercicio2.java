package matricesUnidimensionales;

import java.util.Scanner;

/*2. Mejorar el programa anterior de forma que el array de caracteres con las letras de la ‘A’ a la ‘Z’ se rellene de forma automática teniendo en cuenta 
que en la tabla ASCII la letra 'A' corresponde al número 65 y la letra 'Z' corresponde al número 90.*/
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray = new char[26];
        int posicion;
        String acumulador = "";

        do {
            System.out.println("Insertar número entre 0 y 25: ");
            posicion = sc.nextInt();
            if (posicion >= 0 && posicion < charArray.length) {
                System.out.println("Se añade la: " + "\'" + arregloAscii(charArray, posicion) + "\'");
                //acumulador += arregloAscii(charArray, posicion); esta linea con función y la de abajo hacen lo mismo, la pregunta es: ¿Cómo lo hacen?
                acumulador += charArray[posicion]; 
            }
        } while (posicion >= 0);
        System.out.println("Fin de la ejecución");
        System.out.println("Cadena final: " + acumulador);

    }

    static char arregloAscii(char[] arreglo, int posi) {
        for (int i = 0, ascii = 65; i < arreglo.length; i++, ascii++) {
            arreglo[i] = (char) ascii;
        }
        return arreglo[posi];
    }
}
