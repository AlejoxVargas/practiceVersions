package Principal;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
    /*
     * Hacer un programa que pida al usuario una palabra
     * por teclado y diga cuántas veces aparece esa palabra
     * en el fichero "parrafo.txt".
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        File f;
        FileReader fr = null;
        BufferedReader br = null;
        String palabra;

        try {
            f = new File("C:\\Users\\Alejandro Vargas\\Desktop\\parrafo.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String linea;
            ArrayList<String> contenedor = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                contenedor.add(linea);
                System.out.println(linea);
            }

            System.out.println("Palabra: ");
            palabra = sc.nextLine();

            int posicion, contador = 0;

            for (String i : contenedor) {
                posicion = i.indexOf(palabra);
                while (posicion != -1) {
                    contador++;
                    posicion = contenedor.indexOf(palabra);
                }
            }

            System.out.println(palabra + " se repite " + contador);

        } catch (IOException e) {
            System.err.println("Fichero no encontrado");

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.err.println("No se ha podido cerrar");
            }
        }
    }
}
