package com.mycompany.retos1_2;

/*Reto 1.2.2
Escribir un programa Java que declare una variable entera x con valor 3 y una double y con valor 5.0. 
Calcule la expresión 200 * y + x . Asígnela a una variable de tipo double, a otra de tipo float, a otra de tipo entero. Imprimir estas variables.
*/

public class Reto1_2_2 {
    public static void main(String[] args) {
    int x = 3, entero1;
    double y = 5.0, double1, resultado;
    float float1;
    resultado = 200*y+x;
    double1 = resultado;
    entero1 = (int) resultado;
    float1= (float )resultado;
        System.out.println("Resultado: "+ resultado);
        System.out.println("Double: " + double1);
        System.out.println("Float: " + float1);
        System.out.println("Entero: " + entero1);
    }
}
