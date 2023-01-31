package com.mycompany.tema1;

/*
Escribir un programa en java que pida un número de horas y calcule cuantos
días y horas hay en ellas.
*/

import java.util.Scanner;

public class RETO1_1 {

    public static void main(String[] args) {
        Scanner my_scanner = new Scanner(System.in);
        int horas;
        System.out.println("Introducir numero de horas:");
        horas = my_scanner.nextInt();
        int dia = horas/24;
        //System.out.println(" Hay " + dia + " días " + " Resto= " + dia%dia );
        System.out.println(" Hay " + dia + " días " + " y " +horas%24 + " Horas " );

    }
}
