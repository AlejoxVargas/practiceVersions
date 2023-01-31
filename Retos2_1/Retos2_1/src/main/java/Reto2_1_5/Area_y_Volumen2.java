package Reto2_1_5;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
5.- Convertir  las funciones realizadas en procedimientos.
 */
public class Area_y_Volumen2 {

    static DecimalFormat df = new DecimalFormat("####.00");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double alturaCilindro, radioCilindro;
        
        System.out.println("Altura del cilindro: ");
        alturaCilindro = sc.nextDouble();
        System.out.println("Radio del cilindro: ");
        radioCilindro = sc.nextDouble();
        
        Area_y_Volumen2.calcularArea(alturaCilindro, radioCilindro);
        Area_y_Volumen2.calcularVolumen(alturaCilindro, radioCilindro);
    }

    static void calcularArea(double altCilindro, double radCilindro) {

        System.out.println("Cilindro \nArea: " + df.format(2 * Math.PI * radCilindro * (altCilindro + radCilindro)));
    }

    static void calcularVolumen(double altCilindro, double radCilindro) {

        System.out.println("Volumen: " + df.format(Math.PI * Math.pow(radCilindro, 2) * altCilindro));
    }
}
