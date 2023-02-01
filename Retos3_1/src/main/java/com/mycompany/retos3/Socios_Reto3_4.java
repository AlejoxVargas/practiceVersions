package com.mycompany.retos3;

/*4. Escribe un programa, de nombre Socios, que calcule la cuota que se debe abonar en un club de paddel. 
La cuota es de 800 euros. Tendrán un 40% de descuento las personas mayores de 65 años y un 25% de descuento los menores de 21 años, 
si los padres no son socios, y un 45% si los padres son socios*/
import java.util.Scanner;

public class Socios_Reto3_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese edad: ");
        int cuota = 800, edad = sc.nextInt();
        sc.nextLine();
        if (edad <= 21) {
            System.out.println("¿Son sus padres socios?");
            String socio = sc.nextLine();
            if (socio.equalsIgnoreCase("si")) {
                int descuento45 = cuota * 45 / 100;
                System.out.println(cuota - descuento45);
            } else {
                int descuento25 = cuota * 25 / 100;
                System.out.println(cuota - descuento25);
            }
        } else if (edad >= 65) {
            int descuento40 = cuota * 40 / 100;
            System.out.println(cuota - descuento40);
        } else {
            System.out.println(cuota);
        }
    }
}
