package Principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    /*
    * Escribir un método que reciba por parámetro un array
    * de valores enteros correspondientes a referencias a
    * artículos y un array de valores reales correspondientes
    * a los precios de los artículos anteriores. Se podrá usar
    * también ArrayList. El método recibirá también el nombre
    * de un fichero sobre el que se escribirá cada referencia
    * de artículo seguida de su precio.
    * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> referencias = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        String directorio;
        int opcion;

        do {
            System.out.println("Referencia del articulo: ");
            referencias.add(sc.nextInt());
            System.out.println("Precio del articulo: ");
            precios.add(sc.nextDouble());
            sc.nextLine();
            System.out.println("Directorio: ");
            directorio = sc.nextLine();
            escribirArchivo(referencias, precios, directorio);
            System.out.println("""
                    ¿Quiere agregar otra referencia?
                    1.Sí
                    0.No""");
            opcion = sc.nextInt();
        } while (opcion != 0);
    }

    public static void escribirArchivo(ArrayList<Integer> referencias, ArrayList<Double> precios, String directorio) {
        try {
            RandomAccessFile archivo = new RandomAccessFile(new File(directorio), "rw");

            for (int i = 0; i < referencias.size(); i++) {
                archivo.writeInt(referencias.get(i));
                archivo.writeDouble(precios.get(i));
            }

            archivo.seek(0);

            System.out.println("Contenido del archivo:");
            while (archivo.getFilePointer() < archivo.length()) {
                int referencia = archivo.readInt();
                double precio = archivo.readDouble();
                System.out.println("Referencia: " + referencia + ", Precio: " + precio);
            }

            archivo.close();
            System.out.println("Se ha escrito en el archivo correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se ha encontrado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
