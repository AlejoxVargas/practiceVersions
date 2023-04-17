package Principal;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio3 {
    /*
     * Realizar un programa que cuente el número de líneas, caracteres y palabras
     * que tiene un fichero que se pasará por teclado. Se debe comprobar que el
     * fichero existe antes de empezar a contar.
     * */
    public static void main(String[] args) {

        File f;
        FileReader fr;
        BufferedReader br;

        try {

            f = new File("C:\\Users\\Alejandro Vargas\\Desktop\\texto.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            ArrayList<Character> contenedor = new ArrayList<>();
            String linea;
            int contadorLineas = 0;
            int contadorCaracteres = 0;
            int contadorPalabras = 0;

            if (f.exists()) {
                while ((linea = br.readLine()) != null) {
                    for (int i = 0; i < linea.length(); i++) {
                        contenedor.add(linea.charAt(i));
                    }
                    contenedor.add(' ');
                    contadorLineas++;
                    contadorCaracteres += linea.length();
                    System.out.println(linea);
                }
                for (Character character : contenedor) {
                    if (character == ' ') {
                        contadorPalabras++;
                    }
                }
                System.out.println("Numero total de lineas: " + contadorLineas);
                System.out.println("Numero de caracteres: " + contadorCaracteres);
                System.out.println("Numero total de palabras: " + contadorPalabras);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
