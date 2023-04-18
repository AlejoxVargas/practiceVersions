package Principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio2 {
    /*
     * Realizar un programa que muestre las n en primeras líneas del fichero de texto
     * “texto.txt”. El valor de n se pedirá al usuario y se tendrá en cuenta que
     * puede ser mayor que el número de filas del fichero.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FileReader fr;
        BufferedReader br;
        int cantidadLineas;
        int contador = 0;

        System.out.println("Cantidad de lineas a mostrar: ");
        cantidadLineas = sc.nextInt();

        try {
            fr = new FileReader("C:\\Users\\Alejandro Vargas\\Desktop\\texto.txt");
            br = new BufferedReader(fr);

            String linea = "";

            while (linea != null && contador < cantidadLineas) {
                linea = br.readLine();
                System.out.println(linea);
                contador++;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
