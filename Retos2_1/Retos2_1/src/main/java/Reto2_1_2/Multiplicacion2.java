package Reto2_1_2;

import java.util.Scanner;

/*2.-Lo mismo pero con una función que devuelve el resultado que es visualizado por el main.*/
public class Multiplicacion2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double numero;
        System.out.println("Ingrese Numero: ");
        numero = sc.nextDouble();
        System.out.println("La multiplicación es: " + Multiplicacion2.Multiplicar(numero));

    }

    static double Multiplicar(double num) {
        return num * 2;
    }
}
