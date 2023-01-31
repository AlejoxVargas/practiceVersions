package com.mycompany.retos1_2;

/*
Reto 1.2.3
Escribir un programa Java que declare una variable entera x con valor 3 y una double y con valor 5.0. 
Calcule la expresión z = 200 * y + x e imprima el resultado como double, como entero y como byte sin almacenar el resultado en una variable
*/

public class Reto1_2_3 {
    public static void main(String[] args) {
        int x= 3;
        double y = 5.0, z;
        z = 200*y+x;
        System.out.println("Double: " + (double)z);
        System.out.println("Entero: " + (int)z);
        System.out.println("Byte: " + (byte)z);     
        
    }
}
