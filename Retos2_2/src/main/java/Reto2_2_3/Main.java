package Reto2_2_3;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
3.- Escribir tres clases Rectangulo, Circulo y Cuadrado. Cada una tiene los métodos calcularArea y calcularPerimetro. 
En cada clase se añadirán los atributos  necesarios para poder calcular el área y el perímetro. Desde el programa main, declarar seis objetos dos de cada clase. 
Para algunos de los objetos, pedir los datos por teclado, en otros casos el programa dará los valores de los atributos. 
Llamar a los métodos y visualizar los resultados por pantalla.
 */

public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###.00");
        Scanner sc = new Scanner(System.in);
        double radioCirculo, rectanguloAncho, rectanguloAltura, ladoCuadrado;
        
        System.out.println("Escribir radio circulo 1: ");
        radioCirculo = sc.nextDouble();
        
        System.out.println("Escribir lado del cuadrado 1: ");
        ladoCuadrado = sc.nextDouble();
        
        System.out.println("Escribir ancho del rectangulo 1: ");
        rectanguloAncho = sc.nextDouble();
        System.out.println("Escribir altura del rectangulo 1: ");
        rectanguloAltura = sc.nextDouble();

        Circulo Circulo1 = new Circulo(radioCirculo);
        Circulo Circulo2 = new Circulo(25);

        Cuadrado Cuadrado1 = new Cuadrado (ladoCuadrado);
        Cuadrado Cuadrado2 = new Cuadrado (18);
        
        Rectangulo Rectangulo1 = new Rectangulo ( rectanguloAncho,rectanguloAltura);
        Rectangulo Rectangulo2 = new Rectangulo (32,29);
   
        System.out.println("\nCirculo 1\nArea:" + df.format(Circulo1.calcularArea()) + "\nPerimetro:" + df.format(Circulo1.cacularPerimetro()) + "\n");
        System.out.println("Circulo 2\nArea:" + df.format(Circulo2.calcularArea()) + "\nPerimetro:" + df.format(Circulo2.cacularPerimetro()) + "\n");
        
        System.out.println("Cuadrado 1\nArea:" + df.format(Cuadrado1.calcularArea()) +"\nPerimetro:" + df.format(Cuadrado1.calcularPerimetro()) + "\n");
        System.out.println("Cuadrado 2\nArea:" + df.format(Cuadrado2.calcularArea()) + "\nPerimetro:" + df.format(Cuadrado2.calcularPerimetro()) + "\n");
        
        System.out.println("Rectangulo 1\nArea:" + df.format(Rectangulo1.calcularArea()) +"\nPerimetro:" + df.format(Rectangulo2.cacularPerimetro()) + "\n");
        System.out.println("Rectangulo 2\nArea:" + df.format(Rectangulo2.calcularArea()) + "\nPerimetro:" + df.format(Rectangulo2.cacularPerimetro()) + "\n");
    }

}
