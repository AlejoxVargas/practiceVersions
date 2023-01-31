package com.mycompany.retos3_2;

import java.util.Scanner;

/*5. Escribir un método que reciba tres números y los ordene.*/

public class Retos3_2_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese primer numero: ");
        int n1 = sc.nextInt();
        System.out.println("Ingrese segundo numero: ");
        int n2 = sc.nextInt();
        System.out.println("Ingrese tercer numero: ");
        int n3 = sc.nextInt();
        Retos3_2_5.ordenCreciente(n1, n2, n3);
    }

    static void ordenCreciente(int n1, int n2, int n3) {
        if (n1 > n2 && n2 > n3) {
            System.out.println("Orden de menor a mayor: " + n3 + n2 + n1);
        } else if (n1 > n3 && n3 > n2) {
            System.out.println("Orden de menor a mayor: " + n2 + n3 + n1);
        } else if (n2 > n1 && n1 > n3) {
            System.out.println("Orden de menor a mayor: " + n3 + n1 + n2);
        } else if (n2 > n3 && n3 > n1) {
            System.out.println("Orden de menor a mayor: " + n1 + n3 + n2);
        } else if (n3 > n1 && n1 > n2) {
            System.out.println("Orden de menor a mayor: " + n2 + n1 + n3);
        } else if (n3 > n2 && n2 > n1) {
            System.out.println("Orden de menor a mayor: " + n1 + n2 + n3);
        }
    }
}
