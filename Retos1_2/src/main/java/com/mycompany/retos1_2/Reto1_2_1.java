package com.mycompany.retos1_2;

import java.text.DecimalFormat;
import java.util.Scanner;
/*
Reto 1.2.1
Programa que declara tres variables numéricas a, b y c y s una cadena de caracteres. 
Pida los datos al usuario e imprima los valores de todas las variables con 2 decimales:
en una sola línea
en varias líneas con varias instrucciones println
en varias líneas con una sola instrucción println
*/
public class Reto1_2_1 {

    public static void main(String[] args) {
        double a,b,c;
        String s;
        Scanner sc = new Scanner (System.in);
        DecimalFormat Formateador = new DecimalFormat("##.##");
        System.out.println("Escriba Caracter: ");
        s = sc.nextLine();
        System.out.println("Ingrese primer valor: ");
        a = sc.nextDouble();
        System.out.println("Ingrese segundo valor: ");
        b = sc.nextDouble();
        System.out.println("Ingrese tercer valor: ");
        c = sc.nextDouble();
        
        System.out.println("Los valores de todas las variables: " + s + " " + Formateador.format(a) + " " + Formateador.format(b)+ " " + Formateador.format(c));
        System.out.println("Los valores de todas las variables");
        System.out.println(s);
        System.out.println(Formateador.format(a));
        System.out.println(Formateador.format(b));
        System.out.println(Formateador.format(c));
        System.out.println("Los valores de todas las variables:\n" + s + "\n" +  Formateador.format(a) +"\n" + Formateador.format(b)+"\n" + Formateador.format(c) );
    }
}
