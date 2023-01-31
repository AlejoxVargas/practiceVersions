package com.mycompany.retos3_2;

import java.util.Scanner;

/*3.- Escribir un método que reciba un número entre 0 y 999 y le dé la vuelta. Por ejemplo 123 se convertiría en 321.
 */
public class Retos3_2_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entre 0 y 999: ");
        int numeroRotar = sc.nextInt();

        System.out.println(Retos3_2_3.cambiarNumero(numeroRotar));
    }

    public static String cambiarNumero(int numeroRotar) {
        String resultado;
        resultado = null;
        if (numeroRotar < 10) {
            resultado = String.valueOf(numeroRotar);
        }
        else if (numeroRotar >= 10 && numeroRotar <= 999) {
            resultado = String.valueOf(numeroRotar % 10) + cambiarNumero(numeroRotar / 10);
        } else {
            System.out.println("Numero Incorrecto");
        }
        return resultado;
    }
}
