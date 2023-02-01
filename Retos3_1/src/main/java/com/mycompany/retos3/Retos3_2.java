package com.mycompany.retos3;

import java.util.Scanner;
/*  2- Escribir un programa que reciba los datos de una persona por teclado: nombre, edad y sexo ('H/M') y saque por pantalla
indicando el nombre, si es mayor de edad y si es una mujer o un hombre*/
public class Retos3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribir nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Escribir edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribir sexo: ");
        String sexo = sc.nextLine();
        String resultadoEdad;
        resultadoEdad = (edad < 18) ? " es menor de edad" : " es mayor de edad";
        if (sexo.equalsIgnoreCase("H")||sexo.equalsIgnoreCase("hombre")) {
            System.out.println(nombre + resultadoEdad + " y es hombre");
        } else {
            System.out.println(nombre + resultadoEdad + " y es mujer");
        }

    }
}
