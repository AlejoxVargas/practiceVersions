package defaultPack;

import java.util.Scanner;

/**
 * @author USUARIO CCC - TARDE
 */
public class Ejercicio1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduzca un número de elementos: ");
        int cantidad = sc.nextInt();

        int[] getArray = new int[cantidad];
        int contador = cantidad;
        int arrange;

        for (int i = 0; i < getArray.length; i++, contador--) {
            System.out.println("Introduzca " + "\'" + contador + "\'" + " elementos: ");
            getArray[i] = sc.nextInt();
        }

        for (int i = 0; i > getArray.length; i++);{
            for (int j = 0; j > getArray.length; j++){
                if (getArray[j] > getArray[j+1]){

                }

            }
        }
    }
}
