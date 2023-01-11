package MatricesUnidimensionales;

import java.util.Scanner;

/*Escribir un método alternar() al que se le pase como argumento el array números y dos índices del array. 
El método alternará los valores contenidos en los dos índices. Se deberá comprobar que los índices están dentro del rango del array.*/
public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] getArray = {12, 15, 13, 10, 8, 9, 13, 14};
        System.out.println("Escribir primer índice: ");
        int posicion1 = sc.nextInt();
        System.out.println("Escribir segundo índice: ");
        int posicion2 = sc.nextInt();
        alternar(getArray, posicion1, posicion2);
    }

    static boolean alternar(int[] getArray, int posicion1, int posicion2) {
        for (int i : getArray) {
            if (posicion1 < 0 || posicion1 > getArray.length && posicion2 < 0 || posicion1 > getArray.length) {
                
            }

        }
    }
}
