package Reto2_2_1;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
1.- Hacer los cálculos del área y del perímetro del círculo con la clase Math. Los resultados deben mostrarse con 3 decimales.
 */
public class Perimetro_Area {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##.###");

        double radioCirculo;
        System.out.println("Escriba radio del circulo: ");
        radioCirculo = sc.nextDouble();

        System.out.println("Circulo:\nArea " + df.format(Perimetro_Area.calcularArea(radioCirculo)) + "\nPerimetro " + df.format(Perimetro_Area.calcularPerimetro(radioCirculo)));

    }

    static double calcularArea(double radioCirculo) {
        return Math.PI * Math.pow(radioCirculo, 2);
    }

    static double calcularPerimetro(double radioCirculo) {
        return 2 * Math.PI * radioCirculo;
    }

}
