package com.mycompany.retos4_7;

import java.util.ArrayList;
import java.util.Scanner;

/*
1. Realizar un programa Java que lea una serie de valores numéricos enteros desde el teclado y los guarde en un ArrayList de tipo Integer. 
La lectura de números enteros termina cuando se introduzca el valor 0. Este valor no se guarda en el ArrayList. 
A continuación el programa mostrará por pantalla el número de valores que se han leído, el mayor, el menor, su suma y su media. 
Se mostrarán todos los valores leídos, indicando cuántos de ellos son mayores que la media.
 */
public class Ejercicio1 {

    static ArrayList<Integer> valNumeric = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        do {
            System.out.println("Introduce numero: ");
            numero = sc.nextInt();
            if (numero != 0) {
                valNumeric.add(numero);
            }
        } while (numero != 0);

        System.out.println("Valores introducidos: " + valNumeric.size());
        System.out.println("El valor máximo es: " + MaxVal(valNumeric));
        System.out.println("El valor mínimo es: " + MinVal(valNumeric));
        System.out.println("Suma total: " + TotalVal(valNumeric));
        System.out.println("Media: " + meanValue(valNumeric));
        System.out.println(valNumeric.toString());
        System.out.println("Mayores de media: " + UpToAverage(valNumeric));
    }

    public static int MaxVal(ArrayList<Integer> numeros) {
        int maxValue = numeros.get(0);
        for (int iterador : numeros) {
            if (maxValue < iterador) {
                maxValue = iterador;
            }
        }
        return maxValue;
    }

    public static int MinVal(ArrayList<Integer> numeros) {
        int minValue = numeros.get(0);
        for (int iterador : numeros) {
            if (minValue > iterador) {
                minValue = iterador;
            }
        }
        return minValue;
    }

    public static int TotalVal(ArrayList<Integer> numeros) {
        int suma = 0;
        for (int iterador : numeros) {
            suma += iterador;
        }
        return suma;
    }

    public static int meanValue(ArrayList<Integer> numeros) {
        int meanValue;
        meanValue = TotalVal(valNumeric) / numeros.size();       
        return meanValue;
    }

    public static int UpToAverage(ArrayList<Integer> numeros) {
        int upToAverage = 0;
        for (int iterador : numeros) {
            if (iterador > meanValue(valNumeric)) {
               upToAverage++;
            }
        }
        return upToAverage;
    }
}
