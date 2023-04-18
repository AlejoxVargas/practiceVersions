package Principal;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Ejercicio6 {
    /*
     * Hacer un programa que lea los valores del fichero de texto “numeros.txt”
     * (0 al 9) y cree el fichero “estadistica.txt”, donde se guarde las frecuencias,
     * la moda (el número que aparece con mayor frecuencia) y la media.*/
    public static void main(String[] args) {

        File f1;
        File f2;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            f1 = new File("C:\\Users\\Alejandro Vargas\\Desktop\\numeros.txt");
            fr = new FileReader(f1);
            br = new BufferedReader(fr);
            f2 = new File("C:\\Users\\Alejandro Vargas\\Desktop\\estadistica.txt");
            fw = new FileWriter(f2);
            bw = new BufferedWriter(fw);

            String linea;
            ArrayList<Integer> contenedor = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    contenedor.add(Character.getNumericValue(linea.charAt(i)));
                }
                System.out.println(contenedor);
            }

            //Frecuencia
            int contadorNumero;
            int inicio = 0;
            double media = 0;

            for (int i = 0; i <= 9; i++, inicio++) {
                contadorNumero = 0;
                for (Integer integer : contenedor) {
                    if (inicio == integer) {
                        contadorNumero++;
                    }
                }
                if (contadorNumero == 1) {
                    System.out.println("Número " + inicio + " - " + contadorNumero + " vez");
                } else {
                    System.out.println("Número " + inicio + " - " + contadorNumero + " veces");
                }
            }

            //Moda
            int maximoNumRepeticiones = 0;
            ArrayList<Integer> moda = new ArrayList<>();

            for (int i = 0; i < contenedor.size(); i++) {
                int numRepeticiones = 0;
                for (Integer integer : contenedor) {
                    if (Objects.equals(contenedor.get(i), integer)) {
                        numRepeticiones++;
                    }
                    if (numRepeticiones > maximoNumRepeticiones) {
                        moda.add(contenedor.get(i));
                        maximoNumRepeticiones = numRepeticiones;
                    }
                }
            }
            System.out.println("Moda: " + moda);

            //Media
            for (Integer i : contenedor) {
                media += i;
            }
            System.out.printf("Media: " + "%.2f%n", media / contenedor.size());

            //Escribir


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e2) {
                System.err.println("No se ha podido cerrar");
            }
        }
    }
}
