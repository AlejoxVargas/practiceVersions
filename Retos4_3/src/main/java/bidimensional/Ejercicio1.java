package bidimensional;

import java.util.Scanner;

/*1. Escribir un programa que pida al usuario un número n y dibuje un cuadrado de n elementos de lado utilizando '*' mediante matrices bidimensionales*/
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese tamaño de cuadro: ");
        int square = sc.nextInt();
        //cuadradoAsteriscos(square);
        cuadradoHueco(square);
    }

    static void cuadradoAsteriscos(int tamaño) {
        char[][] matrix = new char[tamaño][tamaño];
        for (int fila = 0; fila < matrix.length; fila++) {
            for (int z = 0; z < matrix.length; z++) {
                matrix[fila][z] = '*';
                System.out.print(matrix[fila][z]);
            }
            System.out.println();
            //metodo a parte que le pase el array de escribir y me imprima
        }
    }

    /*Escribir una segunda versión donde el cuadrado esté hueco*/
    static void cuadradoHueco(int tamaño) {
        char[][] matrix = new char[tamaño][tamaño];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if ( i == 0 || i == matrix.length -1 || j == 0 || j == matrix.length -1) {
                   System.out.print("*");
                } else {
                   System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
