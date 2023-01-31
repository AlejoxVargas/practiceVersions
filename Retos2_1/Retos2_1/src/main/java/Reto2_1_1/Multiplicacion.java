package Reto2_1_1;

import java.util.Scanner;

/*
1.- Escribir un procedimiento que reciba un número, lo multiplique por dos y visualice el resultado. 
Llamar a este procedimiento desde el main. Pedir el dato al usuario.
*/

public class Multiplicacion {
    
    public static void main(String[] args) {
        double numero;
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese Numero: ");
        numero = sc.nextDouble();
        Multiplicacion.multiplicar(numero);
    }
    
    static void multiplicar(double num){
        System.out.println("La multiplicación es: " + num*2);
    }
    
}
