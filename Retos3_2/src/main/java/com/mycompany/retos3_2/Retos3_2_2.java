package com.mycompany.retos3_2;

import java.util.Scanner;

/*2.- Escribir un método que reciba un número por pantalla entre 0 y 999 y diga cuantas cifras tiene.*/
public class Retos3_2_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba un numero entre 0 y 999: ");
        int numeroContable = sc.nextInt();

        Retos3_2_2.cifras(numeroContable);
    }

    public static void cifras(int numeroConta) {
        String cadena;

        if (numeroConta > 0 && numeroConta < 999) {
            cadena = Integer.toString(numeroConta);
            System.out.println("Numero " + numeroConta + " tiene " + cadena.length() + " cifras");
        } else {
            System.out.println("incorrecto");
        }
    }

}
