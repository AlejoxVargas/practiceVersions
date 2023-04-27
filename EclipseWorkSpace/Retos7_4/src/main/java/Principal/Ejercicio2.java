package Principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio2 {
    /*
     * 2.  Escribir un método que reciba por parámetro el nombre
     * de un fichero que almacena una serie de referencias y
     * precios de artículos y muestre su contenido por pantalla.
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del fichero: ");
        String fichero = sc.nextLine();
        mostrar(fichero);
    }

    public static void mostrar(String directorio) {
        try (RandomAccessFile archivo = new RandomAccessFile(new File(directorio), "rw")) {
            archivo.seek(0);
            System.out.println("Contenido del archivo:");
            while (archivo.getFilePointer() < archivo.length()) {
                int referencia = archivo.readInt();
                double precio = archivo.readDouble();
                System.out.println("Referencia: " + referencia + ", Precio: " + precio);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se ha encontrado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
