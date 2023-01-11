package MatricesUnidimensionales;

import java.util.Scanner;

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
        for (int i = 0; i < getArray.length; i++) {
            //llave = getArray[i] == getNumber;
            if (getArray[i] == getNumber) {
                llave = true;
            }
        }
        if (!llave) {
            System.out.println("The number was found.");
        } else {
            System.out.println("The number wasn't found.");
        }
        return llave;
    }
}
