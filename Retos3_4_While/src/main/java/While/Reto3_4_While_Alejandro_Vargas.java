package While;

import java.util.Scanner;

public class Reto3_4_While_Alejandro_Vargas {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Reto3_4_While_Alejandro_Vargas.requestExercise();
    }

    //Pedir al usuario el nº de ejercicio que desea ejecutar hasta que introduzca el carácter del punto "."
    public static void requestExercise() {
        System.out.println("Escriba Ejercicio a ejecutar: ");
        String caracter = sc.nextLine();
        while (!".".equals(caracter)) {
            switch (caracter) {
                case "1" ->
                    Reto3_4_While_Alejandro_Vargas.numCuadrado();
                case "2" ->
                    Reto3_4_While_Alejandro_Vargas.numReal();
                case "3" ->
                    Reto3_4_While_Alejandro_Vargas.numerosPares();
                case "4" ->
                    Reto3_4_While_Alejandro_Vargas.numCount();
                case "5" ->
                    Reto3_4_While_Alejandro_Vargas.totalSumNumber();
                case "6" ->
                    Reto3_4_While_Alejandro_Vargas.averageNumber();
                case "7" ->
                    Reto3_4_While_Alejandro_Vargas.showNumber1ToN();
                case "8" ->
                    Reto3_4_While_Alejandro_Vargas.number100to7();
            }
            System.out.println("Escriba otro ejercicio a ejecutar: ");
            caracter = sc.nextLine();
        }
        System.out.println("Proceso Final Acabado");
    }

    //1. Leer un número y mostrar su cuadrado, repetir el proceso hasta que se introduzca un número negativo.  
    public static void numCuadrado() {
        System.out.println("1. Leer un número y mostrar su cuadrado, repetir el proceso hasta que se introduzca un número negativo.\n");
        System.out.println("Escriba un numero: ");
        int numeroCuadrado = sc.nextInt();
        while (numeroCuadrado >= 0) {
            System.out.println(Math.pow(numeroCuadrado, 2));
            System.out.println("Escriba un numero: ");
            numeroCuadrado = sc.nextInt();
        }
        System.out.println("The end");
        sc.nextLine();
    }

    //2. Leer un número e indicar si es positivo o negativo. El proceso se repetirá hasta que se introduzca un 0.
    public static void numReal() {
        System.out.println("2. Leer un número e indicar si es positivo o negativo. El proceso se repetirá hasta que se introduzca un 0.\n");
        System.out.println("Escriba un numero positivo o negativo: ");
        int numeroReal = sc.nextInt();
        while (numeroReal != 0) {
            if (numeroReal >= 1) {
                System.out.println("Positivo");

            } else {
                System.out.println("Negativo");
            }
            System.out.println("Escribir numero: ");
            numeroReal = sc.nextInt();
        }
        System.out.println("The end ");
        sc.nextLine();
    }

    //3. Leer números hasta que se introduzca un 0. Para cada uno indicar si es par o impar.
    public static void numerosPares() {
        System.out.println("3. Leer números hasta que se introduzca un 0. Para cada uno indicar si es par o impar.\n");
        System.out.println("Escriba numero par o impar: ");
        int respuestaResultante = sc.nextInt();
        while (respuestaResultante != 0) {
            if (respuestaResultante % 2 == 0) {
                System.out.println("es par");
            } else {
                System.out.println("es impar");
            }
            System.out.println("Escriba numero par o impar: ");
            respuestaResultante = sc.nextInt();
        }
        System.out.println("The end");
        sc.nextLine();
    }

    //4. Pedir números hasta que se teclee uno negativo, y mostrar cuántos números se han introducido.
    public static void numCount() {
        int sumCount = 0;
        System.out.println("4. Pedir números hasta que se teclee uno negativo, y mostrar cuántos números se han introducido.\n");
        System.out.println("Escriba un numero: ");
        int numRequested = sc.nextInt();
        while (numRequested > -1) {
            System.out.println("Escriba un numero: ");
            numRequested = sc.nextInt();
            sumCount++;
        }
        System.out.println("Numeros totales introducidos: " + sumCount);
        sc.nextLine();
    }

    //5. Pedir números hasta que se teclee un 0, mostrar la suma de todos los números introducidos.
    public static void totalSumNumber() {
        int suma = 0, num;
        System.out.println("5. Pedir números hasta que se teclee un 0, mostrar la suma de todos los números introducidos.\n");
        System.out.println("Escriba un numero para sumar: ");
        num = sc.nextInt();
        while (num != 0) {
            suma += num;
            System.out.println("Escribir otro numero a sumar: ");
            num = sc.nextInt();
        }
        System.out.println("Total suma: " + suma);
        sc.nextLine();
    }

    //6. Pedir números hasta que se introduzca uno negativo, y calcular la media.
    public static void averageNumber() {
        int totalCount = 0, sumaCount = 0;
        System.out.println("6. Pedir números hasta que se introduzca uno negativo, y calcular la media.\n");
        System.out.println("Escriba un numero para calcular media: ");
        int numberAverage = sc.nextInt();
        while (numberAverage > 0) {
            totalCount += numberAverage;
            System.out.println("Escribir otro numero: ");
            numberAverage = sc.nextInt();
            sumaCount++;
        }
        System.out.println("Media de todos los numeros introducidos: " + totalCount / sumaCount);
        sc.nextLine();
    }

    //7. Pedir un número N, y mostrar todos los números del 1 al N.
    public static void showNumber1ToN() {
        System.out.println("7. Pedir un número N, y mostrar todos los números del 1 al N.\n");
        System.out.println("Escriba numero para mostrar sucecion: ");
        int sucessionNumber = sc.nextInt(), countSucession = 1;
        while (countSucession <= sucessionNumber) {
            System.out.println(countSucession++);
        }
        sc.nextLine();
    }

    //8. Escribir todos los números del 100 al 0 de 7 en 7.
    public static void number100to7() {
        System.out.println("8. Escribir todos los números del 100 al 0 de 7 en 7.");
        int number100 = 100;
        while (number100 >= 0) {
            System.out.println(number100);
            number100 -= 7;
        }
    }
}
