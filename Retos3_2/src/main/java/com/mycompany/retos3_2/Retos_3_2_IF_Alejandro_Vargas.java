package com.mycompany.retos3_2;

import java.util.Scanner;

public class Retos_3_2_IF_Alejandro_Vargas {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Retos_3_2_IF_Alejandro_Vargas.requestExercise();
    }

    /*No se pedían las llamadas desde el main en estos ejercicios, pero por eficacia y rapidez, lo he añadido, 
    se puede elegir el ejercicio a usar tecleando el número de ejercicio, y si se pulsa 0 este terminará su ejecución.*/
    public static void requestExercise() {
        System.out.println("Escriba ejercicio a ejecutar: ");
        int caracter = sc.nextInt();
        while (caracter != 0) {
            switch (caracter) {
                case 1 -> {
                    System.out.println("1.- Escribir un método que determine si un número introducido por teclado es múltiplo de 2, de 3 y/o de 5.\n");
                    System.out.println("Escribir numero: ");
                    int numero = sc.nextInt();
                    System.out.println(Retos_3_2_IF_Alejandro_Vargas.multiplos(numero));
                }
                case 2 -> {
                    System.out.println("2.- Escribir un método que reciba un número por pantalla entre 0 y 999 y diga cuantas cifras tiene.\n");
                    System.out.println("Escriba un numero entre 0 y 999: ");
                    int numeroContable = sc.nextInt();
                    Retos_3_2_IF_Alejandro_Vargas.cifras(numeroContable);
                }
                case 3 -> {
                    System.out.println(".- Escribir un método que reciba un número entre 0 y 999 y le dé la vuelta. Por ejemplo 123 se convertiría en 321.\n");
                    System.out.println("Ingrese un numero entre 0 y 999: ");
                    int numeroRotar = sc.nextInt();
                    System.out.println(Retos_3_2_IF_Alejandro_Vargas.cambiarNumero(numeroRotar));
                }
                case 4 -> {
                    System.out.println("4. Escribir un método que reciba una hora, unos minutos y unos segundos; y devuelva el resultado de sumarle un segundo.\n");
                    System.out.println("hora: ");
                    int hora = sc.nextInt();
                    System.out.println("minutos: ");
                    int minutos = sc.nextInt();
                    System.out.println("segundos: ");
                    int segundos = sc.nextInt();
                    Retos_3_2_IF_Alejandro_Vargas.sumarSegundo(hora, minutos, segundos);
                }
                case 5 -> {
                    System.out.println("5. Escribir un método que reciba tres números y los ordene.\n");
                    System.out.println("Ingrese primer numero: ");
                    int n1 = sc.nextInt();
                    System.out.println("Ingrese segundo numero: ");
                    int n2 = sc.nextInt();
                    System.out.println("Ingrese tercer numero: ");
                    int n3 = sc.nextInt();
                    Retos_3_2_IF_Alejandro_Vargas.ordenCreciente(n1, n2, n3);
                }
            }
            System.out.println("\nEscriba otro ejercicio a ejecutar:");
            caracter = sc.nextInt();
        }
        System.out.println("Proceso Acabado");
    }

    /*1.- Escribir un método que determine si un número introducido por teclado es múltiplo de 2, de 3 y/o de 5.*/
    static String multiplos(int numero) {
        String mensajemultiplos = "";
        if (numero % 2 == 0) {
            mensajemultiplos += "multiplo de 2";
        }
        if (numero % 3 == 0) {
            mensajemultiplos += " multiplo de 3";
        }
        if (numero % 5 == 0) {
            mensajemultiplos += " multiplo de 5";
        } else if (numero % 2 > 0.1) {
            mensajemultiplos += "no es multiplo de ninguno";
        }
        return mensajemultiplos;
    }

    /*2.- Escribir un método que reciba un número por pantalla entre 0 y 999 y diga cuantas cifras tiene.*/
    public static void cifras(int numeroConta) {
        String cadena;
        if (numeroConta > 0 && numeroConta < 999) {
            cadena = Integer.toString(numeroConta);
            System.out.println("Numero " + numeroConta + " tiene " + cadena.length() + " cifras");
        } else {
            System.out.println("incorrecto");
        }
    }

    /*3.- Escribir un método que reciba un número entre 0 y 999 y le dé la vuelta. Por ejemplo 123 se convertiría en 321.*/
    public static String cambiarNumero(int numeroRotar) {
        String resultado = "";
        if (numeroRotar < 10) {
            resultado = String.valueOf(numeroRotar);
        } else if (numeroRotar >= 10 && numeroRotar <= 999) {
            resultado = String.valueOf(numeroRotar % 10) + cambiarNumero(numeroRotar / 10);
        } else {
            System.out.println("Numero Incorrecto");
        }
        return resultado;
    }

    /*4. Escribir un método que reciba una hora, unos minutos y unos segundos; y devuelva el resultado de sumarle un segundo.*/
    public static void sumarSegundo(int hora, int minutos, int segundos) {
        if (segundos >= 0 && segundos < 59) {
            segundos++;

        } else if (segundos >= 59) {
            segundos = 0;
            minutos = 0;
            hora++;
        }

        if (hora > 23) {
            hora = 0;
        }
        System.out.println("resultado: " + hora + " " + minutos + " " + segundos);
    }

    /*5. Escribir un método que reciba tres números y los ordene.*/
    static void ordenCreciente(int n1, int n2, int n3) {
        if (n1 > n2 && n2 > n3) {
            System.out.println("Orden de menor a mayor: " + n3 + n2 + n1);
        } else if (n1 > n3 && n3 > n2) {
            System.out.println("Orden de menor a mayor: " + n2 + n3 + n1);
        } else if (n2 > n1 && n1 > n3) {
            System.out.println("Orden de menor a mayor: " + n3 + n1 + n2);
        } else if (n2 > n3 && n3 > n1) {
            System.out.println("Orden de menor a mayor: " + n1 + n3 + n2);
        } else if (n3 > n1 && n1 > n2) {
            System.out.println("Orden de menor a mayor: " + n2 + n1 + n3);
        } else if (n3 > n2 && n2 > n1) {
            System.out.println("Orden de menor a mayor: " + n1 + n2 + n3);
        }
    }
}
