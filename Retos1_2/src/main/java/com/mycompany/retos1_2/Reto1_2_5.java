package com.mycompany.retos1_2;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
Escribir un programa que pida al usuario su nombre, su peso en kg y su estatura en centímetros y calcule su índice de masa corporal.
IMC= peso/altura2
Visualizar un mensaje que le diga al usuario cual es su IMC con 3 decimales
*/
public class Reto1_2_5 {
    public static void main(String[] args) {
    DecimalFormat formateador = new DecimalFormat("####.###");
    Scanner sc = new Scanner (System.in); 
    String nombre;
    double peso;
    double estatura;
    System.out.println("Escriba su nombre: ");
    nombre = sc.nextLine();
    System.out.println("Escriba su peso: ");
    peso = sc.nextDouble();
    System.out.println("Escriba su estatura: ");
    estatura = sc.nextDouble();
    double imc = peso/(Math.pow(estatura, 2)) /*imc = peso/cuadrado*/;
    System.out.println("Sr/Sra " + nombre + " su IMC es: " + formateador.format(imc));
    }

    
}
