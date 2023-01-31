package com.mycompany.retos3;

import java.util.Scanner;

public class Retos_3_1_IF_Alejandro_Vargas {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Retos_3_1_IF_Alejandro_Vargas.requestExercise();
    }

    /*No se pedían las llamadas desde el main en estos ejercicios, pero por eficacia y rapidez, lo he añadido, 
    se puede elegir el ejercicio a usar tecleando el número de ejercicio, y si se pulsa 0 este terminará su ejecución.*/
    public static void requestExercise() {
        System.out.println("Escriba ejercicio a ejecutar: ");
        int caracter = sc.nextInt();
        while (caracter != 0) {
            switch (caracter) {
                case 1 ->
                    Retos_3_1_IF_Alejandro_Vargas.numParImpar();
                case 2 ->
                    Retos_3_1_IF_Alejandro_Vargas.genderQuestions();
                case 3 ->
                    Retos_3_1_IF_Alejandro_Vargas.ratingScore();
                case 4 ->
                    Retos_3_1_IF_Alejandro_Vargas.membersDiscount();
                case 5 ->
                    Retos_3_1_IF_Alejandro_Vargas.validDate();
            }
            System.out.println("\nEscriba otro ejercicio a ejecutar:");
            caracter = sc.nextInt();
        }
        System.out.println("Proceso Acabado");
    }

    /*1.- Escribir un programa que determine si un número introducido por teclado es par o impar. Hacer 
una segunda versión comprobando además si es negativo o positivo.*/
    public static void numParImpar() {
        System.out.println("1.Escribir un programa que determine si un número introducido por teclado es par o impar.\nHacer una segunda versión comprobando además si es negativo o positivo.\n");
        System.out.println("Introducir numero: ");
        int numero = sc.nextInt();
        if (numero % 2 != 0) {
            System.out.print("Numero " + numero + " es impar");
        } else {
            System.out.print("Numero " + numero + " es par");

        }
        if (numero < 0) {
            System.out.println(" y es un numero negativo");
        } else {
            System.out.println(" y es un numero positivo");
        }
    }

    /*  2- Escribir un programa que reciba los datos de una persona por teclado: nombre, edad y sexo ('H/M') y saque por pantalla
indicando el nombre, si es mayor de edad y si es una mujer o un hombre*/
    public static void genderQuestions() {
        System.out.println("2- Escribir un programa que reciba los datos de una persona por teclado: nombre, edad y sexo ('H/M') y saque por pantalla\n"
                + "indicando el nombre, si es mayor de edad y si es una mujer o un hombre.\n");
        sc.nextLine();
        System.out.println("Escribir nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Escribir edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribir sexo: ");
        String sexo = sc.nextLine();
        String resultadoEdad = (edad < 18) ? " es menor de edad" : " es mayor de edad";
        if (sexo.equalsIgnoreCase("H") || sexo.equalsIgnoreCase("hombre")) {
            System.out.println(nombre + resultadoEdad + " y es hombre");
        } else {
            System.out.println(nombre + resultadoEdad + " y es mujer");
        }
    }

    /*
3- Escribir un programa que pida la nota de un examen (un numero real 0 y 10) e imprima por pantalla la calicación:
º "Suspendió", si la nota es menor que 5,
º "Aprobado", si esta entre 5 y 7 sin incluirlo,
º "Notable", si esta entre 7 y 9 sin incluirlo, 
º "Sobresaliente" si esta entre 9 y 10 sin incluirlo, 
º "Matricula de honor" si la nota es igual a 10. 
º "Fuera de rango" si no es ninguno de los casos anteriores
     */
    public static void ratingScore() {
        System.out.println("3- Escribir un programa que pida la nota de un examen (un numero real 0 y 10) e imprima por pantalla la calicación:\n"
                + "º \"Suspendió\", si la nota es menor que 5,\n"
                + "º \"Aprobado\", si esta entre 5 y 7 sin incluirlo,\n"
                + "º \"Notable\", si esta entre 7 y 9 sin incluirlo, \n"
                + "º \"Sobresaliente\" si esta entre 9 y 10 sin incluirlo, \n"
                + "º \"Matricula de honor\" si la nota es igual a 10. \n"
                + "º \"Fuera de rango\" si no es ninguno de los casos anteriores\n");
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

    /*
4. Escribe un programa, de nombre Socios, que calcule la cuota que se debe abonar en un club de paddel. 
La cuota es de 800 euros. Tendrán un 40% de descuento las personas mayores de 65 años y un 25% de descuento los menores de 21 años, 
si los padres no son socios, y un 45% si los padres son socios.
     */
    public static void membersDiscount() {
        System.out.println("4. Escribe un programa, de nombre Socios, que calcule la cuota que se debe abonar en un club de paddel. \n"
                + "La cuota es de 800 euros. Tendrán un 40% de descuento las personas mayores de 65 años y un 25% de descuento los menores de 21 años, \n"
                + "si los padres no son socios, y un 45% si los padres son socios.\n");
        System.out.println("Ingrese edad: ");
        int cuota = 800, edad = sc.nextInt();
        sc.nextLine();
        if (edad <= 21) {
            System.out.println("¿Son sus padres socios?");
            String socio = sc.nextLine();
            if (socio.equalsIgnoreCase("si")) {
                int descuento45 = cuota * 45 / 100;
                System.out.println(cuota - descuento45);
            } else {
                int descuento25 = cuota * 25 / 100;
                System.out.println(cuota - descuento25);
            }
        } else if (edad >= 65) {
            int descuento40 = cuota * 40 / 100;
            System.out.println(cuota - descuento40);
        } else {
            System.out.println(cuota);
        }
    }

    /*5. Escribe un método, de nombre esFechaValida, que reciba como parámetros tres valores enteros con el día, 
    mes y año de una fecha y devuelva un valor booleano que indique si se trata de valores válidos para una fecha.*/
    public static void validDate() {
        System.out.println("Escribe un método, de nombre esFechaValida, que reciba como parámetros tres valores enteros con el día, \n"
                + "mes y año de una fecha y devuelva un valor booleano que indique si se trata de valores válidos para una fecha.\n");
        System.out.println("Día: ");
        int dia = sc.nextInt();
        System.out.println("Mes: ");
        int mes = sc.nextInt();
        System.out.println("Año: ");
        int anyo = sc.nextInt();

        boolean resultado = true;
        if (mes < 1 && mes > 12) {
            resultado = false;
        }
        if (anyo < 1500 || anyo > 3100) {
            resultado = false;
        }
        if ((anyo % 4 == 0) && (anyo % 100 != 0) || (anyo % 400 == 0) && (mes == 2 && dia <= 29)) {
            resultado = true;
        } else if (mes == 2 && dia > 28) {
            resultado = false;
        }
        if ((mes == 1 && dia > 31) || (mes == 3 && dia > 31) || (mes == 5 && dia > 31) || (mes == 7 && dia > 31) || (mes == 8 && dia > 31) || (mes == 10 && dia > 31) || (mes == 12 && dia > 31)) {
            resultado = false;
        }
        if ((mes == 4 && dia > 30) || (mes == 6 && dia > 30) || (mes == 9 && dia > 30) || (mes == 11 && dia > 30)) {
            resultado = false;
        }
        System.out.println(resultado);
    }
}
