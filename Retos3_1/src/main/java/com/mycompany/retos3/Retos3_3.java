package com.mycompany.retos3;

import java.util.Scanner;

/*
3- Escribir un programa que pida la nota de un examen (un numero real 0 y 10) e imprima por pantalla la calicación:
º "Suspendió", si la nota es menor que 5,
º "Aprobado", si esta entre 5 y 7 sin incluirlo,
º "Notable", si esta entre 7 y 9 sin incluirlo, 
º "Sobresaliente" si esta entre 9 y 10 sin incluirlo, 
º "Matricula de honor" si la nota es igual a 10. 
º "Fuera de rango" si no es ninguno de los casos anteriores
 */
public class Retos3_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba nota entre 0 - 10: ");
        double nota = sc.nextDouble();
        if (nota < 5) {
            System.out.println("Suspendió");
        } else if (nota >= 5 && nota <= 6) {
            System.out.println("Aprobado");
        } else if (nota >= 7 && nota <= 8) {
            System.out.println("Notable");
        } else if (nota == 9) {
            System.out.println("Sobresaliente");
        } else if (nota == 10) {
            System.out.println("Matricula de honor");
        } else if (nota > 10) {
            System.out.println("Fuera de rango");
        }

    }
}
