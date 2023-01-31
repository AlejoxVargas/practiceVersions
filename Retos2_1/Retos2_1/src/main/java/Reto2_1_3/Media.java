package Reto2_1_3;

import java.util.Scanner;

/*
3.- Escribir una función que  recibe tres números pedidos al usuario y calcula la media. La media se 
devuelve al programa principal y éste la visualiza.
 */
public class Media {

    public static void main(String[] args) {

        System.out.println("La media es: " + Media.Media());
    }

    static double Media() {
        Scanner sc = new Scanner(System.in);
        double numero1, numero2, numero3;
        System.out.println("Introduzca primer numero: ");
        numero1 = sc.nextDouble();
        System.out.println("Introduzca segundo numero: ");
        numero2 = sc.nextDouble();
        System.out.println("Introduzca tercer numero: ");
        numero3 = sc.nextDouble();

        return (numero1 + numero2 + numero3) / 3;
    }
}
