package Retos2_2_5;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
5.- Escribir una clase Circulo que tenga :

un atributo double radio
dos métodos: calculoArea y calculoPerimetro
constructor al gusto del alumno

Desde el programa principal , pedir un radio al usuario, declarar un objeto de la clase Circulo 
y llamar a los métodos de cálculo de área y de perímetro de un círculo. Imprimir los resultados con 2 y 4 decimales.
*/

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat(".00");
        DecimalFormat df4 = new DecimalFormat(".0000");
        
        double radioCirculo;
        
        System.out.println("Escriba radio del circulo: ");
        radioCirculo = sc.nextDouble();
        
        Circulo Circulo1 = new Circulo(radioCirculo);
        
        System.out.println("\nCirculo \nArea con 2 decimales: " + df.format(Circulo1.calcularaArea()));
        System.out.println("Area con 4 decimales: " + df4.format(Circulo1.calcularPerimetro()));
        
    }
}
