package bidimensional;

import java.util.Scanner;

/*2. Realizar un programa que pida 20 números enteros. Estos números se deben introducir en un array de 4 filas por 5 columnas. 
El programa mostrará las sumas parciales de filas y columnas igual que si de una hoja de cálculo se tratara. 
La suma total debe aparecer en la esquina inferior derecha.*/
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arrayEnteros = new int[4][5];
        int contador = 20;
        for (int i = 0; i < arrayEnteros.length; i++) {
            for (int j = 0; j < arrayEnteros[0].length; j++) {
                System.out.println("Escriba " + contador + " números enteros: ");
                arrayEnteros[i][j] = sc.nextInt();
                contador--;
            }
        }
        int fila = 0;
        int columna = 0;
        int total = 0;

        for (int i = 0; i < arrayEnteros.length; i++) {
            int suma = 0;
            for (int j = 0; j < arrayEnteros[0].length; j++) {
                suma += arrayEnteros[i][j];
                System.out.print("\t" + arrayEnteros[i][j]);
            }
            System.out.println("\t[fila " + fila + " suma: " + suma);
            fila++;
            total += suma;
        }
        for (int j = 0; j < arrayEnteros[0].length; j++) {
            int suma = 0;
            for (int i = 0; i < arrayEnteros.length; i++) {
                suma += arrayEnteros[i][j];
            }          
            System.out.print("\t[" + suma);
            columna++;
            total += suma;
        }
        System.out.print("\t[Total: " + total);
    }
}
