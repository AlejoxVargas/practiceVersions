package com.mycompany.tema1;

/* Escribir un programa en Java que pida dos números decimales y calcule su suma, resta, multiplicación y división. Visualizar resultados.
Además pide un entero y calcula la multiplicación y división con el primer decimal. Visualizar resultados*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class RETO1_2 {
    public static void main(String[] args) {
        Scanner my_scanner = new Scanner (System.in);
        DecimalFormat formateador = new DecimalFormat ("####.##");
        double a, b; 
        int c;
        System.out.println("Introducir Primer Numero:");
        a = my_scanner.nextDouble();
        my_scanner.nextLine();
        System.out.println("Introducir Segundo Numero:");
        b = my_scanner.nextDouble();
        System.out.println("Introducir Numero Entero:");
        c = my_scanner.nextInt();
        
        System.out.println(a + " + " + b + " = " + formateador.format(a+b));
        System.out.println(a + " - " + b + " = " + formateador.format(a-b));
        System.out.println(a + " × " + b + " = " + formateador.format(a*b));
        System.out.println(a + " ÷ " + b + " = " + formateador.format(a/b));
        System.out.println(a + " × " + b + " = " + formateador.format(c*a));
        System.out.println(a + " ÷ " + b + " = " + formateador.format(c/a));    
        
    }
}
