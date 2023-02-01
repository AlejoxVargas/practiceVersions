package defaultPack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Alejandro Vargas
 */

/*2. Realizar un programa que genere 20 números enteros aleatorios entre 100 y 199 y los almacene en un array,
 * no deberá haber números repetidos. El programa debe crear un nuevo array con los números primos que haya entre esos 20 números.
 * Luego debe mostrar los dos arrays.
 */
public class Ejercicio2 {

    public static Scanner sc = new Scanner(System.in);
    public static Random rnd = new Random();

    public static void main(String[] args) {

        final int CANTIDAD_NUMEROS = 20;

        int[] vectorAleatorio = new int[CANTIDAD_NUMEROS];
        int[] primosAleatorio = new int[CANTIDAD_NUMEROS];

        ArrayAleatorio(vectorAleatorio);
        primeNumber(vectorAleatorio, primosAleatorio);

        System.out.println(Arrays.toString(vectorAleatorio));
        System.out.println(Arrays.toString(primosAleatorio));
    }

    public static int[] ArrayAleatorio(int[] vector) {
        boolean descartado;
        int min_value = 100, max_value = 199;
        for (int i = 0; i < vector.length; i++) {
            do {
                int numeroRandom = min_value + rnd.nextInt(max_value - min_value);
                descartado = false;
                for (int numVector : vector) {
                    if (numVector == numeroRandom) {
                        descartado = true;
                        break;
                    }
                }
                if (!descartado) {
                    vector[i] = numeroRandom;
                }
            } while (descartado);
        }
        return vector;
    }

    public static void primeNumber(int[] vector, int[] vector2) {
        for (int k : vector) {
            if (k != 0 && k != 1) {
                for (int i = 0; i < vector.length; i++) {
                    int count = 0;
                    for (int j = 1; j <= vector[i]; j++) {
                        if (vector[i] % j == 0) {
                            count++;
                        }
                    }
                    if (count == 2) {
                        vector2[i] = vector[i];
                    }
                }
            }
        }
    }
}
