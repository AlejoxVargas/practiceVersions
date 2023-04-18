package Principal;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio7 {
    /*
     * Escribir un programa que encripte el fichero de texto “texto.txt”
     * generando un fichero de salida con los datos encriptados.
     * La encriptación consiste en reemplazar cada carácter por el
     * tercero siguiente en el alfabeto (ej. a -> d). Si el carácter
     * es la x/y/z entonces se sustituirá por la a/b/c.
     * Mostrar el fichero resultante.
     * */
    public static void main(String[] args) {
        File f1;
        File f2;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            f1 = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\texto.txt");
            fr = new FileReader(f1);
            br = new BufferedReader(fr);
            f2 = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\encriptados.txt");
            fw = new FileWriter(f2);
            bw = new BufferedWriter(fw);

            String linea;
            ArrayList<String> contenedor = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    contenedor.add(linea);
                }
            }
            //Codificar
            String Letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String frase = contenedor.get(0);
            String caracter;
            String textoCodificado = "";

            for (int i = 0; i < contenedor.size(); i++) {
                caracter = contenedor.get(i);
                int posicion = contenedor.indexOf(caracter);
                if (posicion == -1) {
                    textoCodificado += caracter;
                } else {
                    textoCodificado += contenedor.get((posicion + 3) % contenedor.size());
                }
            }
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
