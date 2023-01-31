package com.mycompany.retos1_2;

import java.util.Scanner;

/*
Reto 1.2.4
Escribir el ejercicio 3 pidiendo al usuario los datos.
*/

public class Reto1_2_4 {
    public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
        int x;
        double y, z;
        System.out.println("Ingrese x: ");
        x = sc.nextInt();
        System.out.println("Ingrese y: ");
        y = sc.nextDouble();
        z = 200*y+x;
        System.out.println("Double: " + (double)z);
        System.out.println("Entero: " + (int)z );
        System.out.println("Byte: " + (byte)z);
    }
}
