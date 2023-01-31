package proyectoSwitch;

import java.util.Scanner;

public class proyectoSwitch {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        proyectoSwitch.requestExercise();
    }

    /*No se pedían las llamadas desde el main en estos ejercicios, pero por eficacia y rapidez, lo he añadido, 
    se puede elegir el ejercicio a usar tecleando el número de ejercicio, y si se pulsa 0 este terminará su ejecución.*/
    public static void requestExercise() {
        System.out.println("Escriba ejercicio a ejecutar: ");
        int caracter = sc.nextInt();
        while (caracter != 0) {
            switch (caracter) {
                case 1 -> {
                    System.out.println("Este ejercicio ya está resuelto en la guia.");
                }
                case 2 -> {
                    System.out.println("2.- Escribir un método que reciba un número introducido por teclado entre 1 y 12 y devuelva el número de días que tiene ese mes.\n");
                    System.out.println("Digite numero de mes a conocer: ");
                    int mesEntero = sc.nextInt();
                    System.out.println("El mes: " + "\'" + mesEntero + "\'" + " tiene " + proyectoSwitch.numeroDias(mesEntero) + " dias");
                }
                case 3 -> {
                    System.out.println("3.- Escribir un método que reciba un nombre de mes introducido por teclado y devuelva el número de días que tiene ese mes.\n");
                    System.out.println("\nEscriba el mes a conocer: ");
                    sc.nextLine();
                    String mesString = sc.nextLine();
                    System.out.println("El mes: " + "\'" + mesString + "\'" + " tiene " + proyectoSwitch.numeroDiasString(mesString) + " dias");
                }
                case 4 -> {
                    System.out.println("4. Escribir un método que reciba una letra (puede ser mayúscula o minúscula) del alfabeto por teclado y devuelva si es vocal o consonante. \n"
                            + "Se considera que toda letra que no es una vocal es una consonante.\n");
                    System.out.println("\nEscriba una letra para saber si es vocal o no: ");
                    char caracterConvertir = sc.nextLine().charAt(0); //charAt sirve para pasar a char un caracter espécifico de un String
                    int codigoASCII = caracterConvertir;
                    proyectoSwitch.convertirLetra(codigoASCII);
                }
                case 5 -> {
                    System.out.println("5. Escribir un método que pida al usuario un número e indica si es par o impar (con switch case).\n");
                    System.out.println("Introducir numero: ");
                    int numeroPar = sc.nextInt();
                    proyectoSwitch.calcularPar(numeroPar);
                }
                case 6 -> {
                    System.out.println("6.- Escribir un método que pida una operación (+, -, *, /) y dos números y realice la operación indicada imprimiendo el resultado.");
                    System.out.println("Introduce un signo operando: ");
                    sc.nextLine();
                    String signo = sc.nextLine();
                    System.out.println("Introduce primer numero: ");
                    double numero1Operar = sc.nextDouble();
                    System.out.println("Introducir segundo numero: ");
                    double numero2Operar = sc.nextDouble();
                    proyectoSwitch.calcularOperacion(signo, numero1Operar, numero2Operar);
                }
            }
            System.out.println("\nEscriba otro ejercicio a ejecutar:");
            caracter = sc.nextInt();
        }
        System.out.println("Proceso Acabado");
    }

    /*-------1 EJERCICIO IF YA ESTA HECHO EN LA GUIA--------*/

 /*2.- Escribir un método que reciba un número introducido por teclado entre 1 y 12 y devuelva el número de días que tiene ese mes.*/
    static int numeroDias(int mes) {
        int diastotales;
        diastotales = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 ->
                31;
            case 2 ->
                28;
            case 4, 6, 9, 11 ->
                30;
            default ->
                0;
        };
        return diastotales;
    }

    /*3.- Escribir un método que reciba un nombre de mes introducido por teclado y devuelva el número de días que tiene ese mes.*/
    static int numeroDiasString(String mes) {
        return switch (mes) {
            case "enero","marzo","mayo","julio","agosto","octubre","diciembre" ->
                31;
            case "abril","junio","septiembre","noviembre" ->
                30;
            case "febrero" ->
                28;
            default ->
                0;
        };
    }

    /*4. Escribir un método que reciba una letra (puede ser mayúscula o minúscula) del alfabeto por teclado y devuelva si es vocal o consonante. 
    Se considera que toda letra que no es una vocal es una consonante*/
    static void convertirLetra(int codigoASCII) {
        switch (codigoASCII) {
            case 33,37,41,47,53,97,101,105,111,117 ->
                System.out.println("Es vocal ");
            default ->
                System.out.println("Es consonante");
        }
    }

    /*5. Escribir un método que pida al usuario un número e indica si es par o impar (con switch case).*/
    static void calcularPar(int numeroPar) {

        int resultado = (numeroPar % 2);
        switch (resultado) {
            case 0 ->
                System.out.println("El numero " + numeroPar + " es par");
            default ->
                System.out.println("El numero " + numeroPar + " es impar");
        }
        /*switch (resultado){
            case 0: 
                System.out.println("El numero " + numeroPar + "es par");
        break;
            default: System.out.println("El numero" + numeroPar + "es impar");*/
    }

    /*6.- Escribir un método que pida una operación (+, -, *, /) y dos números y realice la operación indicada imprimiendo el resultado.*/
    static void calcularOperacion(String signos, double numero1Operar, double numero2Operar) {
        switch (signos) {
            case "+" ->
                System.out.println(numero1Operar + numero2Operar);
            case "-" ->
                System.out.println(numero1Operar - numero2Operar);
            case "*" ->
                System.out.println(numero1Operar * numero2Operar);
            case "/" ->
                System.out.println(numero1Operar / numero2Operar);
            default ->
                System.out.println("Signo incorrecto");
        }

        //Lo siguiente es solo un cometario de ayuda y comparación con otros ejercicios.
        /*switch (signos) {
            case "+":
                System.out.println(numero1Operar + numero2Operar);
                break;
            case "-":
                System.out.println(numero1Operar - numero2Operar);
                break;
            case "*":
                System.out.println(numero1Operar * numero2Operar);
                break;
            case "/":
                System.out.println(numero1Operar / numero2Operar);
                break;
            default:
                System.out.println("Signo incorrecto");
        }*/
    }

}
