package defaultPack;

import java.util.Scanner;

/**
 *
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
            arrange = getArray[0];
            
            if (getArray[i] < arrange) {
                arrange = getArray[i];
            } else if (getArray[i] > arrange) {
                arrange = arrange;
            }
        }
        System.out.println();
        for (int i = 0; i < getArray.length; i++) {
            System.out.println(getArray[i]);
        }
    }

}
