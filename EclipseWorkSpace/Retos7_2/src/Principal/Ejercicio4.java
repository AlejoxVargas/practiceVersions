package Principal;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio4 {
    /*
     * Hacer un programa, que modifique el fichero “texto.txt”,
     * insertando un * delante de cada vocal.
     * Mostrar el fichero “texto.txt” resultante.
     * */

    public static void main(String[] args) {
        File f;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            f = new File("C:\\Users\\Alejandro Vargas\\Desktop\\texto.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);

            String linea;
            ArrayList<Character> contenedor = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    contenedor.add(linea.charAt(i));
                }
                System.out.println(linea);
            }
            for (Character i : contenedor) {
                if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
                    bw.write('*');
                }
                bw.write(i);
            }
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
