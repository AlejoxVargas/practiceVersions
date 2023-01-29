package defaultPack;
/*1. Escribir un programa Java que pida por teclado el número de elementos que se van a introducir y posteriormente vaya pidiendo el
valor de esos números enteros, los almacene en un array, los ordene y los muestre por pantalla.*/
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

        for (int i = 0; i < getArray.length - 1; i++){
            for (int j = 0; j < getArray.length - 1; j++) {
                if (getArray[j] > getArray[j + 1]) {
                    arrange = getArray[j];
                    getArray[j] = getArray[j + 1];
                    getArray[j + 1] = arrange;
                }
            }
        }
        System.out.println("Orden creciente: ");
        for (int i = 0; i < getArray.length; i++) {
            System.out.print("[" + getArray[i]+ "]");
        }
    }
}
