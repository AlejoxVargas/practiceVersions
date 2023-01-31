package com.mycompany.tema1;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
Escriba un programa que convierta pesetas a euros. El índice de conversión es 1€= 166,386 pesetas).
Visualizar resultado.
*/
public class RETO1_3 {
    public static void main(String[] args) {
        Scanner my_scanner = new Scanner (System.in);
        DecimalFormat formato = new DecimalFormat ("####.0000");
        double pesetas, resultado;
        System.out.println("Escriba la cantidad de pesetas: ");
        pesetas = my_scanner.nextDouble();
        resultado = pesetas/166.386;
        System.out.println("La cantidad en euros es: " + formato.format(resultado)+" €");
    }
}
