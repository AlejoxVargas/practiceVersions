package com.mycompany.retos3;

/*5. Escribe un método, de nombre esFechaValida, que reciba como parámetros tres valores enteros con el día, 
mes y año de una fecha y devuelva un valor booleano que indique si se trata de valores válidos para una fecha.*/

import java.util.Scanner;

public class Retos3_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Día: ");
        int dia = sc.nextInt();
        System.out.println("Mes: ");
        int mes = sc.nextInt();
        System.out.println("Año: ");
        int anyo = sc.nextInt();

        System.out.println(Retos3_5.esFechaValida(dia, mes, anyo));
    }

    public static boolean esFechaValida(int dia, int mes, int anyo) {
        boolean resultado = true;
        if (mes < 1 && mes > 12) {
            resultado = false;
        }
        if (anyo < 1500 || anyo > 3100) {
            resultado = false;
        }
        if ((anyo % 4 == 0) && (anyo % 100 != 0) || (anyo % 400 == 0) && (mes == 2 && dia <= 29)) {
            resultado = true;
        }
        else if (mes == 2 && dia > 28) {
            resultado = false;
        }
        if ((mes == 1 && dia > 31) || (mes == 3 && dia > 31) || (mes == 5 && dia > 31) || (mes == 7 && dia > 31) || (mes == 8 && dia > 31) || (mes == 10 && dia > 31) || (mes == 12 && dia > 31)) {
            resultado = false;
        }
        if ((mes == 4 && dia > 30) || (mes == 6 && dia > 30) || (mes == 9 && dia > 30) || (mes == 11 && dia > 30)) {
            resultado = false;
        }
        return resultado;
    }
}
