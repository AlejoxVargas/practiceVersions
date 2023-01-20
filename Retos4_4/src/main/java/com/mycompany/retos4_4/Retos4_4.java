package com.mycompany.retos4_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Retos4_4 {

    public static Scanner sc = new Scanner(System.in);
    public static Random rnd = new Random();

    public static void main(String[] args) {
        final int CANTIDAD_NUMEROS = 6;
        int[] ganadora = new int[CANTIDAD_NUMEROS];
        int[] miPrimitiva = new int[CANTIDAD_NUMEROS];

        inicializarArrayAleatorio(ganadora);
        inicializarArrayUsuario(miPrimitiva);

        System.out.println("La combinación ganadora es  : " + Arrays.toString(ganadora));
        System.out.println("Tu apuesta es : " + Arrays.toString(miPrimitiva));
        System.out.println("Has tenido " + comprobarAciertos(ganadora, miPrimitiva) + " acierto(s)");
    }

    //metodos 
    static void inicializarArrayAleatorio(int[] vector) {
        boolean descartado;
        for (int i = 0; i < vector.length; i++) {
            do {
                int numeroRandom = rnd.nextInt(50);
                descartado = false;
                for (int numVector : vector) {
                    if (numVector == numeroRandom) {
                        descartado = true;
                        break;
                    }
                }
                if (!descartado) {
                    vector[i] = numeroRandom;
                }
            } while (descartado);
        }
    }

    static void inicializarArrayUsuario(int[] vector) {
        int count = 1;
        boolean llave;
        for (int i = 0; i < vector.length; i++) {
            do {
                System.out.println("Ingrese " + count + " miPrimitiva: ");
                int numero = sc.nextInt();
                llave = false;
                if (numero < 1 || numero > 49) {
                    System.out.println("Numero fuera del rango 1-49, intentelo de nuevo");
                    llave = true;
                }
                for (int numVector : vector) {
                    if (numVector == numero) {
                        System.out.println("Número ya se encuentra");
                        llave = true;
                    }
                }
                if (!llave) {
                    vector[i] = numero;
                }
            } while (llave);
            count++;
        }
    }

    static int comprobarAciertos(int[] vector1, int[] vector2) {
        int aciertos = 0;
        for (int i = 0; i < vector1.length; i++) {
            for (int j = 0; j < vector2.length; j++) {
                if (vector1[i] == vector2[j]){
                aciertos ++;
                }
            }
        }
        return aciertos;
    }
}
