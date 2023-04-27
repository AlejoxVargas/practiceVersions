package Principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    /*
    * 3. Realizar un método que reciba por parámetro el nombre
    * de un fichero que almacena una serie de referencias y precios
    * de artículos y actualice los precios de forma que los superiores
    * a 100 euros se decrementen en un 50% y los inferiores se incrementen
    * en un 50%. El método capturará y tratará todas las excepciones que
    *  puedan producirse.
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

    /*
     * Actualice los precios de forma que los superiores
     * a 100 euros se decrementen en un 50% y los inferiores se incrementen
     * en un 50%.
     * */
    public static void escribirArchivo(ArrayList<Integer> referencias, ArrayList<Double> precios, String directorio) {
        try (RandomAccessFile archivo = new RandomAccessFile(new File(directorio), "rw")) {
            for (int i = 0; i < referencias.size(); i++) {
                archivo.writeInt(referencias.get(i));
                archivo.writeDouble(precios.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se ha encontrado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
