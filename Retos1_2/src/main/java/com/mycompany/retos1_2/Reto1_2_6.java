package com.mycompany.retos1_2;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
Reto 1.2.6
Escribir un programa en java que:
pida al usuario el ancho y el alto de un rectángulo y calcule su perímetro y su área
pida al usuario el radio de un círculo y calcule su perímetro y su área
pida al usuario el lado de un cuadrado y calcule su perímetro y su área
*/

public class Reto1_2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        DecimalFormat formateador = new DecimalFormat ("####.00");
        double anchoRectangulo, altoRectangulo, radioCirculo,ladoCuadrado, perimetroRectangulo,
                perimetroCirculo, perimetroCuadrado, areaRectangulo, areaCirculo, areaCuadrado;
        final double pi = 3.1415;
        System.out.println("Ancho del rectangulo: ");
        anchoRectangulo = sc.nextDouble();
        System.out.println("Altura del rectangulo: ");
        altoRectangulo = sc.nextDouble();
        System.out.println("Radio del Circulo: ");
        radioCirculo = sc.nextDouble();
        System.out.println("Lado del cuadrado: ");
        ladoCuadrado = sc.nextDouble();
        
        //Calculo de radios de las 3 figuras: 
        
        areaRectangulo = altoRectangulo*anchoRectangulo;
        areaCirculo = pi * Math.pow(radioCirculo, 2);
        areaCuadrado = Math.pow(ladoCuadrado, 2);
        
        //Calculo de perimetros de las 3 figuras
        
        perimetroRectangulo = 2*(altoRectangulo + anchoRectangulo);
        perimetroCirculo = 2*pi*radioCirculo;
        perimetroCuadrado = 4*ladoCuadrado;
        
        
        System.out.println("Rectangulo \n" + "P= " + perimetroRectangulo + "\n"+ "A= " 
        + areaRectangulo +"\n"+ "Circulo \n" + "P= " + formateador.format(perimetroCirculo) + "\n" + "A= " + 
        formateador.format(areaCirculo) + "\n" + "Cuadrado \n" + "P= " + perimetroCuadrado + "\n" + "A= " + areaCuadrado);
        
    }
}
