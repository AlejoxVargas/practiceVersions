package com.mycompany.retos3;

/*
1.- Escribir un programa que determine si un número introducido por teclado es par o impar. Hacer 
una segunda versión comprobando además si es negativo o positivo.
*/
import java.util.Scanner;

public class Retos3_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introducir numero: ");
        int numero = sc.nextInt();
        if (numero % 2 != 0) {
            System.out.print("Numero " + numero + " es impar");
        } else {
            System.out.print("Numero " + numero + " es par");
            
        }
            if (numero < 0 ){
                System.out.println(" y es un numero negativo");
            } else {
                System.out.println(" y es un numero positivo");
            }
    }
}
