package MatricesUnidimensionales;

import java.util.Scanner;

/*Ejercicio 1:

Versión 2: Escribir un método estaPresente() al que se le pase como argumento el array números y un entero y devuelva si el entero se encuentra en el array.
Opcional: parar la búsqueda en cuanto se ha encontrado el número.*/
public class Ejercicio1_V2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] getArray = {12, 15, 13, 10, 8, 9, 13, 14};
        System.out.println("Enter a number in the array: ");
        int getNumber = sc.nextInt();
        
        estaPresente(getArray, getNumber);
    }

    static boolean estaPresente(int[] getArray, int getNumber) {
        boolean llave = false;
        System.out.println("\tInicio del recorrido");

        for (int i = 0; i < getArray.length; i++) {
            System.out.println("Recorrido: " + getArray[i]);
            //llave = getArray[i] == getNumber;
            //Hace el recorrido y paro igual que en la versión 1
            if (getArray[i] == getNumber) {
                llave = true;
                break;
            }
        }
        System.out.println("\tParo del recorrido");

        if (llave == true) {
            System.out.println("Result: The number was found.");
        } else {
            System.out.println("Result: The number wasn't found.");
        }
        return llave;
    }
}
