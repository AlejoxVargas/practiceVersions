package Principal;

import java.io.*;

@SuppressWarnings({"DuplicateExpressions", "DataFlowIssue"})
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
            f1 = new File("C:\\Users\\Alejandro Vargas\\Desktop\\texto.txt");
            fr = new FileReader(f1);
            br = new BufferedReader(fr);
            f2 = new File("C:\\Users\\Alejandro Vargas\\Desktop\\encriptado.txt");
            fw = new FileWriter(f2);
            bw = new BufferedWriter(fw);

            String linea;
            String texto = null;

            while ((linea = br.readLine()) != null) {
                texto = linea.toUpperCase();
            }
            StringBuilder cifrado = new StringBuilder();

            int codigo = 3 % 26;
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    if ((texto.charAt(i) + codigo) > 'z') {
                        cifrado.append((char) (texto.charAt(i) + codigo - 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) + codigo));
                    }
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    if ((texto.charAt(i) + codigo) > 'Z') {
                        cifrado.append((char) (texto.charAt(i) + codigo - 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) + codigo));
                    }
                }

            }
            System.out.println(cifrado);
            bw.write(String.valueOf(cifrado));
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
