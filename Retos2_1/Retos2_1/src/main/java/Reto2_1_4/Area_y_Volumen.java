package Reto2_1_4;

/*
4.- Escribir las funciones calculoAreaCilindro y calculoVolumenCilindro y llamarlas desde el main
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Area_y_Volumen {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###.00");

        double alturaCilindro, radioCilindro;

        System.out.println("Altura del cilindro: ");
        alturaCilindro = sc.nextDouble();
        System.out.println("Radio del cilindro: ");
        radioCilindro = sc.nextDouble();

        System.out.println("Cilindro \nArea: " + df.format(Area_y_Volumen.calcularAreaCilindro(alturaCilindro, radioCilindro)));
        System.out.println("Volumen: " + df.format(Area_y_Volumen.calcularVolumenCilindro(alturaCilindro, radioCilindro)));

    }

    static double calcularAreaCilindro(double altCilindro, double radCilindro) {
        return 2 * Math.PI * radCilindro * (altCilindro + radCilindro);
    }

    static double calcularVolumenCilindro(double altCilindro, double radCilindro) {
        return Math.PI * Math.pow(radCilindro, 2) * altCilindro;
    }
}
