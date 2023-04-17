package Principal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
        FileWriter fw;
        BufferedWriter bw;

        try {

            f1 = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\numeros.txt");
            fr = new FileReader(f1);
            br = new BufferedReader(fr);
            /*f2 = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\estadistica.txt");
            fw = new FileWriter(f2);
            bw = new BufferedWriter(fw);*/

            String linea;
            ArrayList<Integer> contenedor = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    contenedor.add(Character.getNumericValue(linea.charAt(i)));
                }
                System.out.println(linea);
                System.out.println(contenedor.toString());
            }

            //Frecuencia
            int contadorNumero = 0;
            int inicio = 0;

                for (int i = 0; i < contenedor.size(); i++, inicio++) {
                    contadorNumero = 0;
                    for (int j = 0; j <= 9; j++ ) {
                        if (inicio == contenedor.get(j)) {
                            contadorNumero++;
                        }
                    }
                    System.out.println("Número " + inicio + " - " + contadorNumero);
                }

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
            } catch (Exception e2) {
                System.err.println("No se ha podido cerrar");
            }
        }
    }
}
