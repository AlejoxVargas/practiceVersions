package Estructuras;

import java.util.Scanner;

public class Estructuras {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Estructuras.requestExercise();
    }

    //Realizar cada ejercicio (del 2 al 8) mediante un método que será llamado desde el main. Se pedirá al usuario qué ejercicio ejecutar hasta que teclee un cero.
    public static void requestExercise() {
        System.out.println("Escriba ejercicio a ejecutar: ");
        int character = sc.nextInt();
        while (character != 0) {
            switch (character) {
                case 2 ->
                    Estructuras.baseXExponent();
                case 3 ->
                    Estructuras.multiplicationTables();
                case 4 ->
                    Estructuras.squareN();
                case 5 ->
                    Estructuras.counterClock();
                case 6 ->
                    Estructuras.primeNumber();
                case 7 ->
                    Estructuras.searchNumber();
                case 8 ->
                    Estructuras.Table();
            }
            System.out.println("\nEscriba otro ejercicio a ejecutar: ");
            character = sc.nextInt();
        }
        System.out.println("Proceso Final Acabado");
    }

    //2-Dadas una base y un exponente entero, calcular la potencia con un for y con un while.
    public static void baseXExponent() {
        System.out.println("Escriba la base: ");
        int base = sc.nextInt(), resultado = 1, i;
        System.out.println("Escriba exponente: ");
        int exponent = sc.nextInt();
        for (i = 1; i <= exponent; i++) {
            resultado *= base;
        }
        System.out.println("for:\nLa potencia de " + base + "^" + exponent + " es " + resultado);

        while (i <= exponent) {
            resultado *= base;
            i++;
        }
        System.out.println("while:\nLa potencia de " + base + "^" + exponent + " es " + resultado);
    }

    //3-Diseña una aplicación que muestre las tablas de multiplicar del 1 al 10.
    public static void multiplicationTables() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nTabla del " + i);
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + "x" + j + " = " + i * j);
            }
        }
    }

    //4-Escribir un programa que pida al usuario un número n y dibuje un cuadrado de n elementos de lado utilizando *.
    public static void squareN() {
        System.out.println("Escriba un numero de '*': ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(" ");
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
        }
        System.out.println("\nEscribir una segunda versión donde el cuadrado esté hueco");

        //Escribir una segunda versión donde el cuadrado esté hueco
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 0; i < n - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < n - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }

    /*5-Escribir un programa que muestre un contador con 5 dígitos (X-X-X-X-X), desde 0-0-0-0-0 hasta 9-9-9-9-9, 
    con la particularidad que cada vez que aparezca un 3 lo sustituya por una E.*/
    public static void counterClock() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    for (int l = 0; l <= 9; l++) {
                        for (int m = 0; m <= 9; m++) {
                            System.out.println(String.valueOf(i + "-" + j + "-" + k + "-" + l + "-" + m).replaceAll("3", "E"));
                        }
                    }
                }
            }

        }
    }

    //6-Realizar un programa que nos pida un número n, y nos diga cuántos números hay entre 1 y n que son primos
    public static void primeNumber() {
        System.out.println("Escriba un numero n: ");
        int n = sc.nextInt();

        if (n != 0 && n != 1) {
            for (int i = 2; i <= n; i++) {
                int count = 0;
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                }
                if (count == 2) {
                    System.out.println(i);
                }
            }

        } else {
            System.out.println("No hay numeros primos entre 0 o 1");
        }
    }

//7-Buscar (con un bucle) un número que sea divisible por 2, 5 y 11 simultáneamente.
    public static void searchNumber() {
        for (int i = 1; i <= 150; i++) {
            if (i % 2 == 0 && i % 5 == 0 && i % 11 == 0) {
                System.out.println("Numero divisible: " + i);
            }
        }
    }

    /* 8. Hacer un programa que, aplicando la lógica y utilizando las sentencias "for" e "if" que se consideren necesarias 
imprima una tabla de multiplicar que debe cumplir los siguientes requisitos:
El operando de las filas de la tabla va del 3 al 11.
El operando de las columnas va del 1 al 10
No se deben imprimir las filas pares.
Cuando el producto a imprimir sea mayor que 80, se mostrará rodeado de un paréntesis.
El resultado deberá ser similar al que aparece en la imagen, incluyendo la separación entre los datos.
     */
    public static void Table() {
        for (int i = 1; i <= 10; i++) {
            System.out.print("    " + i);
        }
        System.out.println();
        System.out.println("--------------------------------------------------------");

        for (int i = 3; i <= 11; i += 2) {
            System.out.print(i);
            for (int j = 1; j <= 10; j++) {
                if (i * j < 80) {
                    System.out.printf("   " + i * j);
                }
                if (i * j >= 80) {
                    System.out.printf("  (" + i * j + ")");
                }
            }
            System.out.println();
        }

    }
}
