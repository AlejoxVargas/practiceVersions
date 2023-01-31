package Reto2_2_4;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
4- Escribir una clase estática Impresion que contenga los métodos:

imprimir2Decimales
imprimir4Decimales
 */
public class Reto2_2_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cadenaDecimal;
        System.out.println("Escribir cadena: ");
        cadenaDecimal = sc.nextDouble();


        Impresion.imprimir2Decimales(cadenaDecimal);
        Impresion.imprimir4Decimales(cadenaDecimal);

    }

}

class Impresion {

    static void imprimir2Decimales(double Deci1) {
        DecimalFormat df = new DecimalFormat("##.00");
        System.out.println("Cadena con 2 decimales: " + df.format(Deci1));
    }

    static void imprimir4Decimales(double Decil2) {
        DecimalFormat df = new DecimalFormat("##.0000");
        System.out.println("Cadena con 4 decimales: " + df.format(Decil2));
    }
}
