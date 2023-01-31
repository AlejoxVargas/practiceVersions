package Reto2_1_6;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
6.- Escribir el ejercicio del cálculo del IMC con un procedimiento que se llama CalcularIMC al que 
se le pase el peso y la altura e imprima el resultado 
 */
public class IMC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double peso, estatura;
        String nombre;

        System.out.println("Escriba su Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Escriba su peso: ");
        peso = sc.nextDouble();
        System.out.println("Escriba su estatura: ");
        estatura = sc.nextDouble();

        IMC.CalcularImc(nombre, peso, estatura);

        //(NOTA) Math.pow(peso, 2); se puede utilizar de igual manera que el Math asi que este es un procedimiento tambien
    }

    static void CalcularImc(String nombreMetodo, double pesoMetodo, double estaturaMetodo) {
        DecimalFormat df = new DecimalFormat("####.###");
        System.out.println("Sr/a " + nombreMetodo + " su IMC es: " + df.format(pesoMetodo / (Math.pow(estaturaMetodo, 2))));
    }
}
