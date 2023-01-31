package Reto2_1_7;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
7.- Escribir el ejercicio del cálculo del IMC con una función que se llama CalcularIMC al que se le 
pase el peso y la altura, y devuelva el resultado 
 */
public class IMC2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("####.###");

        double peso, estatura;
        String nombre;

        System.out.println("Escriba su Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Escriba su peso: ");
        peso = sc.nextDouble();
        System.out.println("Escriba su estatura: ");
        estatura = sc.nextDouble();

        System.out.println("Sr/a " + nombre + "su IMC es: " + df.format(IMC2.CalcularImc(peso, estatura)));

    }

    static double CalcularImc(double pesoMetodo, double estaturaMetodo) {
        return pesoMetodo / (Math.pow(estaturaMetodo, 2));
    }

    /*
    public static void IMC (double peso, double estatura) {
    double imc; 
    imc= peso/(Math.pow(estatura, 2));
    System.out.println("Tu imc es: " + imc);
    }
     */
}
