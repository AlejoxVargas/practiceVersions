package Principal;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class Ejercicio6 {
    /*
     * Hacer un programa que lea los valores del fichero de texto “numeros.txt”
     * (0 al 9) y cree el fichero “estadistica.txt”, donde se guarde las frecuencias,
     * la moda (el número que aparece con mayor frecuencia) y la media.*/
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");

        File f1;
        File f2;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            f1 = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\numeros.txt");
            fr = new FileReader(f1);
            br = new BufferedReader(fr);
            f2 = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\estadistica.txt");
            fw = new FileWriter(f2);
            bw = new BufferedWriter(fw);

            String linea;
            ArrayList<Integer> contenedor = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                bw.write("[");
                for (int i = 0; i < linea.length(); i++) {
                    contenedor.add(Character.getNumericValue(linea.charAt(i)));
                    bw.write(linea.charAt(i));
                    bw.write(", ");
                }
                bw.write("]");
                System.out.println(contenedor);
                bw.newLine();
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
                    bw.write("Número " + inicio + " - " + contadorNumero + " vez");
                    bw.newLine();
                } else {
                    System.out.println("Número " + inicio + " - " + contadorNumero + " veces");
                    bw.write("Número " + inicio + " - " + contadorNumero + " veces");
                    bw.newLine();
                }
            }
            int maximoNumRepeticiones = 1;
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
            for (int i = 0; i < contenedor.size(); i++) {
                int numRepeticiones = 0;
                for (Integer integer : contenedor) {
                    if (Objects.equals(contenedor.get(i), integer)) {
                        numRepeticiones++;
                    }
                    if (numRepeticiones == maximoNumRepeticiones) {
                        moda.add(contenedor.get(i));
                        maximoNumRepeticiones = numRepeticiones;
                    }
                }
            }
            System.out.println("Moda: " + moda);
            /**
             * Ha habido avance al hacer otro for he igualarlo al maximo de repeticiones
             * ya puedo leer todas las modas que son iguales, pero me saca un flujo de numeros
             * más largo de lo que debería, es un pequeño bug que con depurador se puede solucionar
             * fecha: 19/04/23
             * solucionar para mañana
             * */

            //Media
            for (Integer i : contenedor) {
                media += i;
            }
            double resultado = media / contenedor.size();
            System.out.printf("Media: " + "%.2f%n", media / contenedor.size());
            bw.newLine();
            bw.write("Media: " + df.format(resultado));

        } catch (
                Exception e) {
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
