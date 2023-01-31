package com.mycompany.retos3_2;

import java.util.Scanner;

public class Retos3_2_1 {

    /*1.- Escribir un método que determine si un número introducido por teclado es múltiplo de 2, de 3 y/o de 5.*/
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribir numero: ");
        int numero = sc.nextInt();
        System.out.println(Retos3_2_1.multiplos(numero));
    }

    static String multiplos(int numero) {
        String mensajemultiplos = "";
        if (numero % 2 == 0) {
            mensajemultiplos += "multiplo de 2";
        }
        if (numero % 3 == 0) {
            mensajemultiplos += " multiplo de 3";
        }
        if (numero % 5 == 0) {
            mensajemultiplos += " multiplo de 5";
        } else if (numero % 2 > 0.1) {
            mensajemultiplos += "no es multiplo de ninguno";
        }
        return mensajemultiplos;
    }

}
